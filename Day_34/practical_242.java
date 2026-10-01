package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 242 / Day 34: Find the Size of an ArrayList Using size()
// Tasks:
// - Check size of an initially empty ArrayList
// - Track size dynamically as elements are added and removed
// ============================================================================

public class practical_242 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 242: Find ArrayList Size Using size() ===");
        System.out.println("=============================================================\n");

        // 1. Create an empty ArrayList
        ArrayList<String> cities = new ArrayList<>();
        System.out.println("Initial empty list : " + cities);
        System.out.println("Initial size()     : " + cities.size());

        // 2. Add elements dynamically and inspect size
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bangalore");
        cities.add("Hyderabad");
        cities.add("Pune");

        System.out.println("\nList after additions : " + cities);
        System.out.println("Current size()       : " + cities.size());

        // 3. Remove an element and verify size updates
        cities.remove(1); // Removes Delhi
        System.out.println("\nList after removing index 1 : " + cities);
        System.out.println("Updated size()              : " + cities.size());

        // 4. Using size() in loops for iteration
        System.out.println("\nIterating using size() condition:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println("  City [" + i + "] = " + cities.get(i));
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 242 executed successfully!");
        System.out.println("=============================================================");
    }
}
