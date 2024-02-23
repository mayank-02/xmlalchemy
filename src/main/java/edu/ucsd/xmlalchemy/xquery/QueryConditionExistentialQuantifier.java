package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Tuple;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionExistentialQuantifier implements Expression {
    private final List<Tuple<String, Expression>> iterators;
    private final Expression condition;

    public QueryConditionExistentialQuantifier(List<Tuple<String, Expression>> iterators, Expression condition) {
        this.iterators = iterators;
        this.condition = condition;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) throws Exception {
        return evaluateIterators(ctx, 0);
    }

    private boolean evaluateIterators(Context ctx, int depth) throws Exception {
        if (depth == iterators.size()) {
            return condition.evaluateQueryCondition(ctx);
        }
        var iterator = iterators.get(depth);
        var intermediateValues = iterator.second.evaluateQuery(ctx, new ArrayList<>());
        for (var intermediateValue : intermediateValues) {
            ctx.setVar(iterator.first, List.of(intermediateValue));
            // NOTE: immediately break the backtracking process when one true value is found.
            if (evaluateIterators(ctx, depth + 1)) {
                return true;
            };
            ctx.unwind(1);
        }
        return false;
    }
}
