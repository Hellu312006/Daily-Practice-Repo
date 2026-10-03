package Day_36;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// ============================================================================
// Practical 275 / Day 36: Append Data to an Existing File
// Task: Append new text to an existing file without overwriting using FileWriter(file, true)
// ============================================================================

public class practical_275 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 275: Append Data to an Existing File        ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        String fileName = "append_demo.txt";
        File file = new File(fileName);

        // Setup: Create base file with initial content if not present
        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("=== LOG FILE INITIALIZED ===\n");
                fw.write("[Initial Entry] System started successfully.\n");
                System.out.println("[SETUP] Created base file '" + fileName + "' with initial records.\n");
            } catch (IOException e) {
                System.err.println("[SETUP ERROR] " + e.getMessage());
            }
        }

        // Display current contents before appending
        System.out.println("--- 1. File Content BEFORE Appending ---");
        displayFileContent(fileName);

        // Input new message to append
        System.out.print("\nEnter a log message/text to append: ");
        String userInput = scanner.nextLine().trim();
        if (userInput.isEmpty()) {
            userInput = "User session checked at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }

        // Appending to file using FileWriter(fileName, true)
        // Passing 'true' as the second parameter enables APPEND MODE!
        try (FileWriter fw = new FileWriter(fileName, true);
             PrintWriter pw = new PrintWriter(fw)) {

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println("[" + timestamp + "] " + userInput);

            System.out.println("\n[SUCCESS] New data appended to '" + fileName + "' successfully!");

        } catch (IOException e) {
            System.err.println("[ERROR] Failed to append data: " + e.getMessage());
        }

        // Display updated contents after appending
        System.out.println("\n--- 2. File Content AFTER Appending ---");
        displayFileContent(fileName);

        scanner.close();

        System.out.println("\n=============================================================");
        System.out.println("Practical 275 executed successfully!");
        System.out.println("=============================================================");
    }

    // Helper method to print the contents of the file
    private static void displayFileContent(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("(File is empty or does not exist)");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.err.println("Could not display file: " + e.getMessage());
        }
    }
}
