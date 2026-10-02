package Day_35;

import java.util.Arrays;
import java.util.HashSet;

// ============================================================================
// Practical 265 / Day 35: Remove a Value and Find Size in HashSet
// Tasks:
// - Populate HashSet with elements
// - Remove an existing element using remove() and inspect return value (true)
// - Try removing a non-existing element (false)
// - Track and display HashSet size after each removal operation
// - Bulk removal using removeAll() and complete reset using clear()
// ============================================================================

public class practical_265 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 265: Remove Value & Find Size in HashSet ===");
        System.out.println("=============================================================\n");

        // 1. Initialize HashSet with programming languages
        HashSet<String> languages = new HashSet<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");
        languages.add("Go");
        languages.add("Rust");
        languages.add("Kotlin");

        System.out.println("--- 1. Initial HashSet ---");
        System.out.println("Elements     : " + languages);
        System.out.println("Initial Size : " + languages.size());

        // 2. Remove an existing element
        String removeTarget1 = "C++";
        System.out.println("\n--- 2. Removing Existing Element (\"" + removeTarget1 + "\") ---");
        boolean isRemoved1 = languages.remove(removeTarget1);
        System.out.println("remove(\"" + removeTarget1 + "\") returned: " + isRemoved1);
        System.out.println("Updated Elements : " + languages);
        System.out.println("Updated Size     : " + languages.size());

        // 3. Attempt to remove a non-existing element
        String removeTarget2 = "Ruby";
        System.out.println("\n--- 3. Removing Non-Existing Element (\"" + removeTarget2 + "\") ---");
        boolean isRemoved2 = languages.remove(removeTarget2);
        System.out.println("remove(\"" + removeTarget2 + "\") returned: " + isRemoved2);
        System.out.println("Size Unchanged   : " + languages.size());

        // 4. Bulk removal using removeAll()
        System.out.println("\n--- 4. Bulk Removal with removeAll() ---");
        HashSet<String> toRemove = new HashSet<>(Arrays.asList("JavaScript", "Kotlin"));
        System.out.println("Removing Set : " + toRemove);
        languages.removeAll(toRemove);
        System.out.println("Elements after removeAll: " + languages);
        System.out.println("Size after removeAll    : " + languages.size());

        // 5. Clear entire set
        System.out.println("\n--- 5. Clearing Entire HashSet ---");
        languages.clear();
        System.out.println("Elements after clear()  : " + languages);
        System.out.println("Final Size              : " + languages.size());
        System.out.println("Is HashSet empty?       : " + languages.isEmpty());

        System.out.println("\n=============================================================");
        System.out.println("Practical 265 executed successfully!");
        System.out.println("=============================================================");
    }
}
