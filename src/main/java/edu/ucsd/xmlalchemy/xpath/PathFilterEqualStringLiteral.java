package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class PathFilterEqualStringLiteral implements Expression {
    private final Expression expression;
    private final String stringLiteral;

    public PathFilterEqualStringLiteral(Expression expression, String stringLiteral) {
        this.expression = expression;
        this.stringLiteral = stringLiteral.substring(1, stringLiteral.length() - 1);
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var result = new ArrayList<Node>();
        for (Node node : nodes) {
            if (expression.evaluate(List.of(node)).stream()
                    .filter(n -> n.getNodeType() == Node.TEXT_NODE)
                    .anyMatch(n -> n.getTextContent().equals(stringLiteral))) {
                result.add(node);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s = \"%s\"", expression.toString(), stringLiteral);
    }
}
