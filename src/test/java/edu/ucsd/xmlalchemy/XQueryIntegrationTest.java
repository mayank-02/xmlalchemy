package edu.ucsd.xmlalchemy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

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

                // Evaluate the query
                var actualNodes = XQuery.query(inputFile.getAbsolutePath());
                var actualDocument = XQuery.transform(actualNodes);

                // Read the expected output
                var expectedOutputFile = new File(EXPECTED_OUTPUT_DIR, baseName + ".xml");
                var dbf = DocumentBuilderFactory.newDefaultInstance();
                var db = dbf.newDocumentBuilder();
                var expectedDocument = db.parse(expectedOutputFile);
                expectedDocument.normalize();
                Utils.trimTextNodes(expectedDocument.getDocumentElement());
                assertResult(baseName, expectedDocument, actualDocument);
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
}
