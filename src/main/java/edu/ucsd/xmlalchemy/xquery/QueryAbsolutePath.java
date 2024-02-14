package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;

public class QueryAbsolutePath implements Expression {
    private final Expression absolutePath;

    public QueryAbsolutePath(Expression absolutePath) {
        this.absolutePath = absolutePath;
    }

    @Override
    public List<Node> evaluate(Context ctx, List<Node> nodes) throws Exception {
        return absolutePath.evaluate(nodes);
    }
}
