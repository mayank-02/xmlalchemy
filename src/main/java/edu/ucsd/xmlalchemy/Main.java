package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import edu.ucsd.xmlalchemy.xpath.AbsolutePathChild;
import edu.ucsd.xmlalchemy.xpath.AbsolutePathDescendant;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.print.Doc;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Main {
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
            
            File file;
            if (absolutePathExpr instanceof AbsolutePathChild) {
                var absolutePath = ((AbsolutePathChild) absolutePathExpr);
                file = new File(absolutePath.getFileName().replace("\"", ""));
            } else if (absolutePathExpr instanceof AbsolutePathDescendant) {
                var absolutePath = ((AbsolutePathDescendant) absolutePathExpr);
                file = new File(absolutePath.getFileName().replace("\"", ""));
            } else {
                throw new Exception("Invalid absolute path expression");
            }

            var dbf = DocumentBuilderFactory.newInstance();
            var db = dbf.newDocumentBuilder();
            var document = db.parse(file);
            document.normalize();
            trimTextNodes(document.getDocumentElement());

            var inputNodes = new ArrayList<Node>();
            inputNodes.add(document);

            return absolutePathExpr.evaluate(inputNodes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void trimTextNodes(Node node) {
        if (node.getNodeType() == Node.TEXT_NODE) {
            node.setTextContent(node.getTextContent().trim());
        }

        var childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            trimTextNodes(childNodes.item(i));
        }
    }

    public static Document transform(List<Node> result) throws Exception {
        try {
            var dbFactory = DocumentBuilderFactory.newInstance();
            var dBuilder = dbFactory.newDocumentBuilder();
            var doc = dBuilder.newDocument();

            var parentElement = doc.createElement("result");
            for (var node : result) {
                var importedNode = doc.importNode(node, true); // true for deep cloning
                parentElement.appendChild(importedNode);
            }
            doc.appendChild(parentElement);
            return doc;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new Exception("Failed to transform");
        }
    }

    public static void output(Document result) {
        try {
            final var tfFactory = TransformerFactory.newInstance();
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
