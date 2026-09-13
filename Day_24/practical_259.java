package Day_24;

import java.util.Scanner;

// Practical 259: Create a method using throws keyword
public class practical_259 {

    // Method declaring that it can throw ArithmeticException
    public static int divide(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 259: Method with 'throws' Keyword ===");

        try {
            System.out.print("Enter numerator: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int num2 = scanner.nextInt();

            // Calling method that declares 'throws ArithmeticException'
            int result = divide(num1, num2);
            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);

        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main(): " + e.getMessage());
        } finally {
            System.out.println("Finally block executed: Scanner closed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
