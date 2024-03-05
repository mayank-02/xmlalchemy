package edu.ucsd.xmlalchemy.xquery;

import edu.ucsd.xmlalchemy.Expression;

public class QueryConditionOr implements Expression {
    private final Expression leftQueryCondition;
    private final Expression rightQueryCondition;

    public QueryConditionOr(Expression leftQueryCondition, Expression rightQueryCondition) {
        this.leftQueryCondition = leftQueryCondition;
        this.rightQueryCondition = rightQueryCondition;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) throws Exception {
        return leftQueryCondition.evaluateQueryCondition(ctx) || rightQueryCondition.evaluateQueryCondition(ctx);
    }

    @Override
    public String toString() {
        return String.format("%s or %s", leftQueryCondition.toString(), rightQueryCondition.toString());
    }
}
