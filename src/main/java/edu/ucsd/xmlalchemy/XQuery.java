package edu.ucsd.xmlalchemy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.cli.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xquery.DefaultContext;

public class XQuery {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("h", "help", false, "Print this help message");
        options.addOption(Option.builder("o").longOpt("output").hasArg().argName("file")
                .desc("Output file name").build());
        options.addOption(Option.builder().longOpt("optimize").desc("Optimize the query").build());

        try {
            var parser = new DefaultParser();
            var cmd = parser.parse(options, args);
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("XQuery", options);
                return;
            }

            var expression = parseExpressionFromFile(cmd.getArgs()[0]);
            if (cmd.hasOption("optimize")) {
                expression = Optimizer.optimize(expression);
                System.out.println(Formatter.format(expression.toString()));
            }

            long startTime = System.currentTimeMillis();
            var nodes = evaluateExpression(expression);
            long endTime = System.currentTimeMillis();
            System.out.println("Evaluation time: " + (endTime - startTime) + "ms");

            var stream = new StreamResult(System.out);
            if (cmd.hasOption("o")) {
                System.out.println("Output file: " + cmd.getOptionValue("o"));
                stream = new StreamResult(new FileOutputStream(cmd.getOptionValue("o")));
            }

            output(nodes, stream);

        } catch (ParseException e) {
            System.err.println("Error parsing command-line arguments: " + e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("XQuery", options);
        } catch (TransformerException e) {
            System.err.println("Error transforming result: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.err.println("Error parsing query: " + e.getMessage());
        }
    }

    public static Expression parseExpressionFromFile(String filename) throws IOException {
        var charStream = CharStreams.fromFileName(filename);
        var lexer = new ExpressionLexer(charStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new ExpressionParser(tokens);
        var tree = parser.query();
        var visitor = new Visitor();
        return visitor.visit(tree);
    }

    public static List<Node> evaluateExpression(Expression expression)
            throws ParserConfigurationException {
        var ctx = new DefaultContext();
        ctx.setDocument(
                DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument());
        return expression.evaluateQuery(ctx);
    }

    public static void output(List<Node> nodes, StreamResult stream) throws TransformerException {
        TransformerFactory tfFactory = TransformerFactory.newDefaultInstance();
        var tf = tfFactory
                .newTransformer(new StreamSource(new File("src/main/resources/style.xslt")));
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        for (var node : nodes) {
            var source = new DOMSource(node);
            tf.transform(source, stream);
        }
    }

    public static Document transform(List<Node> result) throws ParserConfigurationException {
        var dbFactory = DocumentBuilderFactory.newDefaultInstance();
        var dBuilder = dbFactory.newDocumentBuilder();
        var doc = dBuilder.newDocument();
        if (result.isEmpty()) {
            return doc;
        }

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
                var importedNode = doc.importNode(node, true);
                parentElement.appendChild(importedNode);
            }
        }
        doc.appendChild(parentElement);
        return doc;
    }
}
