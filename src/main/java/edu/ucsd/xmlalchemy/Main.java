package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import edu.ucsd.xmlalchemy.xpath.AbsolutePath;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args) {
        String inputFilename = args[0];
        String outputFilename = args[1];
        try {
            CharStream charStream = CharStreams.fromFileName(inputFilename);
            ExprLexer lexer = new ExprLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExprParser parser = new ExprParser(tokens);
            ParseTree tree = parser.absolutePath();

            Visitor visitor = new Visitor();
            AbsolutePath absolutePath = (AbsolutePath) visitor.visit(tree);

            File file = new File(absolutePath.getFileName().replace("\"", ""));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);

            List<Node> inputNodes = new ArrayList<>();
            inputNodes.add(document);

            output(absolutePath.evaluate(inputNodes), outputFilename);
            return;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void output(List<Node> result, String outputFilename) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element parentElement = doc.createElement("result");
            for (Node node : result) {
                Node importedNode = doc.importNode(node, true); // true for deep cloning
                parentElement.appendChild(importedNode);
            }
            doc.appendChild(parentElement);

            TransformerFactory tfFactory = TransformerFactory.newInstance();
            Transformer tf = tfFactory.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            DOMSource source = new DOMSource(doc);


            StreamResult consoleResult = new StreamResult(System.out);
            tf.transform(source, consoleResult);

            OutputStream fileOutputStream = new FileOutputStream(outputFilename);
            StreamResult fileResult = new StreamResult(fileOutputStream);
            tf.transform(source, fileResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
