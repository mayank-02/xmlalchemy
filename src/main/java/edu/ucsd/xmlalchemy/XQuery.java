package edu.ucsd.xmlalchemy;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.cli.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import edu.ucsd.xmlalchemy.xpath.Expression;
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
                System.out.println("Optimized query:\n" + expression);
            }

            long startTime = System.currentTimeMillis();
            var nodes = evaluateExpression(expression);
            long endTime = System.currentTimeMillis();
            System.out.println("Evaluation time: " + (endTime - startTime) + "ms");

            var stream = new StreamResult(System.out);
            if (cmd.hasOption("o")) {
                stream = new StreamResult(new File(cmd.getOptionValue("o")));
            }

            output(nodes, stream);

        } catch (ParseException e) {
            System.err.println("Error parsing command-line arguments: " + e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("XQuery", options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Expression parseExpressionFromFile(String filename) throws Exception {
        var charStream = CharStreams.fromFileName(filename);
        var lexer = new ExprLexer(charStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new ExprParser(tokens);
        var tree = parser.query();
        var visitor = new Visitor();
        return visitor.visit(tree);
    }

    public static List<Node> evaluateExpression(Expression expression) throws Exception {
        var ctx = new DefaultContext();
        ctx.setDocument(
                DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument());
        return expression.evaluateQuery(ctx);
    }

    public static void output(List<Node> nodes, StreamResult stream) throws Exception {
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
