package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class TagName implements Expression {

    final private String tagName;

    public TagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            // Get node list of all children with the given tag name
            var children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                var child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals(tagName)) {
                    result.add(child);
                }
            }
        }
        return result;
    }

}
