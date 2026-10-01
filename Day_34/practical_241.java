package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 241 / Day 34: Remove an Element from ArrayList Using remove()
// Tasks:
// - Remove an element by index: remove(int index)
// - Remove an element by value: remove(Object o)
// ============================================================================

public class practical_241 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 241: Remove Element Using remove() ===");
        System.out.println("=============================================================\n");

        // 1. Initialize ArrayList with sample elements
        ArrayList<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("C++");
        programmingLanguages.add("JavaScript");
        programmingLanguages.add("Ruby");

        System.out.println("Initial List : " + programmingLanguages);
        System.out.println("Total Count  : " + programmingLanguages.size());

        // 2. Remove by index: remove(int index)
        int indexToRemove = 2; // "C++"
        String removedByIndex = programmingLanguages.remove(indexToRemove);
        System.out.println("\n1. Removed by Index (" + indexToRemove + "): " + removedByIndex);
        System.out.println("   List after index removal: " + programmingLanguages);

        // 3. Remove by object/value: remove(Object o)
        String valueToRemove = "Ruby";
        boolean isRemoved = programmingLanguages.remove(valueToRemove);
        System.out.println("\n2. Removed by Value (\"" + valueToRemove + "\") -> Success? " + isRemoved);
        System.out.println("   List after value removal: " + programmingLanguages);

        // 4. Attempting to remove a non-existent element
        boolean failedRemoval = programmingLanguages.remove("Kotlin");
        System.out.println("\n3. Attempting to remove \"Kotlin\" (not in list) -> Success? " + failedRemoval);
        System.out.println("   Final List: " + programmingLanguages);

        System.out.println("\n=============================================================");
        System.out.println("Practical 241 executed successfully!");
        System.out.println("=============================================================");
    }
}
