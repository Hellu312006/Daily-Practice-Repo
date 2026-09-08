package Day_19;

// Q10: Nested try-catch block example
public class practical_200 {

    static void executeDivision(int a, int b) {
        int res = a / b;
        System.out.println("Result: " + res);
    }

    static void accessArray(int[] arr, int index) {
        System.out.println("Value: " + arr[index]);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Outer try block shuru hua...");

            // Inner try-catch 1
            try {
                System.out.println("Inner block 1: Division");
                executeDivision(50, 0);
            } catch (ArithmeticException e) {
                System.out.println("Inner Catch 1 Handled: " + e.getMessage());
            }

            // Inner try-catch 2
            try {
                System.out.println("Inner block 2: Array access");
                int[] data = { 1, 2, 3 };
                accessArray(data, 5);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner Catch 2 Handled: " + e.getMessage());
            }

            System.out.println("Outer try block complete.");

        } catch (Exception e) {
            System.out.println("Outer Catch Handled: " + e.getMessage());
        }

        System.out.println("Program completed.");
    }
}
