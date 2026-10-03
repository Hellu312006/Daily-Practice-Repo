package Day_36;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// Practical 267 / Day 36: Create a File in Java
// Task: Create a new file on disk using File.createNewFile() and handle exceptions
// ============================================================================

public class practical_267 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 267: Create a File in Java                  ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file to create (e.g., my_new_file.txt): ");
        String inputName = scanner.nextLine().trim();
        String fileName = inputName.isEmpty() ? "my_new_file.txt" : inputName;

        File file = new File(fileName);

        try {
            // createNewFile() returns true if file was created, false if already exists
            boolean isCreated = file.createNewFile();

            if (isCreated) {
                System.out.println("\n[SUCCESS] File created successfully!");
                System.out.println("File Name : " + file.getName());
                System.out.println("Location  : " + file.getAbsolutePath());
            } else {
                System.out.println("\n[NOTICE] File already exists at: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("\n[ERROR] An error occurred while creating the file: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 267 executed successfully!");
        System.out.println("=============================================================");
    }
}
