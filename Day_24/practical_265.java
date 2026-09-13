package Day_24;

import java.util.Scanner;

// Custom Exception for Marks Validation
class MarksException extends Exception {
    public MarksException(String message) {
        super(message);
    }
}

// Practical 265: Create and handle custom MarksException
public class practical_265 {

    // Method to validate marks
    public static void validateMarks(int marks) throws MarksException {
        if (marks < 0 || marks > 100) {
            throw new MarksException("Invalid Marks: " + marks + "! Marks must be in the range 0 to 100.");
        } else if (marks < 35) {
            throw new MarksException("Failed: Scored " + marks + " marks. Minimum passing marks is 35.");
        } else {
            System.out.println("Result: PASSED with " + marks + "/100 marks!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 265: Custom MarksException Demo ===");

        try {
            System.out.print("Enter student marks (0 - 100): ");
            int marks = scanner.nextInt();

            validateMarks(marks);

        } catch (MarksException e) {
            System.out.println("Caught Custom Exception (MarksException): " + e.getMessage());
        } finally {
            System.out.println("Finally block executed: Scanner closed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
