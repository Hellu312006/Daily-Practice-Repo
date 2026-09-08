package Day_19;

// Q8: 'throws' keyword example (Declaring exceptions in method signature)
public class practical_198 {

    static int divideNumbers(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void main(String[] args) {
        try {
            int result = divideNumbers(40, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Handled in Caller: Cannot divide by zero! (" + e.getMessage() + ")");
        }

        System.out.println("Program completed safely.");
    }
}
