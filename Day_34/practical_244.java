package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 244 / Day 34: Check If ArrayList Is Empty Using isEmpty()
// Tasks:
// - Check isEmpty() on empty and populated lists
// - Use clear() to empty the list and verify with isEmpty()
// ============================================================================

public class practical_244 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 244: Check Empty Status Using isEmpty() ===");
        System.out.println("=============================================================\n");

        // 1. Check an initially empty ArrayList
        ArrayList<Integer> scores = new ArrayList<>();
        System.out.println("1. Initial ArrayList : " + scores);
        System.out.println("   Is list empty?    : " + scores.isEmpty());
        System.out.println("   Size of list      : " + scores.size());

        // 2. Add elements and check isEmpty()
        scores.add(85);
        scores.add(92);
        scores.add(78);

        System.out.println("\n2. ArrayList after adding 3 items: " + scores);
        System.out.println("   Is list empty?    : " + scores.isEmpty());
        System.out.println("   Size of list      : " + scores.size());

        // 3. Clear all elements from ArrayList using clear()
        System.out.println("\n3. Clearing all elements using scores.clear()...");
        scores.clear();

        System.out.println("   ArrayList after clear() : " + scores);
        System.out.println("   Is list empty now?      : " + scores.isEmpty());
        System.out.println("   Size of list            : " + scores.size());

        // 4. Using isEmpty() in conditional check
        System.out.println("\n4. Conditional check demo:");
        if (scores.isEmpty()) {
            System.out.println("   Notice: No scores found. Please add scores to process.");
        } else {
            System.out.println("   Processing scores...");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 244 executed successfully!");
        System.out.println("=============================================================");
    }
}
