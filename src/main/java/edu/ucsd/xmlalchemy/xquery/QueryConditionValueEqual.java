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
    public boolean evaluateQueryCondition(Context ctx) throws Exception {
        var leftNodes = leftQuery.evaluateQuery(ctx, new ArrayList<>());
        var rightNodes = rightQuery.evaluateQuery(ctx, new ArrayList<>());
        for (var leftNode : leftNodes) {
            for (var rightNode : rightNodes) {
                if (leftNode.isEqualNode(rightNode)) {
                    return true;
                }
            }
        }
        return false;
    }
}
