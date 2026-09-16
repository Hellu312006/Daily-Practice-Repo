package Day_27;

import java.util.ArrayList;
import java.util.Scanner;

// ============================================================================
// Practical 278: Check whether a number exists in a list using contains()
// ============================================================================

public class practical_278 {
    public static void main(String[] args) {
        System.out.println("=== Practical 278: Check Element Existence using contains() ===");

        // 1. Create an ArrayList of Integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // 2. Add numbers to the list
        numbers.add(10);
        numbers.add(25);
        numbers.add(50);
        numbers.add(75);
        numbers.add(100);

        // Display current elements
        System.out.println("List of numbers: " + numbers);

        // 3. User input to check if a number exists
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a number to check: ");

        if (scanner.hasNextInt()) {
            int target = scanner.nextInt();

            // Using contains() method
            if (numbers.contains(target)) {
                System.out.println("Result: " + target + " is present in the list.");
            } else {
                System.out.println("Result: " + target + " is NOT present in the list.");
            }
        } else {
            System.out.println("Invalid input! Please enter an integer.");
        }

        scanner.close();
    }
}
