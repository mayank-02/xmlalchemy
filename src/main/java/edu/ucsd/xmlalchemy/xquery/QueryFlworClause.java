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
}
