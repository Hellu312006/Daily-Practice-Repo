package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 245 / Day 34: Clear All Elements in ArrayList Using clear()
// Tasks:
// - Populate an ArrayList with elements
// - Clear all elements using clear() method
// - Verify ArrayList state before and after clear() (size and isEmpty)
// ============================================================================

public class practical_245 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 245: Clear Elements Using clear() ===");
        System.out.println("=============================================================\n");

        // 1. Create and populate an ArrayList
        ArrayList<String> devices = new ArrayList<>();
        devices.add("Laptop");
        devices.add("Smartphone");
        devices.add("Tablet");
        devices.add("Smartwatch");
        devices.add("Headphones");

        System.out.println("--- Before clear() ---");
        System.out.println("ArrayList Elements : " + devices);
        System.out.println("Size of list       : " + devices.size());
        System.out.println("Is list empty?     : " + devices.isEmpty());

        // 2. Clear all elements
        System.out.println("\nExecuting devices.clear()...\n");
        devices.clear();

        // 3. Inspect list after clear
        System.out.println("--- After clear() ---");
        System.out.println("ArrayList Elements : " + devices);
        System.out.println("Size of list       : " + devices.size());
        System.out.println("Is list empty?     : " + devices.isEmpty());

        // 4. Adding elements again after clear
        System.out.println("\n--- Re-populating after clear() ---");
        devices.add("Gaming Console");
        devices.add("VR Headset");
        System.out.println("ArrayList Elements : " + devices);
        System.out.println("Size of list       : " + devices.size());

        System.out.println("\n=============================================================");
        System.out.println("Practical 245 executed successfully!");
        System.out.println("=============================================================");
    }
}
