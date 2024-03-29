package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class RelativePathParenthesized implements Expression {
    private final Expression expression;

    public RelativePathParenthesized(Expression expression) {
        this.expression = expression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) {
        return expression.evaluate(nodes);
    }
    
    @Override
    public String toString() {
        return String.format("(%s)", expression.toString());
    }
}
