package Day_27;

import java.util.ArrayList;

// ============================================================================
// Practical 280: Print ArrayList using a normal for loop
// ============================================================================

public class practical_280 {
    public static void main(String[] args) {
        System.out.println("=== Practical 280: Print ArrayList using Normal for Loop ===\n");

        // 1. Create an ArrayList of Strings (fruits)
        ArrayList<String> fruits = new ArrayList<>();

        // 2. Add elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Grapes");

        System.out.println("Printing elements with index:");
        // 3. Iterate through ArrayList using normal for loop and get() method
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("Index " + i + " -> " + fruits.get(i));
        }

        // Example with Integer ArrayList
        System.out.println("\nPrinting Integer ArrayList:");
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(95);
        scores.add(88);
        scores.add(76);
        scores.add(92);
        scores.add(85);

        for (int i = 0; i < scores.size(); i++) {
            System.out.print(scores.get(i) + " ");
        }
        System.out.println();
    }
}
