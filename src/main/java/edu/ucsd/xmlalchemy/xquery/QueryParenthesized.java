package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryParenthesized implements Expression {
    private final Expression query;

    public QueryParenthesized(Expression query) {
        this.query = query;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) throws Exception {
        return query.evaluateQuery(ctx);
    }

    @Override
    public String toString() {
        return String.format("(%s)", query.toString());
    }
}
