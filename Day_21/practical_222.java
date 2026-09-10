package Day_21;

// Q2: try-catch-finally block and resource cleanup flow
public class practical_222 {

    static void divide(int num1, int num2) {
        int data = num1 / num2;
        System.out.println("Result: " + data);
    }

    public static void main(String[] args) {
        System.out.println("=== try-catch-finally Flow Demo ===");

        try {
            System.out.println("1. Inside try block: Division shuru...");
            divide(25, 0); // Triggers ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("2. Inside catch block: Exception handled -> " + e.getMessage());
        } finally {
            System.out.println("3. Inside finally block: Resource cleanup & close (Always executes!)");
        }

        System.out.println("4. Program smoothly continue hua.");
    }
}
