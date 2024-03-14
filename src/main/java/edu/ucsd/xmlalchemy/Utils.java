package edu.ucsd.xmlalchemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xquery.QueryConditionValueEqual;
import edu.ucsd.xmlalchemy.xquery.QueryFlworClause;
import edu.ucsd.xmlalchemy.xquery.StringLiteral;
import edu.ucsd.xmlalchemy.xquery.Variable;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    static final Expression EmptyExpression = new QueryFlworClause(
            List.of(new Tuple<String, Expression>("a", new StringLiteral("\"1\""))),
            new ArrayList<>(),
            new QueryConditionValueEqual(new Variable("a"), new StringLiteral("\"2\"")),
            new Variable("a"));

    public static void trimTextNodes(Node node) {
        if (node.getNodeType() == Node.TEXT_NODE) {
            node.setTextContent(node.getTextContent().trim());
        }

        var childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            trimTextNodes(childNodes.item(i));
        }
    }

    public static List<Node> getDescendantNodes(Node node) {
        var descendantNodes = new ArrayList<Node>();
        descendantNodes.add(node);
        var child = node.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                descendantNodes.addAll(getDescendantNodes(child));
            }
            child = child.getNextSibling();
        }
        return descendantNodes;
    }

    public static boolean isTypeOf(Object obj, Class<?>... types) {
        return Arrays.stream(types).anyMatch(type -> type.isInstance(obj));
    }
}
