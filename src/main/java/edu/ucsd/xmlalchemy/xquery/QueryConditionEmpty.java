package edu.ucsd.xmlalchemy.xquery;

import edu.ucsd.xmlalchemy.Expression;

public class QueryConditionEmpty implements Expression {
    private final Expression query;

    public QueryConditionEmpty(Expression query) {
        this.query = query;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) throws Exception {
        return query.evaluateQuery(ctx).isEmpty();
    }

    @Override
    public String toString() {
        return String.format("empty(%s)", query.toString());
    }
}
