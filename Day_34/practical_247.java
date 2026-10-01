package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 247 / Day 34: Print ArrayList Using Enhanced For Loop (For-Each)
// Tasks:
// - Iterate and print String ArrayList using enhanced for loop
// - Iterate and process Integer ArrayList using enhanced for loop
// - Compute summary statistics (sum, average, max) using enhanced loop
// ============================================================================

public class practical_247 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 247: Print ArrayList Using Enhanced For Loop ===");
        System.out.println("=============================================================\n");

        // 1. Enhanced for loop with String ArrayList
        System.out.println("--- 1. Enhanced For Loop with Strings ---");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Strawberry");

        System.out.println("Fruits List: " + fruits);
        System.out.println("\nPrinting fruits using enhanced for loop:");
        for (String fruit : fruits) {
            System.out.println("  * " + fruit);
        }

        // 2. Enhanced for loop with Integer ArrayList
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- 2. Enhanced For Loop with Integers & Aggregations ---");
        System.out.println("-------------------------------------------------------------");
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(88);
        marks.add(95);
        marks.add(72);
        marks.add(81);
        marks.add(90);

        System.out.println("Marks List: " + marks);

        int total = 0;
        int maxMark = Integer.MIN_VALUE;

        System.out.print("\nTraversing marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
            total += mark;
            if (mark > maxMark) {
                maxMark = mark;
            }
        }
        System.out.println();

        double average = (double) total / marks.size();
        System.out.println("\nCalculated Stats via Enhanced Loop:");
        System.out.println("  Total Marks   : " + total);
        System.out.printf("  Average Marks : %.2f\n", average);
        System.out.println("  Highest Mark  : " + maxMark);

        System.out.println("\n=============================================================");
        System.out.println("Practical 247 executed successfully!");
        System.out.println("=============================================================");
    }
}
