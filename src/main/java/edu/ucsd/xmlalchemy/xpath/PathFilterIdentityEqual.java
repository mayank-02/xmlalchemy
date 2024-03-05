package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class PathFilterIdentityEqual implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

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
            var foundEqualNode = false;
            for (var leftNode : leftNodes) {
                for (var rightNode : rightNodes) {
                    if (leftNode.isSameNode(rightNode)) {
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

    @Override
    public String toString() {
        return String.format("%s is %s", leftExpression.toString(), rightExpression.toString());
    }
}
