package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionOr implements Expression {
    private final Expression leftQueryCondition;
    private final Expression rightQueryCondition;

    public QueryConditionOr(Expression leftQueryCondition, Expression rightQueryCondition) {
        this.leftQueryCondition = leftQueryCondition;
        this.rightQueryCondition = rightQueryCondition;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx, List<Node> nodes) throws Exception {
        var leftNodes = leftQueryCondition.evaluateQuery(ctx, nodes);
        var rightNodes = rightQueryCondition.evaluateQuery(ctx, nodes);
        
        // Remove duplicates using a LinkedHashSet
        leftNodes.addAll(rightNodes);
        var uniqueNodes = new LinkedHashSet<>(leftNodes);

        return new ArrayList<>(uniqueNodes);
    }
}
