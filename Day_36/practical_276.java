package Day_36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// Practical 276 / Day 36: Write Multiple Lines using BufferedWriter
// Task: Efficiently write multiple lines of text into a file using BufferedWriter
// ============================================================================

public class practical_276 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 276: Write Multiple Lines (BufferedWriter)  ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        String fileName = "buffered_writer_output.txt";

        System.out.println("Choose an option:");
        System.out.println("1. Write predefined multi-line text (Demo)");
        System.out.println("2. Enter your own custom lines");
        System.out.print("Enter choice (1 or 2) [Default 1]: ");
        String choice = scanner.nextLine().trim();

        String[] linesToWrite;

        if ("2".equals(choice)) {
            System.out.print("How many lines do you want to write? (e.g., 3): ");
            int count = 3;
            try {
                count = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                count = 3;
            }

            linesToWrite = new String[count];
            for (int i = 0; i < count; i++) {
                System.out.print("Enter line #" + (i + 1) + ": ");
                linesToWrite[i] = scanner.nextLine();
            }
        } else {
            linesToWrite = new String[] {
                "==========================================",
                "Java Programming - Day 36 Practice",
                "Topic: BufferedWriter Multi-Line Writing",
                "BufferedWriter provides efficient buffering for character output.",
                "Using bw.newLine() ensures cross-platform line breaks.",
                "=========================================="
            };
        }

        // Writing multiple lines using BufferedWriter
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Writing to File: " + fileName + " ---");
        System.out.println("-------------------------------------------------------------");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : linesToWrite) {
                bw.write(line);
                bw.newLine(); // Platform-independent newline separator
            }
            bw.flush(); // Ensure all buffered characters are written to disk

            System.out.println("[SUCCESS] Successfully written " + linesToWrite.length + " lines using BufferedWriter!");

        } catch (IOException e) {
            System.err.println("[ERROR] Failed to write lines: " + e.getMessage());
        }

        // Verification: Read back and display the file contents
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Verifying Written File Content ---");
        System.out.println("-------------------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNum = 1;
            while ((line = br.readLine()) != null) {
                System.out.printf("[%02d] %s%n", lineNum++, line);
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to verify file: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 276 executed successfully!");
        System.out.println("=============================================================");
    }
}
