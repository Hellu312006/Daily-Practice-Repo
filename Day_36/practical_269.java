package Day_36;

import java.io.File;
import java.util.Scanner;

// ============================================================================
// Practical 269 / Day 36: Display File Name in Java
// Task: Extract and display the file name and path information using File.getName()
// ============================================================================

public class practical_269 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 269: Display File Name & Path Details       ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name or path (e.g., C:\\Daily Practice Repo\\Day_36\\demo.txt or sample.txt): ");
        String inputPath = scanner.nextLine().trim();
        String path = inputPath.isEmpty() ? "sample_document.txt" : inputPath;

        File file = new File(path);

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- File Name & Path Information ---");
        System.out.println("-------------------------------------------------------------");

        // 1. Display File Name using getName()
        System.out.println("1. File Name (getName())              : " + file.getName());

        // 2. Display Path
        System.out.println("2. Relative Path (getPath())          : " + file.getPath());

        // 3. Display Absolute Path
        System.out.println("3. Absolute Path (getAbsolutePath())  : " + file.getAbsolutePath());

        // 4. Display Parent Directory
        String parent = file.getParent();
        System.out.println("4. Parent Directory (getParent())     : " + (parent != null ? parent : "None (Current Directory)"));

        scanner.close();

        System.out.println("\n=============================================================");
        System.out.println("Practical 269 executed successfully!");
        System.out.println("=============================================================");
    }
}
