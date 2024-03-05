package edu.ucsd.xmlalchemy.xquery;

import edu.ucsd.xmlalchemy.Expression;

public class QueryConditionAnd implements Expression {
    private final Expression leftQueryCondition;
    private final Expression rightQueryCondition;

    public QueryConditionAnd(Expression leftQueryCondition, Expression rightQueryCondition) {
        this.leftQueryCondition = leftQueryCondition;
        this.rightQueryCondition = rightQueryCondition;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) throws Exception {
        return leftQueryCondition.evaluateQueryCondition(ctx) && rightQueryCondition.evaluateQueryCondition(ctx);
    }

    @Override
    public String toString() {
        return String.format("%s and %s", leftQueryCondition.toString(), rightQueryCondition.toString());
    }

    public Expression getLeftQueryCondition() {
        return leftQueryCondition;
    }

    public Expression getRightQueryCondition() {
        return rightQueryCondition;
    }
}
