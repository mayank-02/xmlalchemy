package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import java.util.stream.Collectors;
import org.w3c.dom.Node;
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
}
