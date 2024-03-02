package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import org.w3c.dom.Node;

public class PathFilterAnd implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public PathFilterAnd(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var leftNodes = leftExpression.evaluate(nodes);
        var rightNodes = rightExpression.evaluate(nodes);
        leftNodes.retainAll(rightNodes);
        return leftNodes;
    }

    @Override
    public String toString() {
        return String.format("%s and %s", leftExpression.toString(), rightExpression.toString());
    }
}
