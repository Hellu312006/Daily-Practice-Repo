package Day_24;

import java.util.Scanner;

// Practical 262: Handle exception inside a method
public class practical_262 {

    // Method that handles the exception internally
    public static void performDivision(int numerator, int denominator) {
        try {
            int result = numerator / denominator;
            System.out.println("Result: " + numerator + " / " + denominator + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("[Handled Inside Method] Error: Cannot divide by zero! (" + e.getMessage() + ")");
        } finally {
            System.out.println("[Method Cleanup] performDivision() execution completed.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 262: Handle Exception Inside a Method ===");

        System.out.print("Enter numerator: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter denominator: ");
        int num2 = scanner.nextInt();

        // Calling method directly without needing try-catch in main
        System.out.println("\nCalling performDivision()...");
        performDivision(num1, num2);

        System.out.println("\nMain method continues normal execution.");
        scanner.close();
    }
}
