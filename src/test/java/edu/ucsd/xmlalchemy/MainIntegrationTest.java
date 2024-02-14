package edu.ucsd.xmlalchemy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.DifferenceEvaluators;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.ElementSelectors;

class MainIntegrationTest {

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
                Set<String> skippedBaseNames = Set.of("additional3", "additional8");
                if (skippedBaseNames.contains(baseName)) {
                    continue;
                }

                // Evaluate the query
                var actualNodes = Main.query(inputFile.getAbsolutePath());
                var actualDocument = Main.transform(actualNodes);

                // Read the expected output
                try {
                    var expectedOutputFile = new File(EXPECTED_OUTPUT_DIR, baseName + ".xml");
                    var dbf = DocumentBuilderFactory.newDefaultInstance();
                    var db = dbf.newDocumentBuilder();
                    var expectedDocument = db.parse(expectedOutputFile);
                    expectedDocument.normalize();
                    Utils.trimTextNodes(expectedDocument.getDocumentElement());
                    assertResult(baseName, expectedDocument, actualDocument);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    throw e;
                }

            }
        } else {
            Assertions.fail("No input files found in testData directory.");
        }
    }

    // FIXME: This method still does not work with the re-ordering of elements
    // when the tree is deep enough and ElementSelectors.byNameAndText is not sufficient
    // Check testcase rule20
    // Reference: https://github.com/xmlunit/xmlunit/issues/123
    public void assertResultXMLUnit(String baseName, Document expectedDocument, Document actualDocument) {
        Diff diff = DiffBuilder.compare(Input.fromDocument(expectedDocument))
                .withTest(Input.fromDocument(actualDocument))
                .ignoreWhitespace()
                .normalizeWhitespace()
                .withDifferenceEvaluator(DifferenceEvaluators.Default)
                .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
                .checkForSimilar()
                .build();
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
        var actualNodes =
                IntStream.range(0, actualNodeList.getLength()).mapToObj(actualNodeList::item)
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
