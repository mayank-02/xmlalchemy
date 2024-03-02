package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;

public class RelativePathChild implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public RelativePathChild(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        List<Node> leftNodes = leftExpression.evaluate(nodes);
        List<Node> rightNodes = rightExpression.evaluate(leftNodes);

        // Remove duplicates using a LinkedHashSet
        var uniqueNodes = new LinkedHashSet<>(rightNodes);

        return new ArrayList<>(uniqueNodes);
    }

    @Override
    public String toString() {
        return String.format("%s/%s", leftExpression.toString(), rightExpression.toString());
    }
}
