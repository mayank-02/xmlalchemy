package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;
import edu.ucsd.xmlalchemy.Tuple;

public class QueryFlworClause implements Expression {
    private final List<Tuple<String, Expression>> iterators;
    private final List<Tuple<String, Expression>> assignments;
    private final Expression condition;
    private final Expression returnExpression;
    private final List<Node> result = new ArrayList<>();

    public QueryFlworClause(List<Tuple<String, Expression>> iterators,
            List<Tuple<String, Expression>> assignments, Expression condition,
            Expression returnExpression) {
        this.iterators = iterators;
        this.assignments = assignments;
        this.condition = condition;
        this.returnExpression = returnExpression;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) throws Exception {
        result.clear();
        evaluateIterators(ctx, 0);
        return result;
    }

    private void evaluateIterators(Context ctx, int depth) throws Exception {
        if (depth == iterators.size()) {
            evaluateAssignments(ctx);
            return;
        }
        var iterator = iterators.get(depth);
        var intermediateValues = iterator.second.evaluateQuery(ctx);
        for (var intermediateValue : intermediateValues) {
            ctx.setVar(iterator.first, List.of(intermediateValue));
            evaluateIterators(ctx, depth + 1);
            ctx.unwind(1);
        }
    }

    private void evaluateAssignments(Context ctx) throws Exception {
        for (var assignment : assignments) {
            ctx.setVar(assignment.first, assignment.second.evaluateQuery(ctx));
        }

        if (condition != null && !condition.evaluateQueryCondition(ctx)) {
            return;
        }

        var allNodes = returnExpression.evaluateQuery(ctx);
        result.addAll(allNodes);
        ctx.unwind(assignments.size());
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("for ");
        for (int i = 0; i < iterators.size(); i++) {
            var iterator = iterators.get(i);
            sb.append(String.format("$%s in %s", iterator.first, iterator.second.toString()));
            if (i != iterators.size() - 1) {
                sb.append(", ");
            }
        }
        if (!assignments.isEmpty()) {
            sb.append(" let ");
            for (int i = 0; i < assignments.size(); i++) {
                var assignment = assignments.get(i);
                sb.append(String.format("$%s := %s", assignment.first, assignment.second.toString()));
                if (i != assignments.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        if (condition != null) {
            sb.append(String.format(" where %s", condition.toString()));
        }
        sb.append(String.format(" return %s", returnExpression.toString()));
        return sb.toString();
    }

    public List<Tuple<String, Expression>> getIterators() {
        return iterators;
    }

    public List<Tuple<String, Expression>> getAssignments() {
        return assignments;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getReturnExpression() {
        return returnExpression;
    }
}
