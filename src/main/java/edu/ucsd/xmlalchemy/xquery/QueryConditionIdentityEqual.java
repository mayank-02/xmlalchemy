package edu.ucsd.xmlalchemy.xquery;

import edu.ucsd.xmlalchemy.Expression;

public class QueryConditionIdentityEqual implements Expression {
    private final Expression leftQuery;
    private final Expression rightQuery;

    public QueryConditionIdentityEqual(Expression leftQuery, Expression rightQuery) {
        this.leftQuery = leftQuery;
        this.rightQuery = rightQuery;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) {
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

    @Override
    public String toString() {
        return String.format("%s is %s", leftQuery.toString(), rightQuery.toString());
    }
}
