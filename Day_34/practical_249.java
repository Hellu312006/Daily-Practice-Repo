package Day_34;

import java.util.ArrayList;
import java.util.Collections;

// ============================================================================
// Practical 249 / Day 34: Find Maximum Number in an ArrayList
// Tasks:
// - Traverse ArrayList to find max value manually
// - Find max value using Collections.max()
// ============================================================================

public class practical_249 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 249: Find Maximum Number in ArrayList ===");
        System.out.println("=============================================================\n");

        // 1. Create and populate ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(89);
        numbers.add(23);
        numbers.add(67);
        numbers.add(94);
        numbers.add(38);

        System.out.println("Numbers List: " + numbers);
        System.out.println("Total Count : " + numbers.size());

        // 2. Find maximum using manual iteration
        int max = numbers.get(0);
        int maxIndex = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
                maxIndex = i;
            }
        }

        System.out.println("\n--- 1. Manual Iteration Approach ---");
        System.out.println("Maximum Value : " + max);
        System.out.println("Found at Index: " + maxIndex);

        // 3. Find maximum using Collections.max()
        int builtInMax = Collections.max(numbers);
        System.out.println("\n--- 2. Built-in Collections.max() Approach ---");
        System.out.println("Collections.max(numbers) : " + builtInMax);

        System.out.println("\n=============================================================");
        System.out.println("Practical 249 executed successfully!");
        System.out.println("=============================================================");
    }
}
