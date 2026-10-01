package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 239 / Day 34: Access an element from ArrayList using get()
// ============================================================================

public class practical_239 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 239: Access Element Using get() ===");
        System.out.println("=============================================================\n");

        // 1. Create and populate an ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("ArrayList of Fruits: " + fruits);
        System.out.println("Total elements     : " + fruits.size());
        System.out.println();

        // 2. Access elements at various indices using get(index)
        String firstElement = fruits.get(0);
        String middleElement = fruits.get(2);
        String lastElement = fruits.get(fruits.size() - 1);

        System.out.println("Element at index 0 (First) : " + firstElement);
        System.out.println("Element at index 2 (Middle): " + middleElement);
        System.out.println("Element at index 4 (Last)  : " + lastElement);

        // 3. Accessing elements using a loop with get(index)
        System.out.println("\nAccessing all elements with get(index) in a loop:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("  Index " + i + " -> " + fruits.get(i));
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 239 executed successfully!");
        System.out.println("=============================================================");
    }
}
