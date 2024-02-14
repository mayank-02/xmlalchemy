package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionEmpty implements Expression {
    private final Expression query;

    public QueryConditionEmpty(Expression query) {
        this.query = query;
    }

    @Override
    public List<Node> evaluate(Context ctx, List<Node> nodes) throws Exception {
        var result = new ArrayList<Node>();
        for (var node : nodes) {
            var queryResult = query.evaluate(ctx, List.of(node));
            if (queryResult.isEmpty()) {
                result.add(node);
            }
        }
        return result;
    }
}
