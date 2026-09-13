package Day_24;

import java.util.Scanner;

// Practical 256: Divide two numbers and handle ArithmeticException
public class practical_256 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 256: Divide Two Numbers (ArithmeticException Demo) ===");

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + numerator + " / " + denominator + " = " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error (ArithmeticException): Cannot divide by zero! (" + e.getMessage() + ")");
        } finally {
            System.out.println("Finally block executed: Scanner closed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
