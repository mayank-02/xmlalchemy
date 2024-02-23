package edu.ucsd.xmlalchemy.xquery;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Utils;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryDescendant implements Expression {
    private final Expression query;
    private final Expression relativePath;

    public QueryDescendant(Expression query, Expression relativePath) {
        this.query = query;
        this.relativePath = relativePath;
    }

    @Override
    public List<Node> evaluate(Context ctx, List<Node> nodes) throws Exception {
        var queryNodes = query.evaluate(ctx, nodes);
        var descendantNodes = new ArrayList<Node>();
        for (Node node : queryNodes) {
            if (node.getNodeType() == Node.ELEMENT_NODE || node.getNodeType() == Node.DOCUMENT_NODE) {
                descendantNodes.addAll(Utils.getDescendantNodes(node));
            }
        }
        return new ArrayList<>(new LinkedHashSet<>(relativePath.evaluate(descendantNodes)));
    }
}