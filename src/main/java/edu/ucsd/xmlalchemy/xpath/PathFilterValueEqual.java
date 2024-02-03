package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class PathFilterValueEqual implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public PathFilterValueEqual(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            var leftNodes = leftExpression.evaluate(List.of(node));
            var rightNodes = rightExpression.evaluate(List.of(node));
            var foundEqualNode = false;
            for (var leftNode : leftNodes) {
                for (var rightNode : rightNodes) {
                    if (leftNode.isEqualNode(rightNode)) {
                        foundEqualNode = true;
                        break;
                    }
                }
                if (foundEqualNode) {
                    result.add(node);
                    break;
                }
            }
        }
        return result;
    }
}
