package Day_35;

import java.util.HashMap;
import java.util.Map;

// ============================================================================
// Practical 259 / Day 35: Demonstrate Duplicate Key Behavior in HashMap
// Tasks:
// - Demonstrate that HashMap keys must be unique
// - Observe how inserting a duplicate key overwrites the existing value
// - Inspect the return value of put() during key collision/overwrite
// - Verify HashMap size before and after duplicate insertion
// ============================================================================

public class practical_259 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 259: Duplicate Key Behavior in HashMap ===");
        System.out.println("=============================================================\n");

        // 1. Create HashMap and insert initial entries
        HashMap<Integer, String> employeeMap = new HashMap<>();

        System.out.println("--- 1. Inserting Initial Key-Value Pairs ---");
        employeeMap.put(101, "Alice (Junior Developer)");
        employeeMap.put(102, "Bob (QA Engineer)");
        employeeMap.put(103, "Charlie (DevOps)");

        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("  Emp ID: " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("Initial Map Size: " + employeeMap.size());

        // 2. Inserting a duplicate key (101) with a new value
        System.out.println("\n--- 2. Inserting Duplicate Key 101 with New Value ---");
        System.out.println("Action: employeeMap.put(101, \"Alice (Senior Developer)\")");
        
        // put() returns the PREVIOUS value associated with the key (or null if brand new)
        String previousValue = employeeMap.put(101, "Alice (Senior Developer)");
        System.out.println("Returned by put() [Previous Value]: " + previousValue);
        System.out.println("Current Value for Key 101       : " + employeeMap.get(101));

        // 3. Verify Size did NOT increase
        System.out.println("\n--- 3. Verifying Map Size ---");
        System.out.println("Map Size after duplicate insertion: " + employeeMap.size() + " (Remained 3!)");

        // 4. Multiple duplicate key updates
        System.out.println("\n--- 4. Overwriting Key 102 Multiple Times ---");
        System.out.println("Overwriting 102 with 'Bob (Lead QA)' -> Previous: " + employeeMap.put(102, "Bob (Lead QA)"));
        System.out.println("Overwriting 102 with 'Bob (QA Manager)' -> Previous: " + employeeMap.put(102, "Bob (QA Manager)"));

        // 5. Final Map State
        System.out.println("\n--- 5. Final HashMap Entries ---");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("  Emp ID: " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n--- Key Takeaways ---");
        System.out.println("1. HashMap does NOT allow duplicate keys.");
        System.out.println("2. Adding an existing key replaces the old value with the new value.");
        System.out.println("3. The size of the HashMap remains unchanged when updating existing keys.");
        System.out.println("4. put() returns the replaced value (or null if the key was newly added).");

        System.out.println("\n=============================================================");
        System.out.println("Practical 259 executed successfully!");
        System.out.println("=============================================================");
    }
}
