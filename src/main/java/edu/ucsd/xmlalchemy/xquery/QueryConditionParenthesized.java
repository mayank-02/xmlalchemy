package edu.ucsd.xmlalchemy.xquery;

import edu.ucsd.xmlalchemy.Expression;

public class QueryConditionParenthesized implements Expression {
    private final Expression queryCondition;

    public QueryConditionParenthesized(Expression queryCondition) {
        this.queryCondition = queryCondition;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) {
        return queryCondition.evaluateQueryCondition(ctx);
    }

    @Override
    public String toString() {
        return String.format("(%s)", queryCondition.toString());
    }
}
