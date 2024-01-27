package edu.ucsd.xmlalchemy.xpath;

import org.w3c.dom.Node;
import java.util.List;

public interface Expression {
    List<Node> evaluate(List<Node> nodes) throws Exception;
}
