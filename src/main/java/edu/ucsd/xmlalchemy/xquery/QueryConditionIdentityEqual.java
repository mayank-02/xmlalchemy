package edu.ucsd.xmlalchemy.xquery;

import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionIdentityEqual implements Expression {
    private final Expression leftQuery;
    private final Expression rightQuery;

    public QueryConditionIdentityEqual(Expression leftQuery, Expression rightQuery) {
        this.leftQuery = leftQuery;
        this.rightQuery = rightQuery;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) throws Exception {
        var leftNodes = leftQuery.evaluateQuery(ctx);
        var rightNodes = rightQuery.evaluateQuery(ctx);
        for (var leftNode : leftNodes) {
            for (var rightNode : rightNodes) {
                if (leftNode.isSameNode(rightNode)) {
                    return true;
                }
            }
        }
        return false;
    }
}
