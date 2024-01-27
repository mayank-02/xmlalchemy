package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import org.w3c.dom.Node;

public class RelativePathConcatenation implements Expression {

    final private Expression leftExpression;
    final private Expression rightExpression;

    public RelativePathConcatenation(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var leftNodes = leftExpression.evaluate(nodes);
        var rightNodes = rightExpression.evaluate(nodes);
        leftNodes.addAll(rightNodes);
        return leftNodes;
    }

}
