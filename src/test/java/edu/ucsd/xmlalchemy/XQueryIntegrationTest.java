package edu.ucsd.xmlalchemy;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

class XQueryIntegrationTest {

    private static final String TEST_DATA_DIR = "src/test/resources/milestone2/input";
    private static final String EXPECTED_OUTPUT_DIR = "src/test/resources/milestone2/output";

    @Test
    void testAppWithMultipleInputFiles() throws Exception {
        var testDataDir = new File(TEST_DATA_DIR);
        var inputFiles = testDataDir.listFiles();

        if (inputFiles != null) {
            for (var inputFile : inputFiles) {
                // Assumes input files are .txt
                var baseName = inputFile.getName().replace(".txt", "");

                // Read the expected output
                var expectedOutputFile = new File(EXPECTED_OUTPUT_DIR, baseName + ".xml");
                var dbf = DocumentBuilderFactory.newDefaultInstance();
                var db = dbf.newDocumentBuilder();
                var expectedDocument = db.parse(expectedOutputFile);
                expectedDocument.normalize();
                Utils.trimTextNodes(expectedDocument.getDocumentElement());

                // FIXME: This is a very quick implementation to support expecting error during
                // evaluation.
                // While this is a good thing to test, the implementation must be improved.
                var errorExpected =
                        expectedDocument.getChildNodes().item(0).getNodeName().equals("error");

                // Evaluate the query
                try {
                    var expression = XQuery.parseExpressionFromFile(inputFile.getAbsolutePath());
                    var actualNodes = XQuery.evaluateExpression(expression);
                    if (!errorExpected) {
                        var actualDocument = XQuery.transform(actualNodes);
                        assertResult(baseName, expectedDocument, actualDocument);
                    }
                } catch (IllegalStateException e) {
                    if (!errorExpected) {
                        throw e;
                    }
                }
            }
        } else {
            Assertions
                    .fail("No input files found in src/test/resources/milestone2/input directory.");
        }
    }

    public void assertResult(String baseName, Document expectedDocument, Document actualDocument) {
        var resultNode = expectedDocument.getChildNodes().item(0);
        var expectedNodeList = resultNode.getChildNodes();
        var expectedNodes =
                IntStream.range(0, expectedNodeList.getLength()).mapToObj(expectedNodeList::item)
                        .filter(node -> !(node.getNodeType() == Node.TEXT_NODE
                                && node.getTextContent().trim().isEmpty()))
                        .collect(Collectors.toList());

        var actualResultNode = expectedDocument.getChildNodes().item(0);
        var actualNodeList = actualResultNode.getChildNodes();
        var actualNodes =
                IntStream.range(0, actualNodeList.getLength()).mapToObj(actualNodeList::item)
                        .filter(node -> !(node.getNodeType() == Node.TEXT_NODE
                                && node.getTextContent().trim().isEmpty()))
                        .collect(Collectors.toList());

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
                var inputFilename = inputFile.getAbsolutePath();
                var expression = XQuery.parseExpressionFromFile(inputFilename);
                var actualString = expression.toString();
                // TODO: Document this magic
                var expectedString = Files.readString(Paths.get(inputFilename))
                        .replaceAll("\s*\\n\s*", " ").replace("{ ", "{").replace(" }", "}")
                        .replace("( ", "(").replace(" )", ")").replace("==", "is")
                        .replace(" eq ", " = ").trim();
                Assertions.assertEquals(expectedString, actualString);
            }
        } else {
            Assertions.fail("No input files found in testData directory.");
        }
    }
}
