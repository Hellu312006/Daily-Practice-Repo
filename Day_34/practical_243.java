package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 243 / Day 34: Check If an Element Exists Using contains()
// Tasks:
// - Check for existing and non-existing elements
// - Demonstrate case sensitivity with contains()
// ============================================================================

public class practical_243 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 243: Check Element Using contains() ===");
        System.out.println("=============================================================\n");

        // 1. Initialize ArrayList
        ArrayList<String> studentNames = new ArrayList<>();
        studentNames.add("Aarav");
        studentNames.add("Diya");
        studentNames.add("Rohan");
        studentNames.add("Sneha");
        studentNames.add("Vikram");

        System.out.println("Student List: " + studentNames);
        System.out.println("Total count : " + studentNames.size());

        // 2. Check for existing elements
        String searchTarget1 = "Rohan";
        boolean exists1 = studentNames.contains(searchTarget1);
        System.out.println("\nDoes list contain \"" + searchTarget1 + "\"? " + exists1);

        // 3. Check for non-existing elements
        String searchTarget2 = "Ananya";
        boolean exists2 = studentNames.contains(searchTarget2);
        System.out.println("Does list contain \"" + searchTarget2 + "\"? " + exists2);

        // 4. Checking case sensitivity
        String searchTarget3 = "rohan"; // lowercase
        boolean exists3 = studentNames.contains(searchTarget3);
        System.out.println("Does list contain \"" + searchTarget3 + "\" (case sensitive)? " + exists3);

        // 5. Conditional logic based on contains()
        System.out.println("\n--- Search Verification ---");
        String[] queries = { "Diya", "Karan", "Sneha", "Rahul" };
        for (String q : queries) {
            if (studentNames.contains(q)) {
                System.out.println("  [FOUND]     : \"" + q + "\" is enrolled at index " + studentNames.indexOf(q));
            } else {
                System.out.println("  [NOT FOUND] : \"" + q + "\" is not enrolled.");
            }
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 243 executed successfully!");
        System.out.println("=============================================================");
    }
}
