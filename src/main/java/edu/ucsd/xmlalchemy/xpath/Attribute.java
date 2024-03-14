package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class Attribute implements Expression{

    private String name;

    public Attribute(String name) {
        this.name = name;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            var children = node.getAttributes();
            result.add(children.getNamedItem(name));
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("@%s", name);
    }
}
