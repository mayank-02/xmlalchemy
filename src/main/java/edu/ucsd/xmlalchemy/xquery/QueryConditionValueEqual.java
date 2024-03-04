package edu.ucsd.xmlalchemy.xquery;

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
        var leftNodes = leftQuery.evaluateQuery(ctx);
        var rightNodes = rightQuery.evaluateQuery(ctx);
        for (var leftNode : leftNodes) {
            for (var rightNode : rightNodes) {
                if (leftNode.isEqualNode(rightNode)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s = %s", leftQuery.toString(), rightQuery.toString());
    }

    public Expression getLeftQuery() {
        return leftQuery;
    }

    public Expression getRightQuery() {
        return rightQuery;
    }
}
