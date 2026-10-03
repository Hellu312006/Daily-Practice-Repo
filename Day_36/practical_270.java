package Day_36;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// Practical 270 / Day 36: Display Absolute Path in Java
// Task: Extract and display the absolute and canonical path of a file using File class
// ============================================================================

public class practical_270 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 270: Display Absolute Path in Java          ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name or relative path (e.g., sample.txt or Day_36/demo.txt): ");
        String inputPath = scanner.nextLine().trim();
        String path = inputPath.isEmpty() ? "sample.txt" : inputPath;

        File file = new File(path);

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Path Analysis & Details ---");
        System.out.println("-------------------------------------------------------------");
        System.out.println("1. Input / Relative Path (getPath())         : " + file.getPath());
        System.out.println("2. Absolute Path (getAbsolutePath())         : " + file.getAbsolutePath());

        try {
            // Canonical path resolves relative specifiers (. and ..) and symbolic links
            System.out.println("3. Canonical Path (getCanonicalPath())       : " + file.getCanonicalPath());
        } catch (IOException e) {
            System.err.println("Could not resolve canonical path: " + e.getMessage());
        }

        System.out.println("4. Parent Path (getParent())                 : " + (file.getParent() != null ? file.getParent() : "None"));
        System.out.println("5. Exists on Disk?                           : " + (file.exists() ? "Yes" : "No"));

        scanner.close();

        System.out.println("\n=============================================================");
        System.out.println("Practical 270 executed successfully!");
        System.out.println("=============================================================");
    }
}
