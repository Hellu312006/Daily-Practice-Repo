package Day_24;

import java.util.Scanner;

// Custom Exception for Age Validation
class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

// Practical 264: Create and handle custom AgeException
public class practical_264 {

    // Method to validate age
    public static void checkAge(int age) throws AgeException {
        if (age < 0) {
            throw new AgeException("Invalid Age: Age cannot be negative! (" + age + ")");
        } else if (age < 18) {
            throw new AgeException("Age " + age + " is not eligible: Must be 18 years or older!");
        } else if (age > 100) {
            throw new AgeException("Age " + age + " is invalid: Must be 100 years or younger!");
        } else {
            System.out.println("Valid Age (" + age + "): Age verification successful!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 264: Custom AgeException Demo ===");

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            checkAge(age);

        } catch (AgeException e) {
            System.out.println("Caught Custom Exception (AgeException): " + e.getMessage());
        } finally {
            System.out.println("Finally block executed: Scanner closed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
