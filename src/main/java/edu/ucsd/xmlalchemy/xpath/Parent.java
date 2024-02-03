package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class Parent implements Expression {
    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            var parent = node.getParentNode();
            if (parent != null) {
                result.add(parent);
            }
        }
        return result;
    }
}
