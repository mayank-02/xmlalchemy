package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;
import edu.ucsd.xmlalchemy.Utils;

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
                descendantNodes.addAll(Utils.getDescendantNodes(node));
            }
        }
        return new ArrayList<>(new LinkedHashSet<>(rightExpression.evaluate(descendantNodes)));
    }

    @Override
    public String toString() {
        return String.format("%s//%s", leftExpression.toString(), rightExpression.toString());
    }
}
