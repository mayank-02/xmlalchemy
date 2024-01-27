package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import org.w3c.dom.Node;

public class RelativePathWithPathFilter implements Expression {
    final private Expression relativePath;
    final private Expression pathFilter;

    public RelativePathWithPathFilter(Expression relativePath, Expression pathFilter) {
        this.relativePath = relativePath;
        this.pathFilter = pathFilter;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var relativePathNodes = relativePath.evaluate(nodes);
        return pathFilter.evaluate(relativePathNodes);
    }
}
