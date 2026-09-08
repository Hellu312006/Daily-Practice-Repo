package Day_19;

// Q12: Multiple exceptions in a single catch block
public class practical_202 {

    static void processInput(String str, int index) {
        try {
            int[] arr = { 10, 20, 30 };
            int arrayVal = arr[index];
            int parsedVal = Integer.parseInt(str);
            int result = parsedVal / arrayVal;
            System.out.println("Result: " + result);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Multi-Catch Handled -> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException Handled: Reference null hai!");
        }
    }

    public static void main(String[] args) {
        processInput("abc", 0);
        processInput("100", 5);
    }
}
