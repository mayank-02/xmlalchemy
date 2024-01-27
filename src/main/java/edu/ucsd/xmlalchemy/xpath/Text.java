package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class Text implements Expression {
    public Text() {};

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        List<Node> result = new ArrayList<>();
        for (var node : nodes) {
            var children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                var child = children.item(i);
                if (child.getNodeType() == Node.TEXT_NODE) {
                    result.add(child);
                }
            }
        }
        return result;
    }
}
