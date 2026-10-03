package Day_36;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// Practical 274 / Day 36: Read File Line-by-Line using BufferedReader
// Task: Efficiently read a text file line-by-line using BufferedReader.readLine()
// ============================================================================

public class practical_274 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 274: Read File Line-by-Line (BufferedReader)===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        String fileName = "line_read_sample.txt";

        // Setup: Ensure a demo file exists with multiple lines
        File file = new File(fileName);
        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("Core Java Programming\n");
                fw.write("Day 36: File I/O Operations in Depth\n");
                fw.write("BufferedReader provides efficient buffered line reading.\n");
                fw.write("Always close I/O streams using try-with-resources!\n");
                System.out.println("[SETUP] Created sample file '" + fileName + "' for line reading.\n");
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
        System.out.println("--- Reading File Content (Line-by-Line) ---");
        System.out.println("-------------------------------------------------------------");

        int lineCount = 0;
        int wordCount = 0;

        // Using BufferedReader wrapped around FileReader inside try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // readLine() returns null when end of stream is reached
            while ((line = br.readLine()) != null) {
                lineCount++;
                System.out.printf("[%02d] %s%n", lineCount, line);

                // Word count analysis
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    wordCount += trimmed.split("\\s+").length;
                }
            }

            System.out.println("\n-------------------------------------------------------------");
            System.out.println("--- Summary Report ---");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Total Lines Read : " + lineCount);
            System.out.println("Total Words Count: " + wordCount);

        } catch (IOException e) {
            System.err.println("[ERROR] Failed to read file line-by-line: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 274 executed successfully!");
        System.out.println("=============================================================");
    }
}
