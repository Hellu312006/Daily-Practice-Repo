package Day_23;

import java.util.Scanner;

// Q9: Explicitly throw an exception using 'throw' for age validation
public class practical_249 {

    // Method to validate age using the 'throw' keyword
    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative! Received: " + age);
        } else if (age < 18) {
            throw new ArithmeticException("Access Denied: You must be at least 18 years old to vote! (Your age: " + age + ")");
        } else {
            System.out.println("Access Granted: You are eligible to vote at age " + age + ".");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Age Validation using 'throw' Keyword ===");

        // Test with user input
        try {
            System.out.print("Enter your age: ");
            int userAge = scanner.nextInt();

            // Validate age
            validateAge(userAge);

        } catch (ArithmeticException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid Input Format! Please enter a valid number.");
        } finally {
            System.out.println("Finally Block: Age verification process ended.");
            scanner.close();
        }

        System.out.println("Program resumed normal execution.");
    }
}
