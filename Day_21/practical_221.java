package Day_21;

// Q1: Multiple catch blocks and exception hierarchy demo
public class practical_221 {

    static void performOperations(int a, int b) {
        int result = a / b;
        System.out.println("Result: " + result);

        int[] arr = { 10, 20, 30 };
        System.out.println("Array value: " + arr[b]);
    }

    public static void main(String[] args) {
        System.out.println("=== Multiple Catch Blocks Demo ===");
        try {
            performOperations(20, 0); // b = 0 triggers ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Handled: Divide by zero error! (" + e.getMessage() + ")");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled: Array index out of bounds!");
        } catch (NumberFormatException e) {
            System.out.println("Handled: Number format exception!");
        } catch (NullPointerException e) {
            System.out.println("Handled: Null pointer exception!");
        } catch (Exception e) {
            // Generic fallback must always be at the bottom
            System.out.println("Handled: General exception (" + e.getMessage() + ")");
        }

        System.out.println("Program executed successfully after handling exception.");
    }
}
