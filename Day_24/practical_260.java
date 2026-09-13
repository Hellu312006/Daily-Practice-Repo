package Day_24;

import java.util.Scanner;

// Practical 260: Use 'throw' keyword for age validation
public class practical_260 {

    // Method to validate age using throw
    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        } else if (age < 18) {
            throw new ArithmeticException("Underage: Not eligible to vote! (Age must be 18+)");
        } else {
            System.out.println("Eligible to vote! Registration successful.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 260: Age Validation using 'throw' ===");

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            validateAge(age);

        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed: Scanner closed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
