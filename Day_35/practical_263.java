package Day_35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// ============================================================================
// Practical 263 / Day 35: Demonstrate Duplicate Values in HashSet
// Tasks:
// - Demonstrate that HashSet rejects duplicate elements
// - Observe the boolean return value of add() (true for new, false for duplicate)
// - Remove duplicates from an ArrayList using HashSet
// ============================================================================

public class practical_263 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 263: Duplicate Values in HashSet ===");
        System.out.println("=============================================================\n");

        // 1. Create HashSet and observe add() return values
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        System.out.println("--- 1. Adding Elements and Checking add() Return Values ---");
        System.out.println("Adding 10 : " + uniqueNumbers.add(10)); // true
        System.out.println("Adding 20 : " + uniqueNumbers.add(20)); // true
        System.out.println("Adding 30 : " + uniqueNumbers.add(30)); // true
        System.out.println("Adding 10 (DUPLICATE) : " + uniqueNumbers.add(10)); // false
        System.out.println("Adding 20 (DUPLICATE) : " + uniqueNumbers.add(20)); // false
        System.out.println("Adding 40 : " + uniqueNumbers.add(40)); // true

        System.out.println("\nHashSet Content: " + uniqueNumbers);
        System.out.println("Total Size     : " + uniqueNumbers.size() + " (Only unique elements are preserved)");

        // 2. Real-world application: Removing duplicates from a List
        System.out.println("\n--- 2. Practical Use Case: Deduplicating a List ---");
        List<Integer> rawScores = new ArrayList<>(Arrays.asList(85, 92, 78, 85, 90, 92, 85, 100, 78));
        System.out.println("Original List with Duplicates: " + rawScores);
        System.out.println("Original List Size           : " + rawScores.size());

        // Pass collection to HashSet constructor to remove duplicates automatically
        HashSet<Integer> cleanScores = new HashSet<>(rawScores);
        System.out.println("Deduplicated Set             : " + cleanScores);
        System.out.println("Unique Elements Count        : " + cleanScores.size());

        System.out.println("\n--- Key Takeaways ---");
        System.out.println("1. HashSet does NOT permit duplicate elements.");
        System.out.println("2. set.add(item) returns 'true' if item is added, and 'false' if it already exists.");
        System.out.println("3. Converting any Collection to a HashSet automatically filters out all duplicates.");

        System.out.println("\n=============================================================");
        System.out.println("Practical 263 executed successfully!");
        System.out.println("=============================================================");
    }
}
