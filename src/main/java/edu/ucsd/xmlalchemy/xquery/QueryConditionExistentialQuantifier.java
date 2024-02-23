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
    private final HashSet<Node> result = new LinkedHashSet<>();

    public QueryConditionExistentialQuantifier(List<Tuple<String, Expression>> iterators, Expression condition) {
        this.iterators = iterators;
        this.condition = condition;
    }

    @Override
    public List<Node> evaluate(Context ctx, List<Node> nodes) throws Exception {
        result.clear();
        evaluateIterators(ctx, nodes, 0);
        return new ArrayList<>(result);
    }

    private void evaluateIterators(Context ctx, List<Node> nodes, int depth) throws Exception {
        if (depth == iterators.size()) {
            evaluateCondition(ctx, nodes);
            return;
        }
        var iterator = iterators.get(depth);
        var intermediateValues = iterator.second.evaluate(ctx, nodes);
        for (var intermediateValue : intermediateValues) {
            ctx.setVar(iterator.first, List.of(intermediateValue));
            evaluateIterators(ctx, nodes, depth + 1);
            ctx.unwind(1);
        }
    }

    private void evaluateCondition(Context ctx, List<Node> nodes) throws Exception {
        result.addAll(condition.evaluate(ctx, nodes));
    }
}
