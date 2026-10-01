package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 238 / Day 34: Add 5 integers in an ArrayList and print them
// ============================================================================

public class practical_238 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 238: ArrayList of 5 Integers ===");
        System.out.println("=============================================================\n");

        // 1. Create an ArrayList of Integer type
        ArrayList<Integer> numbers = new ArrayList<>();

        // 2. Add 5 integers
        numbers.add(10);
        numbers.add(25);
        numbers.add(42);
        numbers.add(78);
        numbers.add(99);

        // 3. Print complete ArrayList
        System.out.println("Complete ArrayList: " + numbers);
        System.out.println("Total Count       : " + numbers.size());

        // 4. Print integers using for-each loop
        System.out.print("\nPrinting integers using for-each loop: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 5. Calculate and print sum
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of integers   : " + sum);

        System.out.println("\n=============================================================");
        System.out.println("Practical 238 executed successfully!");
        System.out.println("=============================================================");
    }
}
