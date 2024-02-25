package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class JoinClause implements Expression {
    private Expression leftQuery;
    private Expression rightQuery;
    private List<String> leftAttributes;
    private List<String> rightAttributes;

    public JoinClause(Expression leftQuery, Expression rightQuery, List<String> leftAttributes,
            List<String> rightAttributes) {
        this.leftQuery = leftQuery;
        this.rightQuery = rightQuery;
        this.leftAttributes = leftAttributes;
        this.rightAttributes = rightAttributes;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) throws Exception {
        var leftTuples = leftQuery.evaluateQuery(ctx);
        var rightTuples = rightQuery.evaluateQuery(ctx);
        var result = new java.util.ArrayList<Node>();
        // TODO: Hash the right tuples
        return List.of();
    }

}
