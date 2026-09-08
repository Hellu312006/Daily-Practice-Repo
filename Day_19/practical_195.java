package Day_19;

// Q5: Multiple catch blocks handle karna
public class practical_195 {

    static void performOperations(int a, int b) {
        int result = a / b;
        System.out.println("Result: " + result);

        int[] arr = { 10, 20, 30 };
        System.out.println("Array value: " + arr[b]);
    }

    public static void main(String[] args) {
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
            System.out.println("Handled: General exception (" + e.getMessage() + ")");
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
