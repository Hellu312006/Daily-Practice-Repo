package Day_34;

import java.util.ArrayList;
import java.util.Collections;

// ============================================================================
// Practical 250 / Day 34: Find Minimum Number in an ArrayList
// Tasks:
// - Traverse ArrayList to find min value manually
// - Find min value using Collections.min()
// ============================================================================

public class practical_250 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 250: Find Minimum Number in ArrayList ===");
        System.out.println("=============================================================\n");

        // 1. Create and populate ArrayList (including negative numbers)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(28);
        numbers.add(64);
        numbers.add(14);
        numbers.add(92);
        numbers.add(-5);
        numbers.add(33);
        numbers.add(7);

        System.out.println("Numbers List: " + numbers);
        System.out.println("Total Count : " + numbers.size());

        // 2. Find minimum using manual iteration
        int min = numbers.get(0);
        int minIndex = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
                minIndex = i;
            }
        }

        System.out.println("\n--- 1. Manual Iteration Approach ---");
        System.out.println("Minimum Value : " + min);
        System.out.println("Found at Index: " + minIndex);

        // 3. Find minimum using Collections.min()
        int builtInMin = Collections.min(numbers);
        System.out.println("\n--- 2. Built-in Collections.min() Approach ---");
        System.out.println("Collections.min(numbers) : " + builtInMin);

        System.out.println("\n=============================================================");
        System.out.println("Practical 250 executed successfully!");
        System.out.println("=============================================================");
    }
}
