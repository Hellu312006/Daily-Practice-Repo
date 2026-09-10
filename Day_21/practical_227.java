package Day_21;

import java.util.ArrayList;
import java.util.Collections;

// Q7: ArrayList Data Manipulation using Collections Utility (Sort, Reverse, Min, Max)
public class practical_227 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(85);
        scores.add(42);
        scores.add(98);
        scores.add(73);
        scores.add(61);
        scores.add(98);

        System.out.println("=== Original Scores List ===");
        System.out.println(scores);

        // 1. Min & Max elements
        int minScore = Collections.min(scores);
        int maxScore = Collections.max(scores);
        System.out.println("\nMinimum Score: " + minScore);
        System.out.println("Maximum Score: " + maxScore);

        // 2. Frequency of an element
        int frequencyOf98 = Collections.frequency(scores, 98);
        System.out.println("Frequency of score 98: " + frequencyOf98);

        // 3. Sorting in Ascending Order
        Collections.sort(scores);
        System.out.println("\nSorted List (Ascending): " + scores);

        // 4. Sorting in Descending Order
        Collections.sort(scores, Collections.reverseOrder());
        System.out.println("Sorted List (Descending): " + scores);

        // 5. Reversing the List
        Collections.reverse(scores);
        System.out.println("Reversed List: " + scores);
    }
}
