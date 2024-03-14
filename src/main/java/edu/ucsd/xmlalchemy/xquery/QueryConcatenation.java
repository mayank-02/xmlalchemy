package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class QueryConcatenation implements Expression {
    private final Expression leftQuery;
    private final Expression rightQuery;

    public QueryConcatenation(Expression leftQuery, Expression rightQuery) {
        this.leftQuery = leftQuery;
        this.rightQuery = rightQuery;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) {
        var leftNodes = leftQuery.evaluateQuery(ctx);
        var rightNodes = rightQuery.evaluateQuery(ctx);
        leftNodes.addAll(rightNodes);
        return leftNodes;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", leftQuery.toString(), rightQuery.toString());
    }

    public Expression getLeftQuery() {
        return leftQuery;
    }

    public Expression getRightQuery() {
        return rightQuery;
    }
}
