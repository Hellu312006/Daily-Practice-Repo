package Day_24;

import java.util.Scanner;

// Practical 257: Handle ArrayIndexOutOfBoundsException
public class practical_257 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = { 10, 20, 30, 40, 50 };

        System.out.println("=== Practical 257: Array Element Access (ArrayIndexOutOfBoundsException Demo) ===");
        System.out.println("Array elements (Size " + numbers.length + "): [10, 20, 30, 40, 50] (Valid indices: 0 to 4)");

        try {
            System.out.print("Enter array index to access: ");
            int index = scanner.nextInt();

            int element = numbers[index];
            System.out.println("Element at index " + index + " is: " + element);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error (ArrayIndexOutOfBoundsException): Invalid index accessed! (" + e.getMessage() + ")");
        } finally {
            System.out.println("Finally block executed: Scanner closed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}
