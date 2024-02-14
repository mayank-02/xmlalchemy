package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface Context {
    public void setDocument(Document document);
    public Node makeTextNode(String text);
    public Node makeElementNode(String name, List<Node> children);
    public List<Node> getVar(String varName);
    public void setVar(String varName, List<Node> nodes);
    public void unwind(int count);
}