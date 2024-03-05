package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class RelativePathWithPathFilter implements Expression {
    private final Expression relativePath;
    private final Expression pathFilter;

    public RelativePathWithPathFilter(Expression relativePath, Expression pathFilter) {
        this.relativePath = relativePath;
        this.pathFilter = pathFilter;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        var relativePathNodes = relativePath.evaluate(nodes);
        return pathFilter.evaluate(relativePathNodes);
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", relativePath.toString(), pathFilter.toString());
    }
}
