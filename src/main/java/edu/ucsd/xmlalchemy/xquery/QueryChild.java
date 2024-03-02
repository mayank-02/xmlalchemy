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
    public List<Node> evaluateQuery(Context ctx) throws Exception {
        List<Node> queryNodes = query.evaluateQuery(ctx);
        List<Node> result = relativePath.evaluate(queryNodes);

        // Remove duplicates using a LinkedHashSet
        var uniqueNodes = new LinkedHashSet<>(result);

        return new ArrayList<>(uniqueNodes);
    }

    @Override
    public String toString() {
        return String.format("%s/%s", query.toString(), relativePath.toString());
    }
}