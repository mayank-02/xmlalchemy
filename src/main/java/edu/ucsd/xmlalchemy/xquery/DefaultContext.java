package edu.ucsd.xmlalchemy.xquery;

import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class DefaultContext implements Context {
    private Document document;
    
    @Override
    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public Node makeTextNode(String text) {
        return document.createTextNode(text);
    }

    @Override
    public Node makeElementNode(String tagName, List<Node> children) {
        var node = document.createElement(tagName);
        for (var child : children) {
            // TODO: !Objects.isNull(n)?
            node.appendChild(document.importNode(child, true));
        }
        return node;
    }

}
