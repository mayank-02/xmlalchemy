package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class Wildcard implements Expression {

    public Wildcard() {}

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        // FIXME: Similar to TagName.java
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            var children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                var child = children.item(i);
                // Confirm if we're only supposed to return ELEMENT_NODEs
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    result.add(child);
                }
            }
        }
        return result;
    }
}
