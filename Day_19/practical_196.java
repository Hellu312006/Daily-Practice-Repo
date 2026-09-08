package Day_19;

// Q6: try-catch-finally block example
public class practical_196 {

    static void divide(int num1, int num2) {
        int data = num1 / num2;
        System.out.println("Result: " + data);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Inside try block...");
            divide(25, 0); // Exception trigger
        } catch (ArithmeticException e) {
            System.out.println("Inside catch block: Exception handle hua -> " + e.getMessage());
        } finally {
            System.out.println("Inside finally block: Cleanup task (Always runs!)");
        }

        System.out.println("Main method completed.");
    }
}
