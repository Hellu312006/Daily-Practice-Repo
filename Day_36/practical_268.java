package Day_36;

import java.io.File;
import java.util.Scanner;

// ============================================================================
// Practical 268 / Day 36: Check Whether a File Exists in Java
// Task: Check if a file or directory exists on the system using File.exists()
// ============================================================================

public class practical_268 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 268: Check Whether File Exists in Java      ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name or path to check (e.g., my_new_file.txt): ");
        String inputName = scanner.nextLine().trim();
        String targetPath = inputName.isEmpty() ? "my_new_file.txt" : inputName;

        File file = new File(targetPath);

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Existence Check Result ---");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Target Name : " + file.getName());
        System.out.println("Target Path : " + file.getAbsolutePath());

        // Checking file existence using file.exists()
        if (file.exists()) {
            System.out.println("Status      : [FOUND] The file/directory EXISTS on disk.");
            if (file.isFile()) {
                System.out.println("Type        : Regular File");
                System.out.println("File Size   : " + file.length() + " bytes");
                System.out.println("Readable    : " + (file.canRead() ? "Yes" : "No"));
                System.out.println("Writable    : " + (file.canWrite() ? "Yes" : "No"));
            } else if (file.isDirectory()) {
                System.out.println("Type        : Directory (Folder)");
            }
        } else {
            System.out.println("Status      : [NOT FOUND] The file/directory does NOT exist.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 268 executed successfully!");
        System.out.println("=============================================================");

        scanner.close();
    }
}
