package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XPath {
    public static void main(String[] args) {
        String filename = args[0];
        try {
            var nodes = query(filename);
            var result = transform(nodes);
            output(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Node> query(String filename) {
        try {
            var charStream = CharStreams.fromFileName(filename);
            var lexer = new ExprLexer(charStream);
            var tokens = new CommonTokenStream(lexer);
            var parser = new ExprParser(tokens);
            var tree = parser.absolutePath();

            var visitor = new Visitor();
            var absolutePathExpr = visitor.visit(tree);
            return absolutePathExpr.evaluate(new ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static Document transform(List<Node> result) throws Exception {
        var dbFactory = DocumentBuilderFactory.newDefaultInstance();
        var dBuilder = dbFactory.newDocumentBuilder();
        var doc = dBuilder.newDocument();

        var parentElement = doc.createElement("result");
        for (var node : result) {
            if (node.getNodeType() == Node.TEXT_NODE) {
                var textNode = doc.createTextNode(node.getTextContent() + "\n");
                parentElement.appendChild(textNode);
            } else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                var valueNode = doc.createTextNode(node.getNodeValue() + "\n");
                parentElement.appendChild(valueNode);
            } else {
                var importedNode = doc.importNode(node, true); // true for deep cloning
                parentElement.appendChild(importedNode);
                // parentElement.appendChild(node.cloneNode(true));
            }
        }
        doc.appendChild(parentElement);
        return doc;
    }

    public static void output(Document result) {
        try {
            final var tfFactory = TransformerFactory.newDefaultInstance();
            var tf = tfFactory
                    .newTransformer((new StreamSource(new File("src/main/resources/style.xslt"))));
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            var source = new DOMSource(result);
            var consoleResult = new StreamResult(System.out);
            tf.transform(source, consoleResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
