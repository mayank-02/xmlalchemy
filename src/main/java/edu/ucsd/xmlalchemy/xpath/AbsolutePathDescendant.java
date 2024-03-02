package edu.ucsd.xmlalchemy.xpath;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.Utils;

public class AbsolutePathDescendant implements Expression {
    private final String fileName;
    private final Expression expression;

    public AbsolutePathDescendant(String fileName, Expression expression) {
        this.fileName = fileName;
        this.expression = expression;
    }

    @Override
    public List<Node> evaluate(List<Node> nodes) throws Exception {
        // Open a file handle
        var file = new File(fileName.replace("\"", ""));

        // Parse the file
        var dbf = DocumentBuilderFactory.newDefaultInstance();
        var db = dbf.newDocumentBuilder();
        var document = db.parse(file);

        // Normalize the document
        document.normalize();
        Utils.trimTextNodes(document.getDocumentElement());

        // Create a list of input nodes
        var inputNodes = new ArrayList<Node>(List.of(document));

        var descendantNodes = new ArrayList<Node>();
        for (Node node : inputNodes) {
            if (node.getNodeType() == Node.ELEMENT_NODE || node.getNodeType() == Node.DOCUMENT_NODE) {
                descendantNodes.addAll(Utils.getDescendantNodes(node));
            }
        }
        return new ArrayList<>(new LinkedHashSet<>(expression.evaluate(descendantNodes)));
    }

    @Override
    public String toString() {
        return String.format("doc(%s)//%s", fileName, expression.toString());
    }
}
