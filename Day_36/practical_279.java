package Day_36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// ============================================================================
// Practical 279 / Day 36: Notes App in Java
// Flow:
//   Enter note  -->  Save in notes.txt  -->  Read & Display saved notes
// Features: Add Note, View All Notes, Clear Notes
// ============================================================================

public class practical_279 {
    private static final String NOTES_FILE = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=============================================================");
            System.out.println("=== Practical 279: Quick Notes App (File-Based Storage)   ===");
            System.out.println("=============================================================");
            System.out.println("1. Add a New Note (Save to " + NOTES_FILE + ")");
            System.out.println("2. View All Notes");
            System.out.println("3. Clear All Notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addNote(scanner);
                    break;
                case "2":
                    viewNotes();
                    break;
                case "3":
                    clearNotes(scanner);
                    break;
                case "4":
                    System.out.println("\nExiting Notes App. Goodbye!");
                    System.out.println("=============================================================");
                    scanner.close();
                    return;
                default:
                    System.out.println("[INVALID] Please choose a valid option (1-4).");
            }
        }
    }

    // 1. Add Note -> Save to notes.txt
    private static void addNote(Scanner scanner) {
        System.out.println("\n--- Add New Note ---");
        System.out.print("Enter your note: ");
        String noteContent = scanner.nextLine().trim();

        if (noteContent.isEmpty()) {
            System.out.println("[WARNING] Note cannot be empty!");
            return;
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String entry = "[" + timestamp + "] " + noteContent;

        // Append note to notes.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOTES_FILE, true))) {
            bw.write(entry);
            bw.newLine();
            System.out.println("[SUCCESS] Note saved successfully in '" + NOTES_FILE + "'!");
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to save note: " + e.getMessage());
        }
    }

    // 2. Read and View All Notes from notes.txt
    private static void viewNotes() {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("                     YOUR SAVED NOTES                        ");
        System.out.println("-------------------------------------------------------------");

        File file = new File(NOTES_FILE);
        if (!file.exists() || file.length() == 0) {
            System.out.println("  (No notes found. Choose Option 1 to create your first note!)");
            System.out.println("-------------------------------------------------------------");
            return;
        }

        int noteNumber = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Note #" + (noteNumber++) + ": " + line);
            }
            System.out.println("-------------------------------------------------------------");
            System.out.println("Total Notes: " + (noteNumber - 1));
        } catch (IOException e) {
            System.err.println("[ERROR] Could not read notes: " + e.getMessage());
        }
    }

    // 3. Clear All Notes (Overwrites with empty file)
    private static void clearNotes(Scanner scanner) {
        System.out.print("\nAre you sure you want to delete all notes? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if ("y".equals(confirm) || "yes".equals(confirm)) {
            try (FileWriter fw = new FileWriter(NOTES_FILE)) {
                // Empty write clears the file
                System.out.println("[SUCCESS] All notes cleared successfully!");
            } catch (IOException e) {
                System.err.println("[ERROR] Failed to clear notes: " + e.getMessage());
            }
        } else {
            System.out.println("[CANCELLED] Action cancelled.");
        }
    }
}
