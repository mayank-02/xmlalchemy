package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;

public class AbsolutePathDescendant implements Expression {
    private final String fileName;
    private final Expression expression;

    public AbsolutePathDescendant(String fileName, Expression expression) {
        this.fileName = fileName;
        this.expression = expression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var descendantNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node.getNodeType() == Node.ELEMENT_NODE || node.getNodeType() == Node.DOCUMENT_NODE) {
                descendantNodes.addAll(getDescendantNodes(node));
            }
        }
        return new ArrayList<>(new LinkedHashSet<>(expression.evaluate(descendantNodes)));
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

    public String getFileName() {
        return fileName;
    }
}
