package Day_19;

// Q1: Divide by zero (ArithmeticException) handle karna
public class practical_191 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Zero se divide nahi kar sakte! (" + e.getMessage() + ")");
        }

        System.out.println("Program successfully continue hua.");
    }
}
