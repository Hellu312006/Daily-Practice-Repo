package Day_20;

import java.util.ArrayList;
import java.util.Collections;

// Q11: Sort numbers in ascending order
public class practical_216 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(45);
        numbers.add(12);
        numbers.add(89);
        numbers.add(23);
        numbers.add(67);
        numbers.add(5);

        System.out.println("Before Sorting: " + numbers);

        // Sorting in ascending order using Collections.sort()
        Collections.sort(numbers);

        System.out.println("After Sorting (Ascending): " + numbers);
    }
}
