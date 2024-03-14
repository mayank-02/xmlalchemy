package edu.ucsd.xmlalchemy;

import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xquery.Context;
import java.util.List;

public interface Expression {
    default List<Node> evaluate(List<Node> nodes) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    default List<Node> evaluateQuery(Context ctx) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    default boolean evaluateQueryCondition(Context ctx) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
