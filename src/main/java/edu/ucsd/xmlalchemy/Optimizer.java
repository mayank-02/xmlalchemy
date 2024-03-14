package edu.ucsd.xmlalchemy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import edu.ucsd.xmlalchemy.xpath.*;
import edu.ucsd.xmlalchemy.xquery.*;

public class Optimizer {
    private Optimizer() {}

    public static Expression optimize(Expression expression) {
        return flworToJoinClause(expression);
    }

    private static Expression flworToJoinClause(Expression expression) {
        // Only FLWOR clauses can be optimized
        if (!(expression instanceof QueryFlworClause)) {
            return expression;
        }
        var flwor = (QueryFlworClause) expression;

        // LET clause is not supported
        if (!flwor.getAssignments().isEmpty()) {
            return expression;
        }

        // Validate FOR clause
        if (!validateForClause(flwor)) {
            return expression;
        }

        // Validate WHERE clause
        if (!validateWhereClause(flwor.getCondition())) {
            return expression;
        }

        // Validate RETURN clause
        if (!validateReturnClause(flwor.getReturnExpression())) {
            return expression;
        }

        var varDeps = createVariableDependencies(flwor);

        // If all iterators depend on a single variable, there is nothing to optimize
        if (varDeps.values().stream().distinct().count() == 1) {
            return expression;
        }

        var equalityConditions = getEqualityConditions(flwor.getCondition());

        var joinOrder = WongYoussefiAlgorithm(varDeps, equalityConditions);
        var joinFlworClauses =
                constructJoinFlworClauses(flwor, varDeps, equalityConditions, joinOrder);

        var joinClause =
                constructJoinClause(joinOrder, joinFlworClauses, varDeps, equalityConditions);

        var rewrittenReturn = rewriteReturnExpression(flwor.getReturnExpression());

        return new QueryFlworClause(List.of(new Tuple<String, Expression>("tuple", joinClause)),
                new ArrayList<>(), null, rewrittenReturn);
    }

    private static Expression rewriteReturnExpression(Expression expression) {
        if (expression instanceof QueryElement element) {
            return new QueryElement(element.getTagName(),
                    rewriteReturnExpression(element.getQuery()));
        } else if (expression instanceof QueryConcatenation concatenation) {
            return new QueryConcatenation(rewriteReturnExpression(concatenation.getLeftQuery()),
                    rewriteReturnExpression(concatenation.getRightQuery()));
        } else if (expression instanceof Variable variable) {
            // $tuple/a1/*
            return new QueryChild(new Variable("tuple"),
                    new RelativePathChild(new TagName(variable.getName()), new Wildcard()));
        }
        return rewriteVariableInPath(expression);
    }

    private static Expression rewriteVariableInPath(Expression expression) {
        if (expression instanceof QueryAbsolutePath) {
            return expression;
        } else if (expression instanceof QueryChild queryChild) {
            return new QueryChild(rewriteVariableInPath(queryChild.getQuery()),
                    queryChild.getRelativePath());
        } else if (expression instanceof QueryDescendant queryDescendant) {
            return new QueryDescendant(rewriteVariableInPath(queryDescendant.getQuery()),
                    queryDescendant.getRelativePath());
        } else if (expression instanceof Variable variable) {
            return new QueryChild(new Variable("tuple"),
                    new RelativePathChild(new TagName(variable.getName()), new Wildcard()));
        }
        return null;
    }

    private static JoinClause constructJoinClause(List<String> joinOrder,
            List<QueryFlworClause> joinFlworClauses, Map<String, String> varDeps,
            List<QueryConditionValueEqual> equalityConditions) {
        var joinConditions = new HashMap<Tuple<String, String>, List<Tuple<String, String>>>();
        for (var condition : equalityConditions) {
            if (condition.getLeftQuery() instanceof StringLiteral
                    || condition.getRightQuery() instanceof StringLiteral) {
                continue;
            }
            var left = ((Variable) condition.getLeftQuery()).getName();
            var right = ((Variable) condition.getRightQuery()).getName();

            if (varDeps.get(left).equals(varDeps.get(right))) {
                continue;
            }
            var tuple = new Tuple<>(varDeps.get(left), varDeps.get(right));
            var reverseTuple = new Tuple<>(varDeps.get(right), varDeps.get(left));

            joinConditions.computeIfAbsent(tuple, k -> new ArrayList<>())
                    .add(new Tuple<>(left, right));
            joinConditions.computeIfAbsent(reverseTuple, k -> new ArrayList<>())
                    .add(new Tuple<>(right, left));
        }

        var leftAttrs = new ArrayList<String>();
        var rightAttrs = new ArrayList<String>();
        for (var condition : joinConditions
                .getOrDefault(new Tuple<>(joinOrder.get(0), joinOrder.get(1)), List.of())) {
            leftAttrs.add(condition.first);
            rightAttrs.add(condition.second);
        }

        var joinClause = new JoinClause(joinFlworClauses.get(0), joinFlworClauses.get(1), leftAttrs,
                rightAttrs);
        for (var i = 2; i < joinOrder.size(); i++) {
            var right = joinFlworClauses.get(i);
            leftAttrs = new ArrayList<String>();
            rightAttrs = new ArrayList<String>();
            for (int j = 0; j < i; j++) {
                if (joinConditions.containsKey(new Tuple<>(joinOrder.get(j), joinOrder.get(i)))) {
                    for (var condition : joinConditions
                            .get(new Tuple<>(joinOrder.get(j), joinOrder.get(i)))) {
                        leftAttrs.add(condition.first);
                        rightAttrs.add(condition.second);
                    }
                }
            }
            joinClause = new JoinClause(joinClause, right, leftAttrs, rightAttrs);
        }

        return joinClause;
    }


    private static List<QueryFlworClause> constructJoinFlworClauses(QueryFlworClause flwor,
            Map<String, String> varDeps, List<QueryConditionValueEqual> equalityConditions,
            List<String> joinOrder) {
        var iteratorsMapping = new HashMap<String, List<Tuple<String, Expression>>>();
        for (var iterator : flwor.getIterators()) {
            var node = iterator.first;
            var parent = varDeps.get(node);
            iteratorsMapping.computeIfAbsent(parent, k -> new ArrayList<>()).add(iterator);
        }

        var conditionsMapping = new HashMap<String, Expression>();
        for (var condition : equalityConditions) {
            var node = "";
            if (condition.getLeftQuery() instanceof StringLiteral) {
                node = varDeps.get(((Variable) condition.getRightQuery()).getName());
            } else if (condition.getRightQuery() instanceof StringLiteral) {
                node = varDeps.get(((Variable) condition.getLeftQuery()).getName());
            } else {
                var left = ((Variable) condition.getLeftQuery()).getName();
                var right = ((Variable) condition.getRightQuery()).getName();
                if (varDeps.get(left).equals(varDeps.get(right))) {
                    node = varDeps.get(left);
                } else {
                    continue;
                }
            }
            if (conditionsMapping.containsKey(node)) {
                conditionsMapping.put(node,
                        new QueryConditionAnd(conditionsMapping.get(node), condition));
            } else {
                conditionsMapping.put(node, condition);
            }
        }

        var returnExprMapping = new HashMap<String, Expression>();
        for (var entry : iteratorsMapping.entrySet()) {
            var iterators = entry.getValue();
            Expression returnAttributes = null;
            for (var iterator : iterators) {
                var element = new QueryElement(iterator.first, new Variable(iterator.first));
                if (returnAttributes != null) {
                    returnAttributes = new QueryConcatenation(returnAttributes, element);
                } else {
                    returnAttributes = element;
                }
            }
            if (returnAttributes == null) {
                throw new IllegalArgumentException("Return attributes cannot be null");
            }
            returnExprMapping.put(entry.getKey(), new QueryElement("tuple", returnAttributes));
        }

        var joinFlworClauses = new ArrayList<QueryFlworClause>();
        for (var i = 0; i < joinOrder.size(); i++) {
            joinFlworClauses.add(new QueryFlworClause(iteratorsMapping.get(joinOrder.get(i)),
                    new ArrayList<>(), conditionsMapping.get(joinOrder.get(i)),
                    returnExprMapping.get(joinOrder.get(i))));
        }

        return joinFlworClauses;
    }

    private static List<String> WongYoussefiAlgorithm(Map<String, String> varDeps,
            List<QueryConditionValueEqual> conditions) {
        var startNode = "";
        var adjacencyList = new HashMap<String, HashSet<String>>();
        for (var entry : varDeps.entrySet()) {
            if (entry.getValue().equals(entry.getKey())) {
                adjacencyList.put(entry.getKey(), new HashSet<>());
            }
        }

        for (var condition : conditions) {
            if (condition.getLeftQuery() instanceof StringLiteral) {
                startNode = varDeps.get(((Variable) condition.getRightQuery()).getName());
            } else if (condition.getRightQuery() instanceof StringLiteral) {
                startNode = varDeps.get(((Variable) condition.getLeftQuery()).getName());
            } else {
                var left = ((Variable) condition.getLeftQuery()).getName();
                var right = ((Variable) condition.getRightQuery()).getName();
                if (!varDeps.get(left).equals(varDeps.get(right))) {
                    adjacencyList.computeIfAbsent(varDeps.get(left), k -> new HashSet<>())
                            .add(varDeps.get(right));
                    adjacencyList.computeIfAbsent(varDeps.get(right), k -> new HashSet<>())
                            .add(varDeps.get(left));
                }
            }
        }

        if (startNode.isEmpty()) {
            startNode = varDeps.values().stream().findFirst().get();
        }

        var joinOrder = new ArrayList<String>();
        var visited = new HashSet<>();
        var queue = new ArrayDeque<String>();
        var searchStartNodes = new ArrayList<>(varDeps.values());
        searchStartNodes.remove(startNode);
        searchStartNodes.add(0, startNode);
        for (var searchStart : searchStartNodes) {
            if (visited.contains(searchStart)) {
                continue;
            }
            queue.add(searchStart);
            visited.add(searchStart);
            while (!queue.isEmpty()) {
                var node = queue.removeFirst();
                joinOrder.add(node);
                for (var neighbor : adjacencyList.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return joinOrder;
    }

    private static List<QueryConditionValueEqual> getEqualityConditions(Expression queryCondition) {
        if (queryCondition instanceof QueryConditionValueEqual) {
            return new ArrayList<>(Arrays.asList((QueryConditionValueEqual) queryCondition));
        } else if (queryCondition instanceof QueryConditionAnd and) {
            return Stream
                    .concat(getEqualityConditions(and.getLeftQueryCondition()).stream(),
                            getEqualityConditions(and.getRightQueryCondition()).stream())
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("Optimizer only supports AND and EQ query conditions");
    }

    private static Map<String, String> createVariableDependencies(QueryFlworClause flwor) {
        var map = new HashMap<String, String>();
        for (var iterator : flwor.getIterators()) {
            var child = iterator.first;
            var parent = getVariableFromPath(iterator.second);
            if (parent != null) {
                map.put(child, map.get(parent));
            } else {
                map.put(child, child);
            }
        }

        return map;
    }

    private static String getVariableFromPath(Expression expression) {
        if (expression instanceof QueryAbsolutePath) {
            return null;
        } else if (expression instanceof QueryChild child) {
            return getVariableFromPath(child.getQuery());
        } else if (expression instanceof QueryDescendant descendant) {
            return getVariableFromPath(descendant.getQuery());
        } else if (expression instanceof Variable variable) {
            return variable.getName();
        }
        return null;
    }

    private static boolean validateForClause(QueryFlworClause flwor) {
        for (var iterator : flwor.getIterators()) {
            if (!validatePath(iterator.second)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateWhereClause(Expression expression) {
        // Cond ::= (Var|Constant) 'eq' (Var|Constant)
        // | Cond 'and' Cond
        if (expression instanceof QueryConditionAnd and) {
            return validateWhereClause(and.getLeftQueryCondition())
                    && validateWhereClause(and.getRightQueryCondition());
        } else if (expression instanceof QueryConditionValueEqual equal) {
            return (Utils.isTypeOf(equal.getLeftQuery(), Variable.class, StringLiteral.class)
                    && Utils.isTypeOf(equal.getRightQuery(), Variable.class, StringLiteral.class));
        }
        return false;
    }

    private static boolean validateReturnClause(Expression expression) {
        // Return ::= Var
        // | Return ',' Return
        // | '<'n'>' Return '</'n'>'
        // | Path
        if (expression instanceof Variable) {
            return true;
        } else if (expression instanceof QueryConcatenation concatenation) {
            return validateReturnClause(concatenation.getLeftQuery())
                    && validateReturnClause(concatenation.getRightQuery());
        } else if (expression instanceof QueryElement element) {
            return validateReturnClause(element.getQuery());
        }
        return validatePath(expression);
    }

    private static boolean validatePath(Expression expression) {
        // Path ::= ('doc('FileName')'| Var) Sep n1 Sep ... Sep nm
        // | ('doc('FileName')'| Var) Sep n1 Sep ... Sep 'text()'
        if (!(Utils.isTypeOf(expression, Variable.class, QueryAbsolutePath.class, QueryChild.class,
                QueryDescendant.class))) {
            return false;
        }

        // Sep ::= '/' | '//'
        if (expression instanceof QueryChild queryChild) {
            if (!validatePath(queryChild.getQuery())) {
                return false;
            }
        }
        if (expression instanceof QueryDescendant queryDescendant) {
            if (!validatePath(queryDescendant.getQuery())) {
                return false;
            }
        }

        return true;
    }
}
