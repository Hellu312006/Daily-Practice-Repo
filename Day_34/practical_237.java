package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 237 / Day 34: Create an ArrayList of 5 names and print them
// ============================================================================

public class practical_237 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 237: ArrayList of 5 Names ===");
        System.out.println("=============================================================\n");

        // 1. Create an ArrayList of String type
        ArrayList<String> names = new ArrayList<>();

        // 2. Add 5 names
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");
        names.add("Ethan");

        // 3. Print complete ArrayList
        System.out.println("Complete ArrayList: " + names);
        System.out.println("Total Names Count : " + names.size());

        // 4. Print names individually using a loop
        System.out.println("\nPrinting names one by one:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + names.get(i));
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 237 executed successfully!");
        System.out.println("=============================================================");
    }
}
