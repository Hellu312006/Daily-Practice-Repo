package Day_24;

import java.util.Scanner;

// Practical 263: Handle multiple different exceptions
public class practical_263 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = { 100, 200, 300, 400 };

        System.out.println("=== Practical 263: Handle Multiple Different Exceptions ===");
        System.out.println("Array elements: [100, 200, 300, 400] (Valid indices: 0 to 3)");

        try {
            System.out.print("\nEnter array index: ");
            String indexInput = scanner.nextLine();
            int index = Integer.parseInt(indexInput); // Can throw NumberFormatException

            int value = data[index]; // Can throw ArrayIndexOutOfBoundsException
            System.out.println("Selected element at index " + index + ": " + value);

            System.out.print("Enter divisor: ");
            String divisorInput = scanner.nextLine();
            int divisor = Integer.parseInt(divisorInput); // Can throw NumberFormatException

            int result = value / divisor; // Can throw ArithmeticException
            System.out.println("Result: " + value + " / " + divisor + " = " + result);

        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Please enter valid integer numbers only! [" + e.getMessage() + "]");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: Invalid array index! [" + e.getMessage() + "]");
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: Division by zero is not allowed! [" + e.getMessage() + "]");
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        } finally {
            System.out.println("\nFinally block executed: Resource cleanup completed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
