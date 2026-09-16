package Day_27;

import java.util.Scanner;

// ============================================================================
// Practical 283: Demonstrate the use of Multiple Catch Blocks in Java
// ============================================================================

public class practical_283 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 283: Multiple Catch Blocks Demonstration ===\n");

        int[] numbers = { 100, 200, 300, 400 };

        try {
            System.out.print("Enter an array index (0 to 3): ");
            int index = scanner.nextInt();

            System.out.print("Enter a divisor to divide the element: ");
            int divisor = scanner.nextInt();

            // May throw ArrayIndexOutOfBoundsException if index is invalid
            int element = numbers[index];
            System.out.println("Selected element at index " + index + " = " + element);

            // May throw ArithmeticException if divisor is 0
            int result = element / divisor;
            System.out.println("Result (" + element + " / " + divisor + ") = " + result);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Catches array index errors
            System.out.println("\n[Catch Block 1 - ArrayIndexOutOfBoundsException]:");
            System.out.println("Error: Invalid index provided! Array length is " + numbers.length);

        } catch (ArithmeticException e) {
            // Catches division by zero
            System.out.println("\n[Catch Block 2 - ArithmeticException]:");
            System.out.println("Error: Division by zero is not permitted!");

        } catch (Exception e) {
            // Generic catch block for any other unexpected exceptions
            System.out.println("\n[Catch Block 3 - Generic Exception]:");
            System.out.println("Error: An unexpected error occurred -> " + e.getMessage());

        } finally {
            System.out.println("\n[Finally Block]: Scanner closed. Cleanup complete.");
            scanner.close();
        }

        System.out.println("\nProgram continues normally after try-catch-finally.");
    }
}
