package Day_23;

import java.util.Scanner;

// Q12: Handle multiple different exceptions using multi-catch and dedicated catch blocks
public class practical_252 {

    public static void executeOperations(String input1, String input2, int arrayIndex) {
        System.out.println("\n--- Processing inputs: (" + input1 + ", " + input2 + ") & Index: " + arrayIndex + " ---");
        try {
            // Potential NumberFormatException
            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);

            // Potential ArithmeticException
            int division = num1 / num2;
            System.out.println("Division result: " + division);

            // Potential ArrayIndexOutOfBoundsException
            int[] scores = { 85, 92, 78, 90 };
            System.out.println("Score at index " + arrayIndex + ": " + scores[arrayIndex]);

            // Potential NullPointerException
            String greeting = (num1 > 0) ? "Hello World" : null;
            System.out.println("Greeting character count: " + greeting.length());

        } catch (NumberFormatException | NullPointerException e) {
            // Java 7+ Multi-catch syntax combining related unchecked exceptions
            System.out.println("[Multi-Catch]: Caught " + e.getClass().getSimpleName() + " -> " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("[Dedicated Catch]: Division error -> " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[Dedicated Catch]: Array boundary error -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[Generic Catch]: Other exception -> " + e.getMessage());
        } finally {
            System.out.println("[Finally]: Cleaned up resources for this run.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Multiple Different Exceptions Handling Demo ===");

        // Test Case 1: Normal Execution
        executeOperations("100", "5", 2);

        // Test Case 2: ArithmeticException
        executeOperations("100", "0", 1);

        // Test Case 3: NumberFormatException
        executeOperations("abc", "10", 0);

        // Test Case 4: ArrayIndexOutOfBoundsException
        executeOperations("50", "2", 8);

        // Test Case 5: NullPointerException
        executeOperations("-5", "1", 0);

        System.out.println("\nAll different exception scenarios tested successfully.");
    }
}
