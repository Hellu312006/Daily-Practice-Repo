package Day_23;

import java.util.Scanner;

// Q1: Divide two numbers and handle ArithmeticException using try-catch-finally
public class practical_241 {

    // Method to perform division
    public static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 1. Divide Two Numbers (ArithmeticException Demo) ===");

        try {
            System.out.print("Enter numerator: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int num2 = scanner.nextInt();

            int result = divide(num1, num2);
            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);

        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: Cannot divide by zero! (" + e.getMessage() + ")");
        } finally {
            System.out.println("Finally block executed: Closing resources...");
            scanner.close();
        }

        System.out.println("Program resumed normal execution.");
    }
}
