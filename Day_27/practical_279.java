package Day_27;

import java.util.ArrayList;
import java.util.Scanner;

// ============================================================================
// Practical 279: Find total elements in a collection using size()
// ============================================================================

public class practical_279 {
    public static void main(String[] args) {
        System.out.println("=== Practical 279: Find Total Elements using size() ===");

        // 1. Create an ArrayList of Integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // 2. Add elements dynamically from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers do you want to add? ");

        if (scanner.hasNextInt()) {
            int count = scanner.nextInt();

            System.out.println("Enter " + count + " numbers:");
            for (int i = 1; i <= count; i++) {
                System.out.print("Element " + i + ": ");
                int num = scanner.nextInt();
                numbers.add(num);
            }

            // 3. Display the elements and find total count using size()
            System.out.println("\nYour List: " + numbers);
            int totalElements = numbers.size();
            System.out.println("Total elements in the list (using size()): " + totalElements);

        } else {
            System.out.println("Invalid input! Please enter a valid number.");
        }

        scanner.close();
    }
}
