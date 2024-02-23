package edu.ucsd.xmlalchemy.xpath;

import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xquery.Context;
import java.util.List;

public interface Expression {
    default List<Node> evaluate(List<Node> nodes) throws Exception {
        throw new UnsupportedOperationException();
    }

    default List<Node> evaluateQuery(Context ctx, List<Node> nodes) throws Exception {
        throw new UnsupportedOperationException();
    }
}
