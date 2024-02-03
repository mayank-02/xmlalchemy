package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;

public class RelativePathDescendant implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public RelativePathDescendant(Expression left, Expression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var leftNodes = leftExpression.evaluate(nodes);
        var descendantNodes = new ArrayList<Node>();
        for (Node node : leftNodes) {
            if (node.getNodeType() == Node.ELEMENT_NODE || node.getNodeType() == Node.DOCUMENT_NODE) {
                descendantNodes.addAll(getDescendantNodes(node));
            }
        }
        return new ArrayList<>(new LinkedHashSet<>(rightExpression.evaluate(descendantNodes)));
    }

    private List<Node> getDescendantNodes(Node node) {
        var descendantNodes = new ArrayList<Node>();
        descendantNodes.add(node);
        var child = node.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                descendantNodes.addAll(getDescendantNodes(child));
            }
            child = child.getNextSibling();
        }
        return descendantNodes;
    }
}
