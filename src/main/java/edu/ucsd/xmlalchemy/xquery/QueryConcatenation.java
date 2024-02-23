package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConcatenation implements Expression {
    private final Expression leftQuery;
    private final Expression rightQuery;

    public QueryConcatenation(Expression leftQuery, Expression rightQuery) {
        this.leftQuery = leftQuery;
        this.rightQuery = rightQuery;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx, List<Node> nodes) throws Exception {
        var leftNodes = leftQuery.evaluateQuery(ctx, nodes);
        var rightNodes = rightQuery.evaluateQuery(ctx, nodes);
        leftNodes.addAll(rightNodes);
        return leftNodes;
    }
}
