package edu.ucsd.xmlalchemy.xquery;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Tuple;

public class DefaultContext implements Context {
    private Document document;
    private HashMap<String, List<Node>> variables = new HashMap<>();
    private Deque<Tuple<String, List<Node>>> stack = new LinkedList<>();

    @Override
    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public Node makeTextNode(String text) {
        if (Objects.isNull(document))
            throw new IllegalStateException("Document not set");

        return document.createTextNode(text);
    }

    @Override
    public Node makeElementNode(String tagName, List<Node> children) {
        if (Objects.isNull(document))
            throw new IllegalStateException("Document not set");

        var node = document.createElement(tagName);
        for (var child : children) {
            // TODO: !Objects.isNull(n)?
            node.appendChild(document.importNode(child, true));
        }
        return node;
    }

    @Override
    public List<Node> getVar(String varName) {
        if (variables.containsKey(varName)) {
            return variables.get(varName);
        } else {
            throw new IllegalStateException("Variable not set");
        }
    }

    @Override
    public void setVar(String varName, List<Node> nodes) {
        variables.put(varName, nodes);
    }

    @Override
    public void unwind(int count) {
        for (int i = 0; i < count; i++) {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            var tuple = stack.pop();
            if (tuple.second != null) {
                variables.put(tuple.first, tuple.second);
            } else {
                variables.remove(tuple.first);
            }
        }
    }
}
