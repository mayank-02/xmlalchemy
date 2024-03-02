package edu.ucsd.xmlalchemy.xquery;

import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionNot implements Expression {
    private final Expression queryCondition;

    public QueryConditionNot(Expression queryCondition) {
        this.queryCondition = queryCondition;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) throws Exception {
        return !queryCondition.evaluateQueryCondition(ctx);
    }

    @Override
    public String toString() {
        return String.format("not %s", queryCondition.toString());
    }
}
