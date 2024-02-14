package edu.ucsd.xmlalchemy;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

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
}
