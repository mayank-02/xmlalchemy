package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import edu.ucsd.xmlalchemy.Expression;
import edu.ucsd.xmlalchemy.Tuple;

public class QueryConditionExistentialQuantifier implements Expression {
    private final List<Tuple<String, Expression>> iterators;
    private final Expression condition;

    public QueryConditionExistentialQuantifier(List<Tuple<String, Expression>> iterators, Expression condition) {
        this.iterators = iterators;
        this.condition = condition;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) {
        return evaluateIterators(ctx, 0);
    }

    private boolean evaluateIterators(Context ctx, int depth) {
        if (depth == iterators.size()) {
            return condition.evaluateQueryCondition(ctx);
        }
        var iterator = iterators.get(depth);
        var intermediateValues = iterator.second.evaluateQuery(ctx);
        for (var intermediateValue : intermediateValues) {
            ctx.setVar(iterator.first, List.of(intermediateValue));
            // NOTE: immediately break the backtracking process when one true value is found.
            if (evaluateIterators(ctx, depth + 1)) {
                ctx.unwind(1);
                return true;
            }
            ctx.unwind(1);
        }
        return false;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("some ");
        for (int i = 0; i < iterators.size(); i++) {
            var iterator = iterators.get(i);
            sb.append(String.format("$%s in %s", iterator.first, iterator.second.toString()));
            if (i != iterators.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(String.format(" satisfies %s", condition.toString()));
        return sb.toString();
    }
}
