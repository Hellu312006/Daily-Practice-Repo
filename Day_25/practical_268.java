package Day_25;

import java.util.Scanner;

// Practical 268: Demonstrate try-catch-finally block
public class practical_268 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 268: Try-Catch-Finally Execution Flow Demo ===");

        try {
            System.out.println("--- Inside TRY Block ---");
            System.out.print("Enter numerator: ");
            int num = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int den = scanner.nextInt();

            int result = num / den;
            System.out.println("Result: " + num + " / " + den + " = " + result);
            System.out.println("TRY block completed without unhandled errors.");

        } catch (ArithmeticException e) {
            System.out.println("\n--- Inside CATCH Block ---");
            System.out.println("Caught Exception: " + e.getMessage());
            System.out.println("Arithmetic operation failed (division by zero).");

        } finally {
            System.out.println("\n--- Inside FINALLY Block ---");
            System.out.println("The finally block ALWAYS executes regardless of whether an exception occurred or was handled.");
            System.out.println("Closing scanner resource...");
            scanner.close();
        }

        System.out.println("\nProgram execution resumed after try-catch-finally.");
    }
}
