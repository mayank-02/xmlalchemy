package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class JoinClause implements Expression {
    private Expression leftQuery;
    private Expression rightQuery;
    private List<String> leftAttributes;
    private List<String> rightAttributes;

    public JoinClause(Expression leftQuery, Expression rightQuery, List<String> leftAttributes,
            List<String> rightAttributes) {
        this.leftQuery = leftQuery;
        this.rightQuery = rightQuery;
        this.leftAttributes = leftAttributes;
        this.rightAttributes = rightAttributes;
    }

    @Override
    public List<Node> evaluateQuery(Context ctx) throws Exception {
        var leftTuples = leftQuery.evaluateQuery(ctx);
        var rightTuples = rightQuery.evaluateQuery(ctx);

        // Set left tuples to be the smaller relation
        if (leftTuples.size() > rightTuples.size()) {
            var temp = leftTuples;
            leftTuples = rightTuples;
            rightTuples = temp;
            var tempAttrs = leftAttributes;
            leftAttributes = rightAttributes;
            rightAttributes = tempAttrs;
        }

        var hashMap = new HashMap<String, List<Node>>();
        for (var leftTuple : leftTuples) {
            var hashedKey = this.hash(leftTuple, leftAttributes);
            hashMap.computeIfAbsent(hashedKey, k -> new ArrayList<>()).add(leftTuple);
        }

        var result = new ArrayList<Node>();

        for (var rightTuple : rightTuples) {
            var hashedKey = this.hash(rightTuple, rightAttributes);
            if (hashMap.containsKey(hashedKey)) {
                var matchingTuples = hashMap.get(hashedKey);
                for (var matchingTuple : matchingTuples) {
                    var mergedValues = new ArrayList<Node>();
                    var leftValues = matchingTuple.getChildNodes();
                    for (int i = 0; i < leftValues.getLength(); i++) {
                        mergedValues.add(leftValues.item(i));
                    }
                    var rightValues = rightTuple.getChildNodes();
                    for (int i = 0; i < rightValues.getLength(); i++) {
                        mergedValues.add(rightValues.item(i));
                    }
                    result.add(ctx.makeElementNode("tuple", mergedValues));
                }
            }
        }

        return result;
    }

    private String hash(Node tupleNode, List<String> attributes) {
        var result = new ArrayList<String>();
        for (var attribute : attributes) {
            var tupleChildren = tupleNode.getChildNodes();
            for (int i = 0; i < tupleChildren.getLength(); i++) {
                if (tupleChildren.item(i).getNodeName().equals(attribute)) {
                    result.add(tupleChildren.item(i).getTextContent());
                }
            }
        }

        return String.join("###", result);
    }

    @Override
    public String toString() {
        return String.format("join (%s, %s, [%s], [%s])", leftQuery.toString(),
                rightQuery.toString(), String.join(", ", leftAttributes),
                String.join(", ", rightAttributes));
    }
}
