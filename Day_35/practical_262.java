package Day_35;

import java.util.HashSet;
import java.util.Iterator;

// ============================================================================
// Practical 262 / Day 35: Create HashSet and Add Numbers
// Tasks:
// - Initialize a HashSet<Integer>
// - Add numbers using add() method
// - Demonstrate unordered nature of HashSet
// - Traverse HashSet using enhanced for-loop and Iterator
// - Check size and verify emptiness
// ============================================================================

public class practical_262 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 262: Create HashSet & Add Numbers ===");
        System.out.println("=============================================================\n");

        // 1. Create a HashSet of Integers
        HashSet<Integer> numbers = new HashSet<>();
        System.out.println("--- 1. Initial State ---");
        System.out.println("Is HashSet empty? : " + numbers.isEmpty());
        System.out.println("Initial Size      : " + numbers.size());

        // 2. Add numbers to HashSet
        System.out.println("\n--- 2. Adding Numbers to HashSet ---");
        numbers.add(45);
        numbers.add(12);
        numbers.add(89);
        numbers.add(23);
        numbers.add(67);
        numbers.add(90);
        numbers.add(34);

        System.out.println("HashSet Elements: " + numbers);
        System.out.println("Total Count     : " + numbers.size());
        System.out.println("(Note: HashSet does not maintain insertion order; elements are stored based on hash codes.)");

        // 3. Traverse using Enhanced For-Loop
        System.out.println("\n--- 3. Traversing using Enhanced For-Loop ---");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 4. Traverse using Iterator
        System.out.println("\n--- 4. Traversing using Iterator ---");
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " -> ");
        }
        System.out.println("END");

        System.out.println("\n=============================================================");
        System.out.println("Practical 262 executed successfully!");
        System.out.println("=============================================================");
    }
}
