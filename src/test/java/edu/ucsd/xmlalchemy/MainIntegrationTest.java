package edu.ucsd.xmlalchemy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainIntegrationTest {

    private static final String TEST_DATA_DIR = "src/test/resources/milestone1/input";
    private static final String EXPECTED_OUTPUT_DIR = "src/test/resources/milestone1/output";

    @TempDir
    Path tempDir; // JUnit will create and clean up this temporary directory

    @Test
    public void testAppWithMultipleInputFiles() throws IOException {
        File testDataDir = new File(TEST_DATA_DIR);
        File[] inputFiles = testDataDir.listFiles();

        if (inputFiles != null) {
            for (File inputFile : inputFiles) {
                String baseName = inputFile.getName().replace(".txt", ""); // Assumes input files are .txt

                File expectedOutputFile = new File(EXPECTED_OUTPUT_DIR, baseName + ".xml");

                // Output file will be created in the temporary directory
                Path actualOutputPath = tempDir.resolve(baseName + "_output.xml");
                File actualOutputFile = actualOutputPath.toFile();

                // Run the application
                Main.main(new String[]{inputFile.getAbsolutePath(), actualOutputFile.getAbsolutePath()});

                // Read the expected and actual output
                String expectedOutput = new String(Files.readAllBytes(expectedOutputFile.toPath()));
                String actualOutput = new String(Files.readAllBytes(actualOutputPath));

                // Verify the actual output matches the expected output
                Assertions.assertEquals(expectedOutput, actualOutput, "Mismatch in output for test case: " + baseName);
            }
        } else {
            Assertions.fail("No input files found in testData directory.");
        }
    }
}

