package edu.ucsd.xmlalchemy;

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
}
