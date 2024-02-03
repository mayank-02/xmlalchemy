package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import org.w3c.dom.Node;

public class Current implements Expression {
    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        return nodes;
    }
}
