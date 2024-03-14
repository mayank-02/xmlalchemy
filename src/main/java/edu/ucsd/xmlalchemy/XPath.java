package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XPath {
    /**
     * Main method for the XPath command-line tool
     * 
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        try {
            String filename = args[0];
            var nodes = query(filename);
            var result = transform(nodes);
            output(result);
        } catch (TransformerException e) {
            System.err.println("Error transforming result: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.err.println("Error parsing query: " + e.getMessage());
        }
    }

    /**
     * Query the XML file with the given filename
     * 
     * @param filename The filename to query
     * @return
     * @throws IOException If an error occurs reading the file
     */
    public static List<Node> query(String filename) throws IOException {
        var charStream = CharStreams.fromFileName(filename);
        var lexer = new ExpressionLexer(charStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new ExpressionParser(tokens);
        var tree = parser.absolutePath();
        var visitor = new Visitor();
        var absolutePathExpr = visitor.visit(tree);
        return absolutePathExpr.evaluate(new ArrayList<>());
    }

    /**
     * Transform a list of nodes into a {@link Document}
     * 
     * We need to transform the nodes into a {@link Document} so that we can use it in the
     * integration test where we do document equality check. The result is enclosed in a "result"
     * tag to be consistent with the expected output.
     * 
     * The output for Attribute node is consistent with the requirement given to us for the project.
     * 
     * @param result The nodes to transform
     * @return
     * @throws ParserConfigurationException If an error occurs parsing the expression
     */
    public static Document transform(List<Node> result) throws ParserConfigurationException {
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
                var importedNode = doc.importNode(node, true);
                parentElement.appendChild(importedNode);
            }
        }
        doc.appendChild(parentElement);
        return doc;
    }

    /**
     * Output a list of nodes to a stream
     * 
     * @param result The nodes to output
     * @throws TransformerException If an error occurs transforming the nodes
     */
    public static void output(Document result) throws TransformerException {
        final var tfFactory = TransformerFactory.newDefaultInstance();
        var tf = tfFactory
                .newTransformer((new StreamSource(new File("src/main/resources/style.xslt"))));
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        var source = new DOMSource(result);
        var consoleResult = new StreamResult(System.out);
        tf.transform(source, consoleResult);
    }
}
