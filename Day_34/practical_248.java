package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 248 / Day 34: Find Sum of All Numbers in an ArrayList
// Tasks:
// - Create an ArrayList of numbers
// - Calculate sum using iterative loop
// - Calculate sum using Java 8 Stream API
// ============================================================================

public class practical_248 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 248: Sum of All Numbers in ArrayList ===");
        System.out.println("=============================================================\n");

        // 1. Create and populate ArrayList of Integers
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(15);
        numbers.add(25);
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        System.out.println("Numbers List: " + numbers);
        System.out.println("Total Count : " + numbers.size());

        // 2. Calculate sum using a loop
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("\n--- 1. Iterative Sum Calculation ---");
        System.out.println("Sum of numbers: " + sum);

        // 3. Calculate sum using Java Streams
        int streamSum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum via Stream API: " + streamSum);

        // 4. Trace addition step-by-step
        System.out.print("\nTrace: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(" + ");
            }
        }
        System.out.println(" = " + sum);

        System.out.println("\n=============================================================");
        System.out.println("Practical 248 executed successfully!");
        System.out.println("=============================================================");
    }
}
