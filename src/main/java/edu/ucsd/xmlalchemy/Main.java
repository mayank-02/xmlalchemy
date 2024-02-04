package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import edu.ucsd.xmlalchemy.xpath.AbsolutePathChild;
import edu.ucsd.xmlalchemy.xpath.AbsolutePathDescendant;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.parsers.DocumentBuilder;
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
            output(nodes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Node> query(String filename) {
        try {
            CharStream charStream = CharStreams.fromFileName(filename);
            ExprLexer lexer = new ExprLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExprParser parser = new ExprParser(tokens);
            ParseTree tree = parser.absolutePath();

            Visitor visitor = new Visitor();
            File file;
            var absolutePathExpr = visitor.visit(tree);
            if (absolutePathExpr instanceof AbsolutePathChild) {
                var absolutePath = ((AbsolutePathChild) absolutePathExpr);
                file = new File(absolutePath.getFileName().replace("\"", ""));
            } else if (absolutePathExpr instanceof AbsolutePathDescendant) {
                var absolutePath = ((AbsolutePathDescendant) absolutePathExpr);
                file = new File(absolutePath.getFileName().replace("\"", ""));
            } else {
                throw new Exception("Invalid absolute path expression");
            }

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);

            List<Node> inputNodes = new ArrayList<>();
            inputNodes.add(document);

            return absolutePathExpr.evaluate(inputNodes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Node>();
        }
    }

    public static void output(List<Node> result) {
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

            final var tfFactory = TransformerFactory.newInstance();
            var tf = tfFactory.newTransformer((new StreamSource(new File("src/main/resources/style.xslt"))));
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            
            var source = new DOMSource(doc);
            var consoleResult = new StreamResult(System.out);
            tf.transform(source, consoleResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
