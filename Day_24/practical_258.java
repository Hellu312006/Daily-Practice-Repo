package Day_24;

import java.util.Scanner;

// Practical 258: Print exception message using getMessage()
public class practical_258 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 258: Print Exception Message using getMessage() ===");

        try {
            System.out.print("Enter a number to divide 100 by: ");
            int divisor = scanner.nextInt();

            int result = 100 / divisor;
            System.out.println("Result: 100 / " + divisor + " = " + result);

        } catch (ArithmeticException e) {
            System.out.println("\n[Exception Caught]");
            System.out.println("Exception Type    : " + e.getClass().getSimpleName());
            System.out.println("Using getMessage(): " + e.getMessage());
            System.out.println("Full Details      : Division failed because -> " + e.getMessage());
        } finally {
            System.out.println("\nFinally block executed: Scanner closed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
