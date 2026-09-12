package Day_23;

// Q11: Handle exception inside a method (Self-contained error handling)
public class practical_251 {

    // Method handles its own exception locally without propagating to caller
    public static void calculateSquareRoot(String numberStr) {
        System.out.println("\n[calculateSquareRoot] Processing input: " + numberStr);
        try {
            double value = Double.parseDouble(numberStr);
            if (value < 0) {
                throw new ArithmeticException("Square root of a negative number is not real!");
            }
            double result = Math.sqrt(value);
            System.out.println("Success: Square root of " + value + " = " + result);
        } catch (NumberFormatException e) {
            System.out.println("Handled Inside Method: Invalid number format -> " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Handled Inside Method: Arithmetic error -> " + e.getMessage());
        } finally {
            System.out.println("[calculateSquareRoot] Method-level cleanup complete.");
        }
    }

    public static void safeArrayLookup(int[] arr, int index) {
        System.out.println("\n[safeArrayLookup] Accessing index: " + index);
        try {
            System.out.println("Element at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled Inside Method: Invalid index accessed (" + index + ") -> " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exception Handled Inside Method Demonstration ===");

        // The caller does not need a try-catch because the method handles errors itself
        calculateSquareRoot("25");
        calculateSquareRoot("invalid_num");
        calculateSquareRoot("-9");

        int[] sample = { 10, 20, 30 };
        safeArrayLookup(sample, 1);
        safeArrayLookup(sample, 10);

        System.out.println("\nCaller / Main method continued seamlessly without interruption.");
    }
}
