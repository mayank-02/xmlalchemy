package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import java.util.stream.Collectors;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryConditionNot implements Expression {
    private final Expression queryCondition;

    public QueryConditionNot(Expression queryCondition) {
        this.queryCondition = queryCondition;
    }

    @Override
    public List<Node> evaluate(Context ctx, List<Node> nodes) throws Exception {
        var filteredOutNodes = queryCondition.evaluate(nodes);
        var filteredOutNodesHashSet = filteredOutNodes.stream().collect(Collectors.toSet());
        return nodes.stream().filter(node -> !filteredOutNodesHashSet.contains(node)).toList();
    }
}
