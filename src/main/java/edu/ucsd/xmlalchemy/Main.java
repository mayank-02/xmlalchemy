package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import edu.ucsd.xmlalchemy.xpath.AbsolutePath;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
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
import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        try {
            CharStream charStream = CharStreams.fromFileName(filename);
            ExprLexer lexer = new ExprLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExprParser parser = new ExprParser(tokens);
            ParseTree tree = parser.absolutePath();
            System.out.printf("Query: %s\n\n", tree.getText());

            Visitor visitor = new Visitor();
            AbsolutePath absolutePath = (AbsolutePath) visitor.visit(tree);

            File file = new File(absolutePath.getFileName().replace("\"", ""));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);

            List<Node> inputNodes = new ArrayList<>();
            inputNodes.add(document);

            transform(absolutePath.evaluate(inputNodes));
            return;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void transform(List<Node> result) {
        try {
            TransformerFactory tfFactory = TransformerFactory.newInstance();
            Transformer tf = tfFactory.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");

            for (Node n : result) {
                if (n instanceof Attr || n instanceof Text) {
                    System.out.println(n.getTextContent());
                } else {
                    tf.transform(new DOMSource(n), new StreamResult(System.out));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
