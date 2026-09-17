package Day_28;

// ============================================================================
// Practical 284: Demonstrate Basic Exception Handling (try-catch) in Java
// ============================================================================

public class practical_284 {
    public static void main(String[] args) {
        System.out.println("Program starts...");

        try {
            int a = 10;
            int b = 0;
            int result = a / b; // Risky code: cannot divide by 0
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handles the error without crashing
            System.out.println("Error: Cannot divide a number by zero!");
        }

        System.out.println("Program continues normally and finishes!");
    }
}
