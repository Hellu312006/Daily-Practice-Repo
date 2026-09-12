package Day_23;

// Q10: Nested try-catch blocks demonstration
public class practical_250 {
    public static void main(String[] args) {
        System.out.println("=== Nested try-catch Blocks Demonstration ===");

        // Outer try block
        try {
            System.out.println("\n[Outer Try Block]: Starting main process...");

            // Inner try-catch Block 1: Arithmetic Operation
            try {
                System.out.println("\n  [Inner Try 1]: Performing mathematical division...");
                int dividend = 100;
                int divisor = 0; // Triggers ArithmeticException
                int res = dividend / divisor;
                System.out.println("  Result: " + res);
            } catch (ArithmeticException e) {
                System.out.println("  [Inner Catch 1]: ArithmeticException handled locally -> " + e.getMessage());
            }

            // Inner try-catch Block 2: Array Access
            try {
                System.out.println("\n  [Inner Try 2]: Accessing array elements...");
                int[] data = { 10, 20, 30 };
                System.out.println("  Element at index 5: " + data[5]); // Triggers ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("  [Inner Catch 2]: ArrayIndexOutOfBoundsException handled locally -> " + e.getMessage());
            }

            // Inner try-catch Block 3: String Parsing
            try {
                System.out.println("\n  [Inner Try 3]: Parsing string into integer...");
                String invalidNumber = "abc123";
                int parsed = Integer.parseInt(invalidNumber); // Triggers NumberFormatException
                System.out.println("  Parsed number: " + parsed);
            } catch (NumberFormatException e) {
                System.out.println("  [Inner Catch 3]: NumberFormatException handled locally -> " + e.getMessage());
            }

            // Outer operation that succeeds
            System.out.println("\n[Outer Try Block]: Completing all tasks successfully.");

        } catch (Exception e) {
            // Catches any exception not handled by inner blocks
            System.out.println("\n[Outer Catch]: Handled unhandled outer exception -> " + e.getMessage());
        } finally {
            System.out.println("\n[Outer Finally]: All nested and outer try-catch blocks finished.");
        }

        System.out.println("\nProgram executed smoothly beyond nested try-catch.");
    }
}
