package edu.ucsd.xmlalchemy.xpath;

import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class Current implements Expression {
    @Override
    public List<Node> evaluate(List<Node> nodes) {
        return nodes;
    }

    @Override
    public String toString() {
        return ".";
    }
}
