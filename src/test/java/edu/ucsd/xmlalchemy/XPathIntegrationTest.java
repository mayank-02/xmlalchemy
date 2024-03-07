package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.DifferenceEvaluators;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.ElementSelectors;

class XPathIntegrationTest {

    private static final String TEST_DATA_DIR = "src/test/resources/milestone1/input";
    private static final String EXPECTED_OUTPUT_DIR = "src/test/resources/milestone1/output";

    @Test
    void testAppWithMultipleInputFiles() throws Exception {
        var testDataDir = new File(TEST_DATA_DIR);
        var inputFiles = testDataDir.listFiles();

        if (inputFiles != null) {
            for (var inputFile : inputFiles) {
                // Assumes input files are .txt
                var baseName = inputFile.getName().replace(".txt", "");

                // FIXME: This is a limitation of the current test suite architecture.
                // All the consecutive text nodes will be parsed as a single text node.
                // making it impossible to do equality check.
                var skippedBaseNames = Set.of("additional3", "additional8");
                if (skippedBaseNames.contains(baseName)) {
                    continue;
                }

                // Evaluate the query
                var actualNodes = XPath.query(inputFile.getAbsolutePath());
                var actualDocument = XPath.transform(actualNodes);

                // Read the expected output
                var expectedOutputFile = new File(EXPECTED_OUTPUT_DIR, baseName + ".xml");
                var dbf = DocumentBuilderFactory.newDefaultInstance();
                var db = dbf.newDocumentBuilder();
                var expectedDocument = db.parse(expectedOutputFile);
                expectedDocument.normalize();
                Utils.trimTextNodes(expectedDocument.getDocumentElement());
                Utils.trimTextNodes(actualDocument.getDocumentElement());
                assertResult(baseName, expectedDocument, actualDocument);
            }
        } else {
            Assertions.fail("No input files found in testData directory.");
        }
    }

    // FIXME: This method still does not work with the re-ordering of elements
    // when the tree is deep enough and ElementSelectors.byNameAndText is not sufficient
    // Check testcase rule20
    // Reference: https://github.com/xmlunit/xmlunit/issues/123
    public void assertResultXMLUnit(String baseName, Document expectedDocument,
            Document actualDocument) {
        var diff = DiffBuilder.compare(Input.fromDocument(expectedDocument))
                .withTest(Input.fromDocument(actualDocument)).ignoreWhitespace()
                .normalizeWhitespace().withDifferenceEvaluator(DifferenceEvaluators.Default)
                .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
                .checkForSimilar().build();
        Assertions.assertFalse(diff.hasDifferences(), "Difference found: " + baseName);
    }

    public void assertResult(String baseName, Document expectedDocument, Document actualDocument) {
        var resultNode = expectedDocument.getElementsByTagName("result").item(0);
        var expectedNodeList = resultNode.getChildNodes();
        var expectedNodes =
                IntStream.range(0, expectedNodeList.getLength()).mapToObj(expectedNodeList::item)
                        .filter(node -> !(node.getNodeType() == Node.TEXT_NODE
                                && node.getTextContent().trim().isEmpty()))
                        .collect(Collectors.toList());

        var actualResultNode = actualDocument.getElementsByTagName("result").item(0);
        var actualNodeList = actualResultNode.getChildNodes();
        var actualNodes = IntStream.range(0, actualNodeList.getLength())
                .mapToObj(actualNodeList::item).filter(node -> !(node.getNodeType() == Node.TEXT_NODE
                && node.getTextContent().trim().isEmpty())).collect(Collectors.toList());

        Assertions.assertEquals(expectedNodes.size(), actualNodes.size(),
                "Mismatch in result size for test case: " + baseName);

        var exactMatch = IntStream.range(0, actualNodes.size())
                .allMatch(i -> actualNodes.get(i).isEqualNode(expectedNodes.get(i)));
        if (exactMatch) {
            return;
        }

        // Note: if it is not an exact match, we check if the permutation of result nodes.
        // FIXME: This does not work with duplicate node values.
        // FIXME: This is potentially slow if there are a lot of nodes.
        Assertions.assertTrue(
                actualNodes.stream().allMatch(
                        actualNode -> expectedNodes.stream().anyMatch(actualNode::isEqualNode)),
                "Some nodes in the actual output are not present in the expected output for test case: "
                        + baseName);
        Assertions.assertTrue(
                expectedNodes.stream().allMatch(
                        expectedNode -> actualNodes.stream().anyMatch(expectedNode::isEqualNode)),
                "Some nodes in the expected output are not present in the actual output for test case: "
                        + baseName);
    }

    @Test
    void testStringify() throws Exception {
        var testDataDir = new File(TEST_DATA_DIR);
        var inputFiles = testDataDir.listFiles();

        if (inputFiles != null) {
            for (var inputFile : inputFiles) {
                var filename = inputFile.getAbsolutePath();
                var charStream = CharStreams.fromFileName(filename);
                var lexer = new ExprLexer(charStream);
                var tokens = new CommonTokenStream(lexer);
                var parser = new ExprParser(tokens);
                var tree = parser.absolutePath();
                var visitor = new Visitor();
                var absolutePathExpr = visitor.visit(tree);
                var actualString = absolutePathExpr.toString();
                var expectedString = Files.readString(Paths.get(filename)).replace("\r", "")
                        .replace("\n", "").replace("==", "is").replace(" eq ", " = ");
                Assertions.assertEquals(expectedString, actualString);
            }
        } else {
            Assertions.fail("No input files found in testData directory.");
        }
    }
}
