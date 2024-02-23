package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionEmpty implements Expression {
    private final Expression query;

    public QueryConditionEmpty(Expression query) {
        this.query = query;
    }

    @Override
    public boolean evaluateQueryCondition(Context ctx) throws Exception {
        return query.evaluateQuery(ctx, new ArrayList<>()).isEmpty();
    }
}
