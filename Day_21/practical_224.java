package Day_21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Q4: Checked vs Unchecked Exception handling (FileNotFoundException)
public class practical_224 {

    // Method declares a checked exception; compiler enforces handling
    static void readStudentFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file); // Throws checked FileNotFoundException if not present

        while (scanner.hasNextLine()) {
            System.out.println("Line: " + scanner.nextLine());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("=== Checked Exception (Compile-Time) Demo ===");

        String fileName = "students_data_2026.txt";

        try {
            System.out.println("Attempting to open file: " + fileName);
            readStudentFile(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Checked Exception Caught -> File nahi mili: " + e.getMessage());
        }

        System.out.println("Program safely recovered after checked exception.");
    }
}
