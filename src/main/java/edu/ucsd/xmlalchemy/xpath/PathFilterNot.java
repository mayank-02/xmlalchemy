package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import java.util.stream.Collectors;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class PathFilterNot implements Expression {
    private final Expression expression;

    public PathFilterNot(Expression expression) {
        this.expression = expression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var filteredOutNodes = expression.evaluate(nodes);
        var filteredOutNodesHashSet = filteredOutNodes.stream().collect(Collectors.toSet());
        return nodes.stream().filter(node -> !filteredOutNodesHashSet.contains(node)).toList();
    }

    @Override
    public String toString() {
        return String.format("not %s", expression.toString());
    }

}
