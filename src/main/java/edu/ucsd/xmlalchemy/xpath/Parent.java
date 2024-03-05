package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

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

    @Override
    public String toString() {
        return "..";
    }
}
