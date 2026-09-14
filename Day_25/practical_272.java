package Day_25;

import java.util.Scanner;

// Custom Exception class for Marks validation
class MarksException extends Exception {
    public MarksException(String message) {
        super(message);
    }
}

// Practical 272: Create a custom MarksException
public class practical_272 {

    // Method to validate marks and throw custom MarksException
    public static void validateMarks(String subject, int marks) throws MarksException {
        System.out.println("\nValidating marks for subject: " + subject);

        if (marks < 0) {
            throw new MarksException("Invalid Marks: Marks cannot be negative (" + marks + ").");
        } else if (marks > 100) {
            throw new MarksException("Invalid Marks: Marks cannot exceed maximum limit of 100 (" + marks + ").");
        } else if (marks < 40) {
            throw new MarksException("Failed: Scored " + marks + "/100. Minimum passing score is 40.");
        } else {
            System.out.println("Result: PASSED in " + subject + " with " + marks + "/100 marks!");
            if (marks >= 75) {
                System.out.println("Distinction awarded! Excellent performance.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 272: Custom MarksException Demo ===");

        try {
            System.out.print("Enter Subject Name: ");
            String subject = scanner.nextLine();

            System.out.print("Enter Marks obtained (0 - 100): ");
            int marks = scanner.nextInt();

            // Calling validation method
            validateMarks(subject, marks);

        } catch (MarksException e) {
            System.out.println("\n[Custom Exception Caught]");
            System.out.println("MarksException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[Input Error]: Please enter valid numeric marks.");
        } finally {
            System.out.println("\nFinally block executed: Validation complete, closing scanner.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
