package Day_36;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// Practical 271 / Day 36: Delete a File in Java
// Task: Delete an existing file using File.delete() and verify deletion
// ============================================================================

public class practical_271 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 271: Delete a File in Java                  ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Options:");
        System.out.println("1. Create a dummy file and delete it (Demo Mode)");
        System.out.println("2. Enter an existing file name to delete");
        System.out.print("Choose option (1 or 2) [Default 1]: ");
        String choice = scanner.nextLine().trim();

        String targetFileName;
        if ("2".equals(choice)) {
            System.out.print("Enter file name to delete: ");
            targetFileName = scanner.nextLine().trim();
            if (targetFileName.isEmpty()) targetFileName = "temp_to_delete.txt";
        } else {
            targetFileName = "temp_to_delete.txt";
            // Create the dummy file first so user can see it getting deleted
            File tempFile = new File(targetFileName);
            try {
                if (tempFile.createNewFile()) {
                    System.out.println("\n[SETUP] Created sample file '" + targetFileName + "' for deletion demonstration.");
                }
            } catch (IOException e) {
                System.err.println("[SETUP ERROR] Failed to create sample file: " + e.getMessage());
            }
        }

        File file = new File(targetFileName);

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Deletion Process ---");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Target File           : " + file.getName());
        System.out.println("Exists before delete? : " + (file.exists() ? "Yes" : "No"));

        if (file.exists()) {
            // Attempt deletion using file.delete()
            boolean isDeleted = file.delete();

            if (isDeleted) {
                System.out.println("Status                : [SUCCESS] File deleted successfully!");
            } else {
                System.out.println("Status                : [FAILED] Could not delete file (permission denied or locked).");
            }
        } else {
            System.out.println("Status                : [NOT FOUND] File does not exist, nothing to delete.");
        }

        System.out.println("Exists after delete?  : " + (file.exists() ? "Yes" : "No"));

        scanner.close();

        System.out.println("\n=============================================================");
        System.out.println("Practical 271 executed successfully!");
        System.out.println("=============================================================");
    }
}
