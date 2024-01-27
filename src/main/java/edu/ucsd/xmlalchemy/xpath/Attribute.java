package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class Attribute implements Expression{

    private String name;

    public Attribute(String name) {
        this.name = name;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            var children = node.getAttributes();
            result.add(children.getNamedItem(name));
        }
        return result;
    }

}
