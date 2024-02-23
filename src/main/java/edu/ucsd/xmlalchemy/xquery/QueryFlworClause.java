package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Tuple;
import edu.ucsd.xmlalchemy.xpath.Expression;

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
    public List<Node> evaluateQuery(Context ctx, List<Node> nodes) throws Exception {
        result.clear();
        evaluateIterators(ctx, nodes, 0);
        return result;
    }

    private void evaluateIterators(Context ctx, List<Node> nodes, int depth) throws Exception {
        if (depth == iterators.size()) {
            evaluateAssignments(ctx, nodes);
            return;
        }
        var iterator = iterators.get(depth);
        var intermediateValues = iterator.second.evaluateQuery(ctx, nodes);
        for (var intermediateValue : intermediateValues) {
            ctx.setVar(iterator.first, List.of(intermediateValue));
            evaluateIterators(ctx, nodes, depth + 1);
            ctx.unwind(1);
        }
    }

    private void evaluateAssignments(Context ctx, List<Node> nodes) throws Exception {
        for (var assignment : assignments) {
            ctx.setVar(assignment.first, assignment.second.evaluateQuery(ctx, nodes));
        }

        var allNodes = returnExpression.evaluateQuery(ctx, nodes);
        if (condition != null) {
            allNodes = condition.evaluateQuery(ctx, allNodes);
        }

        result.addAll(allNodes);
        ctx.unwind(assignments.size());
    }
}
