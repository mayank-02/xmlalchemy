package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import org.w3c.dom.Node;

public class PathFilterParenthesized implements Expression {
    private final Expression expression;

    public PathFilterParenthesized(Expression expression) {
        this.expression = expression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        return expression.evaluate(nodes);
    }
}
