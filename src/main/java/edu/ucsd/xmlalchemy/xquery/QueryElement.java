package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class QueryElement implements Expression {
    private final String tagName;
    private final Expression query;

    public QueryElement(String tagName, Expression query) {
        this.tagName = tagName;
        this.query = query;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) {
        var queryNodes = query.evaluateQuery(ctx);
        return new ArrayList<>(List.of(ctx.makeElementNode(tagName, queryNodes)));
    }

    @Override
    public String toString() {
        return String.format("<%s>{%s}</%s>", tagName, query.toString(), tagName);
    }

    public String getTagName() {
        return tagName;
    }

    public Expression getQuery() {
        return query;
    }
}
