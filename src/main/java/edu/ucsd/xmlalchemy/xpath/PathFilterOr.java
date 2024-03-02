package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;

public class PathFilterOr implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public PathFilterOr(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var leftNodes = leftExpression.evaluate(nodes);
        var rightNodes = rightExpression.evaluate(nodes);
        
        // Remove duplicates using a LinkedHashSet
        leftNodes.addAll(rightNodes);
        var uniqueNodes = new LinkedHashSet<>(leftNodes);

        return new ArrayList<>(uniqueNodes);
    }
    
    @Override
    public String toString() {
        return String.format("%s or %s", leftExpression.toString(), rightExpression.toString());
    }
}
