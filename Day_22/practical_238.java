package Day_22;

import java.util.ArrayList;
import java.util.LinkedHashSet;

// Q9: Remove duplicates from an ArrayList (Multiple Approaches)
public class practical_238 {
    public static void main(String[] args) {
        ArrayList<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("Java");
        programmingLanguages.add("C++");
        programmingLanguages.add("Python");
        programmingLanguages.add("JavaScript");
        programmingLanguages.add("Java");

        System.out.println("=== Original List with Duplicates ===");
        System.out.println(programmingLanguages);

        // Approach 1: Using LinkedHashSet (Fastest & Preserves Insertion Order)
        LinkedHashSet<String> set = new LinkedHashSet<>(programmingLanguages);
        ArrayList<String> uniqueList1 = new ArrayList<>(set);

        System.out.println("\n--- Approach 1: Using LinkedHashSet ---");
        System.out.println("Unique Elements: " + uniqueList1);

        // Approach 2: Manual approach without Sets (Using new ArrayList and contains())
        ArrayList<String> uniqueList2 = new ArrayList<>();
        for (String lang : programmingLanguages) {
            if (!uniqueList2.contains(lang)) {
                uniqueList2.add(lang);
            }
        }

        System.out.println("\n--- Approach 2: Manual Loop with contains() ---");
        System.out.println("Unique Elements: " + uniqueList2);
    }
}
