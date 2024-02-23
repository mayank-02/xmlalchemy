package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionValueEqual implements Expression {
    private final Expression leftQuery;
    private final Expression rightQuery;

    public QueryConditionValueEqual(Expression leftQuery, Expression rightQuery) {
        this.leftQuery = leftQuery;
        this.rightQuery = rightQuery;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx, List<Node> nodes) throws Exception {
        var result = new ArrayList<Node>();
        for (Node node : nodes) {
            var leftNodes = leftQuery.evaluateQuery(ctx, List.of(node));
            var rightNodes = rightQuery.evaluateQuery(ctx, List.of(node));
            var foundEqualNode = false;
            for (var leftNode : leftNodes) {
                for (var rightNode : rightNodes) {
                    if (leftNode.isEqualNode(rightNode)) {
                        foundEqualNode = true;
                        break;
                    }
                }
                if (foundEqualNode) {
                    result.add(node);
                    break;
                }
            }
        }
        return result;
    }
}
