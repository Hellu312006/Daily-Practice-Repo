package Day_35;

import java.util.HashMap;
import java.util.Map;

// ============================================================================
// Practical 255 / Day 35: Check If Key Exists using containsKey()
// Tasks:
// - Create and populate a HashMap with student records
// - Check existence of specific keys using containsKey()
// - Use containsKey() for safe retrieval and conditional insertion
// ============================================================================

public class practical_255 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 255: HashMap containsKey() Method ===");
        System.out.println("=============================================================\n");

        // 1. Create HashMap and populate with student roll numbers and names
        HashMap<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        studentMap.put(104, "Diana");
        studentMap.put(105, "Ethan");

        System.out.println("--- Current Student Map ---");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.printf("  Roll No: %d -> Name: %s\n", entry.getKey(), entry.getValue());
        }

        // 2. Check for an existing key
        int searchKey1 = 103;
        System.out.println("\n--- Checking for Existing Key (" + searchKey1 + ") ---");
        if (studentMap.containsKey(searchKey1)) {
            System.out.println("✓ Key " + searchKey1 + " exists in the map!");
            System.out.println("  Student Name: " + studentMap.get(searchKey1));
        } else {
            System.out.println("✗ Key " + searchKey1 + " does NOT exist in the map.");
        }

        // 3. Check for a non-existing key
        int searchKey2 = 199;
        System.out.println("\n--- Checking for Non-Existing Key (" + searchKey2 + ") ---");
        if (studentMap.containsKey(searchKey2)) {
            System.out.println("✓ Key " + searchKey2 + " exists in the map!");
        } else {
            System.out.println("✗ Key " + searchKey2 + " does NOT exist in the map.");
        }

        // 4. Practical Use Case: Safe conditional insertion
        int newKey = 102;
        String newName = "Bobby";
        System.out.println("\n--- Safe Insertion Check ---");
        if (!studentMap.containsKey(newKey)) {
            studentMap.put(newKey, newName);
            System.out.println("Inserted: " + newKey + " -> " + newName);
        } else {
            System.out.println("Key " + newKey + " already exists (Value: " + studentMap.get(newKey) + "). Insertion skipped to prevent overwrite.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 255 executed successfully!");
        System.out.println("=============================================================");
    }
}
