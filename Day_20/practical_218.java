package Day_20;

import java.util.ArrayList;
import java.util.Collections;

// Q13: Find maximum and minimum element in an ArrayList
public class practical_218 {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(78);
        marks.add(95);
        marks.add(42);
        marks.add(88);
        marks.add(99);
        marks.add(60);

        System.out.println("Marks List: " + marks);

        // Method 1: Using Collections.max() and Collections.min()
        int max = Collections.max(marks);
        int min = Collections.min(marks);

        System.out.println("\n--- Using Collections Utility ---");
        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);

        // Method 2: Manual approach using loop
        int maxManual = marks.get(0);
        int minManual = marks.get(0);

        for (int num : marks) {
            if (num > maxManual) {
                maxManual = num;
            }
            if (num < minManual) {
                minManual = num;
            }
        }

        System.out.println("\n--- Using For-Each Loop ---");
        System.out.println("Maximum Value: " + maxManual);
        System.out.println("Minimum Value: " + minManual);
    }
}
