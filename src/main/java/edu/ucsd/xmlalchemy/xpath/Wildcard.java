package edu.ucsd.xmlalchemy.xpath;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Expression;

public class Wildcard implements Expression {
    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        // FIXME: Similar to TagName.java
        var result = new ArrayList<Node>();
        for (Node node : nodes) {
            var children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                var child = children.item(i);
                // Wildcard selects element nodes only as per XPath specification.
                // https://www.oreilly.com/library/view/xslt-2nd-edition/9780596527211/ch03s02s05.html
                // However, since milestone 1 specification does not make this distinction, we
                // select all nodes.
                result.add(child);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "*";
    }
}
