package edu.ucsd.xmlalchemy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xquery.DefaultContext;

public class XQuery {
    public static void main(String[] args) {
        String filename = args[0];
        try {
            var nodes = query(filename);
            output(nodes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Node> query(String filename) throws Exception {
        var charStream = CharStreams.fromFileName(filename);
        var lexer = new ExprLexer(charStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new ExprParser(tokens);
        var tree = parser.query();
        var visitor = new Visitor();
        var query = visitor.visit(tree);
        var ctx = new DefaultContext();
        ctx.setDocument(
                DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument());
        return query.evaluateQuery(ctx);
    }

    public static void output(List<Node> nodes) throws Exception {
        final var tfFactory = TransformerFactory.newDefaultInstance();
        var tf = tfFactory
                .newTransformer((new StreamSource(new File("src/main/resources/style.xslt"))));
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        for (var node : nodes) {
            var source = new DOMSource(node);
            var consoleResult = new StreamResult(System.out);
            tf.transform(source, consoleResult);
        }
    }

    public static Document transform(List<Node> result) throws Exception {
        var dbFactory = DocumentBuilderFactory.newDefaultInstance();
        var dBuilder = dbFactory.newDocumentBuilder();
        var doc = dBuilder.newDocument();

        var parentElement = doc.createElement(result.get(0).getNodeName());
        var children = result.get(0).getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            var node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                var textNode = doc.createTextNode(node.getTextContent() + "\n");
                parentElement.appendChild(textNode);
            } else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                var valueNode = doc.createTextNode(node.getNodeValue() + "\n");
                parentElement.appendChild(valueNode);
            } else {
                var importedNode = doc.importNode(node, true); // true for deep cloning
                parentElement.appendChild(importedNode);
            }
        }
        doc.appendChild(parentElement);
        return doc;
    }
}
