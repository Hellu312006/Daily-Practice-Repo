package Day_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Q14: Checked Exception Example
// (Checked exceptions compile time par check hote hain aur handle karna mandatory hota hai)
public class practical_204 {

    // Method declares that it can throw checked exception (FileNotFoundException)
    static void readStudentFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file); // Throws FileNotFoundException if file doesn't exist
        
        while (scanner.hasNextLine()) {
            System.out.println("File Content: " + scanner.nextLine());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        String nonExistingFile = "students_data_2026.txt";

        try {
            System.out.println("Attempting to read file: " + nonExistingFile);
            readStudentFile(nonExistingFile);
        } catch (FileNotFoundException e) {
            // Checked Exception handled here
            System.out.println("Checked Exception Caught -> File nahi mili: " + e.getMessage());
        }

        System.out.println("Program completed safely after handling checked exception.");
    }
}
