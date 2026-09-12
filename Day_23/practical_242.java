package Day_23;

import java.util.Scanner;

// Q2: Handle ArrayIndexOutOfBoundsException using try-catch-finally
public class practical_242 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = { 10, 20, 30, 40, 50 };

        System.out.println("=== 2. Array Element Access (ArrayIndexOutOfBoundsException Demo) ===");
        System.out.println("Array elements (Size " + numbers.length + "): [10, 20, 30, 40, 50]");

        try {
            System.out.print("Enter index to access (0 to 4): ");
            int index = scanner.nextInt();

            int element = numbers[index];
            System.out.println("Element at index " + index + " is: " + element);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: Invalid index accessed! (" + e.getMessage() + ")");
        } finally {
            System.out.println("Finally block executed: Scanner cleanup completed.");
            scanner.close();
        }

        System.out.println("Program executed successfully after handling array exception.");
    }
}
