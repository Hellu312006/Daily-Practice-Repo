package Day_23;

// Q7: Printing exception message using getMessage() and comparing methods
public class practical_247 {

    static void demonstrateDivisionByZero() {
        int numerator = 50;
        int denominator = 0;
        int result = numerator / denominator;
        System.out.println("Result: " + result);
    }

    static void demonstrateArrayAccess() {
        int[] numbers = { 5, 10, 15 };
        System.out.println("Value: " + numbers[10]);
    }

    public static void main(String[] args) {
        System.out.println("=== Printing Exception Details using getMessage() ===");

        // Example 1: getMessage() on ArithmeticException
        try {
            System.out.println("\n--- Test 1: ArithmeticException ---");
            demonstrateDivisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("1. Using e.getMessage(): " + e.getMessage());
            System.out.println("2. Using e.toString():   " + e.toString());
            System.out.println("3. Custom formatted:     Division error occurred -> " + e.getMessage());
        }

        // Example 2: getMessage() on ArrayIndexOutOfBoundsException
        try {
            System.out.println("\n--- Test 2: ArrayIndexOutOfBoundsException ---");
            demonstrateArrayAccess();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("1. Using e.getMessage(): Index out of bounds -> " + e.getMessage());
            System.out.println("2. Using e.toString():   " + e.toString());
        }

        // Example 3: getMessage() with Custom Message
        try {
            System.out.println("\n--- Test 3: Custom Thrown Exception ---");
            throw new IllegalArgumentException("Invalid user configuration provided!");
        } catch (IllegalArgumentException e) {
            System.out.println("1. Extracted Message: " + e.getMessage());
        }

        System.out.println("\nAll exception messages printed successfully.");
    }
}
