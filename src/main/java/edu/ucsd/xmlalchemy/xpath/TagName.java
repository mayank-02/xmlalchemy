package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class TagName implements Expression {

    private final String tag;

    public TagName(String tag) {
        this.tag = tag;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            // Get node list of all children with the given tag name
            var children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                var child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals(tag)) {
                    result.add(child);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return tag;
    }
}
