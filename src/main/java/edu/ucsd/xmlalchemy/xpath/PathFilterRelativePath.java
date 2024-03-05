package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class PathFilterRelativePath implements Expression {
    private final Expression relativePath;

    public PathFilterRelativePath(Expression relativePath) {
        this.relativePath = relativePath;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        // /ROOT/A[X] => Filter A nodes that have a child X
        // For each node in nodes, evaluate relativePath 
        // and return the nodes that satisfy the predicate
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            List<Node> relativePathNodes = relativePath.evaluate(List.of(node));
            if (!relativePathNodes.isEmpty()) {
                result.add(node);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return relativePath.toString();
    }
}
