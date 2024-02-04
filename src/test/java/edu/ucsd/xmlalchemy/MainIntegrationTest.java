package edu.ucsd.xmlalchemy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class MainIntegrationTest {

    private static final String TEST_DATA_DIR = "src/test/resources/milestone1/input";
    private static final String EXPECTED_OUTPUT_DIR = "src/test/resources/milestone1/output";

    @Test
    public void testAppWithMultipleInputFiles() throws IOException {
        File testDataDir = new File(TEST_DATA_DIR);
        File[] inputFiles = testDataDir.listFiles();

        if (inputFiles != null) {
            for (File inputFile : inputFiles) {
                String baseName = inputFile.getName().replace(".txt", ""); // Assumes input files are .txt

                // Evaluate the query
                var actualNodes = Main.query(inputFile.getAbsolutePath());

                // Read the expected output
                try {
                    File expectedOutputFile = new File(EXPECTED_OUTPUT_DIR, baseName + ".xml");
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document expectedDocument = db.parse(expectedOutputFile);
                    assertResult(baseName, expectedDocument, actualNodes);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } else {
            Assertions.fail("No input files found in testData directory.");
        }
    }

    public void assertResult(String baseName, Document expectedDocument, List<Node> actualNodes) {
        var resultNode = expectedDocument.getElementsByTagName("result").item(0);
        var expectedNodeList = resultNode.getChildNodes();
        var expectedNodes = IntStream.range(0, expectedNodeList.getLength())
            .mapToObj(expectedNodeList::item)
            .filter(node -> !(node.getNodeType() == Node.TEXT_NODE && node.getTextContent().trim().isEmpty()))
            .collect(Collectors.toList());

        Assertions.assertEquals(expectedNodes.size(), actualNodes.size(), "Mismatch in result size for test case: " + baseName);

        var exactMatch = IntStream.range(0, actualNodes.size())
            .allMatch(i -> actualNodes.get(i).isEqualNode(expectedNodes.get(i)));
        if (exactMatch) {
            return;
        }

        // Note: if it is not an exact match, we check if the permutation of result nodes.
        // FIXME: This does not work with duplicate node values.
        // FIXME: This is potentially slow if there are a lot of nodes.
        Assertions.assertTrue(actualNodes.stream()
            .allMatch(actualNode -> expectedNodes.stream().anyMatch(actualNode::isEqualNode)),
    "Some nodes in the actual output are not present in the expected output for test case: " + baseName);
        Assertions.assertTrue(expectedNodes.stream()
            .allMatch(expectedNode -> actualNodes.stream().anyMatch(expectedNode::isEqualNode)),
    "Some nodes in the expected output are not present in the actual output for test case: " + baseName);
    }
}
