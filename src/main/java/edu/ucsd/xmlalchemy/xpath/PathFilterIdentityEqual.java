package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class PathFilterIdentityEqual implements Expression {
    final private Expression leftExpression;
    final private Expression rightExpression;

    public PathFilterIdentityEqual(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            var leftNodes = leftExpression.evaluate(List.of(node));
            var rightNodes = rightExpression.evaluate(List.of(node));
            for (Node leftNode : leftNodes) {
                for (Node rightNode : rightNodes) {
                    if (leftNode.isSameNode(rightNode)) {
                        result.add(node);
                    }
                }
            }
        }
        return result;
    }
}
