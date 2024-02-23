package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionAnd implements Expression {
    private final Expression leftQueryCondition;
    private final Expression rightExpression;

    public QueryConditionAnd(Expression leftQueryCondition, Expression rightExpression) {
        this.leftQueryCondition = leftQueryCondition;
        this.rightExpression = rightExpression;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx, List<Node> nodes) throws Exception {
        var leftNodes = leftQueryCondition.evaluateQuery(ctx, nodes);
        var rightNodes = rightExpression.evaluateQuery(ctx, nodes);
        leftNodes.retainAll(rightNodes);
        return leftNodes;
    }

}
