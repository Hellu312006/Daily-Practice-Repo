package Day_25;

import java.util.Scanner;

// Practical 271: Handle exception inside a method
public class practical_271 {

    // Method that handles exceptions internally without propagating to the caller
    public static void convertAndCalculateSquare(String input) {
        System.out.println("-> Processing input inside convertAndCalculateSquare()...");
        try {
            int number = Integer.parseInt(input);
            int square = number * number;
            System.out.println("Result: Square of " + number + " is " + square);
        } catch (NumberFormatException e) {
            System.out.println("[Handled Inside Method] Error: Invalid numeric string '" + input + "'. (" + e.getMessage() + ")");
        } finally {
            System.out.println("[Method Cleanup] Finished processing input.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 271: Handle Exception Inside a Method ===");

        System.out.print("Enter a number to calculate its square: ");
        String userInput = scanner.nextLine();

        // Calling method - main method does not require a try-catch block
        convertAndCalculateSquare(userInput);

        System.out.println("\nMain method continues normal execution after method call.");
        scanner.close();
    }
}
