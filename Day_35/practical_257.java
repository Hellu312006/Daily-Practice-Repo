package Day_35;

import java.util.HashMap;

// ============================================================================
// Practical 257 / Day 35: Find and Track HashMap Size using size() & isEmpty()
// Tasks:
// - Check size of an initially empty HashMap
// - Add elements and monitor dynamic size increase
// - Demonstrate that duplicate keys update value without increasing size
// - Remove elements and clear map to monitor size reduction
// ============================================================================

public class practical_257 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 257: Find HashMap Size (size() & isEmpty()) ===");
        System.out.println("=============================================================\n");

        // 1. Initially Empty HashMap
        HashMap<Integer, String> studentMap = new HashMap<>();
        System.out.println("--- 1. Initial State ---");
        System.out.println("Is HashMap empty? : " + studentMap.isEmpty());
        System.out.println("Initial Size      : " + studentMap.size());

        // 2. Add 5 Students and observe size
        System.out.println("\n--- 2. Adding 5 Students ---");
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        studentMap.put(104, "Diana");
        studentMap.put(105, "Ethan");

        System.out.println("Current Map       : " + studentMap);
        System.out.println("Is HashMap empty? : " + studentMap.isEmpty());
        System.out.println("Current Size      : " + studentMap.size());

        // 3. Updating an existing key (Size does NOT increase)
        System.out.println("\n--- 3. Updating Existing Key (Roll No 103) ---");
        studentMap.put(103, "Charles"); // Updates value from "Charlie" to "Charles"
        System.out.println("Updated Map       : " + studentMap);
        System.out.println("Size after update : " + studentMap.size() + " (Unchanged because key already existed)");

        // 4. Removing elements and observing size reduction
        System.out.println("\n--- 4. Removing a Key (Roll No 102) ---");
        studentMap.remove(102);
        System.out.println("Map after removal : " + studentMap);
        System.out.println("Size after removal: " + studentMap.size());

        // 5. Clearing the HashMap
        System.out.println("\n--- 5. Clearing All Entries ---");
        studentMap.clear();
        System.out.println("Map after clear() : " + studentMap);
        System.out.println("Final Size        : " + studentMap.size());
        System.out.println("Is HashMap empty? : " + studentMap.isEmpty());

        System.out.println("\n=============================================================");
        System.out.println("Practical 257 executed successfully!");
        System.out.println("=============================================================");
    }
}
