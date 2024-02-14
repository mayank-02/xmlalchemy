package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryChild implements Expression {
    private final Expression query;
    private final Expression relativePath;

    public QueryChild(Expression query, Expression relativePath) {
        this.query = query;
        this.relativePath = relativePath;
    }

    @Override
    public List<Node> evaluate(Context ctx, List<Node> nodes) throws Exception {
        List<Node> queryNodes = query.evaluate(ctx, nodes);
        List<Node> result = relativePath.evaluate(queryNodes);

        // Remove duplicates using a LinkedHashSet
        var uniqueNodes = new LinkedHashSet<>(result);

        return new ArrayList<>(uniqueNodes);
    }
}