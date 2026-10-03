package Day_36;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// Practical 273 / Day 36: Read File Character-by-Character
// Task: Read and process a text file one character at a time using FileReader
// ============================================================================

public class practical_273 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 273: Read File Character-by-Character       ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        String fileName = "char_read_sample.txt";

        // Setup: Create a sample file with text if it doesn't exist
        File file = new File(fileName);
        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("Java File Handling\nCharacter by Character Reading Demo.\nPractice makes perfect!");
                System.out.println("[SETUP] Created sample file '" + fileName + "' for demonstration.\n");
            } catch (IOException e) {
                System.err.println("[SETUP ERROR] " + e.getMessage());
            }
        }

        System.out.print("Enter file name to read (Press Enter for '" + fileName + "'): ");
        String inputName = scanner.nextLine().trim();
        if (!inputName.isEmpty()) {
            fileName = inputName;
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Reading File: " + fileName + " ---");
        System.out.println("-------------------------------------------------------------");

        int charCount = 0;
        int vowelCount = 0;
        int whitespaceCount = 0;

        // Reading file character-by-character using FileReader.read()
        try (FileReader reader = new FileReader(fileName)) {
            int characterCode;

            System.out.println("--- File Content Output ---");
            // reader.read() returns -1 when end of file (EOF) is reached
            while ((characterCode = reader.read()) != -1) {
                char ch = (char) characterCode;
                System.out.print(ch);

                charCount++;
                if (Character.isWhitespace(ch)) {
                    whitespaceCount++;
                }
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowelCount++;
                }
            }

            System.out.println("\n-------------------------------------------------------------");
            System.out.println("--- Character Analysis Summary ---");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Total Characters Read : " + charCount);
            System.out.println("Total Vowels Found    : " + vowelCount);
            System.out.println("Whitespace Characters : " + whitespaceCount);

        } catch (IOException e) {
            System.err.println("[ERROR] Failed to read file: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 273 executed successfully!");
        System.out.println("=============================================================");
    }
}
