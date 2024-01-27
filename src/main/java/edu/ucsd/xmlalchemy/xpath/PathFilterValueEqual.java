package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class PathFilterValueEqual implements Expression {
    final private Expression leftExpression;
    final private Expression rightExpression;

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
            // Find at least one node from leftNodes that has a value equal to the value of
            // rightNodes
            // By equal, we mean
            // tag(a) == tag(b)
            // && text(a) == text(b)
            // && numOfChildren(a) == numOfChildren(b)
            // && kthChild(a, k) == kthChild(b, k) for all k
            for (Node leftNode : leftNodes) {
                for (Node rightNode : rightNodes) {
                    if (this.isNodeEqual(leftNode, rightNode)) {
                        result.add(node);
                    }
                }
            }
        }
        return result;
    }

    private boolean isNodeEqual(Node leftNode, Node rightNode) {
        // TODO: Implement this method
        return true;
    }
}
