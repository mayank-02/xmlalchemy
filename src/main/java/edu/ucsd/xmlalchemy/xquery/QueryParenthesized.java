package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class QueryParenthesized implements Expression {
    private final Expression query;

    public QueryParenthesized(Expression query) {
        this.query = query;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) {
        return query.evaluateQuery(ctx);
    }

    @Override
    public String toString() {
        return String.format("(%s)", query.toString());
    }
}
