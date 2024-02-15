package edu.ucsd.xmlalchemy.xquery;

import edu.ucsd.xmlalchemy.xpath.Expression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Node;

public class QueryElement implements Expression {
    private final String tagName;
    private final Expression query;

    public QueryElement(String tagName, Expression query) {
        this.tagName = tagName;
        this.query = query;
    }

    @Override
    public List<Node> evaluate(Context ctx, List<Node> nodes) throws Exception {
        var queryNodes = query.evaluate(ctx, nodes);
        return new ArrayList<>(Arrays.asList(ctx.makeElementNode(tagName, queryNodes)));
    }
}
