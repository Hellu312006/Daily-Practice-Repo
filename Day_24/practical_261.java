package Day_24;

import java.util.Scanner;

// Practical 261: Create nested try-catch blocks
public class practical_261 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = { 20, 40, 60 };

        System.out.println("=== Practical 261: Nested try-catch Demo ===");
        System.out.println("Array elements: [20, 40, 60] (Indices 0 to 2)");

        // Outer try block
        try {
            System.out.print("Enter index to access array (0 to 2): ");
            int index = scanner.nextInt();

            // Inner try block 1: Handles ArrayIndexOutOfBoundsException
            try {
                int value = numbers[index];
                System.out.println("Selected value at index " + index + ": " + value);

                // Inner try block 2: Handles ArithmeticException
                try {
                    System.out.print("Enter number to divide " + value + " by: ");
                    int divisor = scanner.nextInt();

                    int result = value / divisor;
                    System.out.println("Result: " + value + " / " + divisor + " = " + result);

                } catch (ArithmeticException e) {
                    System.out.println("[Inner Catch - Division]: Cannot divide by zero! (" + e.getMessage() + ")");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[Inner Catch - Array]: Array index out of bounds! (" + e.getMessage() + ")");
            }

        } catch (Exception e) {
            System.out.println("[Outer Catch]: General exception caught: " + e.getMessage());
        } finally {
            System.out.println("\n[Finally Block]: Resources cleaned up.");
            scanner.close();
        }

        System.out.println("Program completed safely.");
    }
}
