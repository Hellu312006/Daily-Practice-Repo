package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 240 / Day 34: Update an element in ArrayList using set()
// ============================================================================

public class practical_240 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 240: Update Element Using set() ===");
        System.out.println("=============================================================\n");

        // 1. Create and populate an ArrayList
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println("Original ArrayList: " + colors);

        // 2. Update an element using set(index, newElement)
        // set() replaces element at index and returns the old value
        int targetIndex = 1;
        String newColor = "Emerald Green";
        String oldColor = colors.set(targetIndex, newColor);

        System.out.println("\nUpdating index " + targetIndex + ":");
        System.out.println("  Old value replaced : " + oldColor);
        System.out.println("  New value set      : " + newColor);
        System.out.println("\nUpdated ArrayList : " + colors);

        // 3. Another update example (updating last element)
        System.out.println("\nUpdating last element at index " + (colors.size() - 1) + ":");
        String oldLast = colors.set(colors.size() - 1, "Violet");
        System.out.println("  Old value replaced : " + oldLast);
        System.out.println("  New value set      : " + colors.get(colors.size() - 1));
        System.out.println("Final ArrayList   : " + colors);

        System.out.println("\n=============================================================");
        System.out.println("Practical 240 executed successfully!");
        System.out.println("=============================================================");
    }
}
