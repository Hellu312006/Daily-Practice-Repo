package Day_36;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// ============================================================================
// Practical 280 / Day 36: File Word Counter
// Flow:
//   File  -->  Read data  -->  Count words  -->  Display count & statistics
// ============================================================================

public class practical_280 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 280: File Word & Text Analytics Counter     ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        String sampleFileName = "word_counter_sample.txt";

        // Step 1: Ensure sample file exists for easy testing
        createSampleFileIfMissing(sampleFileName);

        System.out.print("Enter file path to count words (Press Enter for '" + sampleFileName + "'): ");
        String inputPath = scanner.nextLine().trim();
        String targetFile = inputPath.isEmpty() ? sampleFileName : inputPath;

        File file = new File(targetFile);

        // Step 2: Check if file exists
        if (!file.exists()) {
            System.err.println("[ERROR] The specified file '" + targetFile + "' does not exist!");
            scanner.close();
            return;
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Reading Data and Analyzing File ---");
        System.out.println("-------------------------------------------------------------");

        int totalLines = 0;
        int totalWords = 0;
        int totalCharacters = 0;
        int totalCharsWithoutSpaces = 0;
        Set<String> uniqueWords = new HashSet<>();

        // Step 3: Read data & Count words
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
                totalCharacters += line.length();

                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    // Split line into words using whitespace regex
                    String[] words = trimmed.split("\\s+");
                    totalWords += words.length;

                    for (String word : words) {
                        // Strip punctuation for unique word counting
                        String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                        if (!cleanWord.isEmpty()) {
                            uniqueWords.add(cleanWord);
                        }
                        totalCharsWithoutSpaces += word.length();
                    }
                }
            }

            // Step 4: Display count & formatted statistics
            System.out.println("Target File Name         : " + file.getName());
            System.out.println("File Size on Disk        : " + file.length() + " bytes");
            System.out.println("-------------------------------------------------------------");
            System.out.println(">>> TOTAL WORDS COUNT    : " + totalWords);
            System.out.println(">>> TOTAL UNIQUE WORDS   : " + uniqueWords.size());
            System.out.println(">>> TOTAL LINES COUNT    : " + totalLines);
            System.out.println(">>> TOTAL CHARACTERS     : " + totalCharacters);
            System.out.println(">>> CHARS (No Spaces)    : " + totalCharsWithoutSpaces);
            System.out.println("-------------------------------------------------------------");

        } catch (IOException e) {
            System.err.println("[ERROR] Failed to read and count file data: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 280 executed successfully!");
        System.out.println("=============================================================");
    }

    // Helper: Creates a sample text file if none exists
    private static void createSampleFileIfMissing(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("Welcome to Java Programming Day 36.\n");
                fw.write("File handling allows reading and writing persistent data on disk.\n");
                fw.write("Word counting is a fundamental text processing and analytics technique in Java.\n");
                fw.write("Practice daily to master Data Structures, Algorithms, and Core Java!\n");
            } catch (IOException e) {
                System.err.println("[SETUP ERROR] Could not create sample file: " + e.getMessage());
            }
        }
    }
}
