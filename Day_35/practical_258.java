package Day_35;

import java.util.HashMap;
import java.util.Map;

// ============================================================================
// Practical 258 / Day 35: Replace a Value in HashMap
// Tasks:
// - Create and populate a HashMap with student grades
// - Replace value using replace(key, newValue)
// - Replace value conditionally using replace(key, oldValue, newValue)
// - Observe behavior when key does not exist or oldValue does not match
// ============================================================================

public class practical_258 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 258: Replace Value in HashMap ===");
        System.out.println("=============================================================\n");

        // 1. Initial HashMap (Roll No -> Grade)
        HashMap<Integer, String> studentGrades = new HashMap<>();
        studentGrades.put(101, "B");
        studentGrades.put(102, "C");
        studentGrades.put(103, "A");
        studentGrades.put(104, "B");
        studentGrades.put(105, "D");

        System.out.println("--- 1. Initial Student Grades ---");
        for (Map.Entry<Integer, String> entry : studentGrades.entrySet()) {
            System.out.printf("  Roll No: %d -> Grade: %s\n", entry.getKey(), entry.getValue());
        }

        // 2. Unconditional replace: replace(K key, V value)
        int rollNo1 = 102;
        String newGrade1 = "A";
        System.out.println("\n--- 2. Unconditional Replace (Roll No: " + rollNo1 + " -> " + newGrade1 + ") ---");
        String oldGrade = studentGrades.replace(rollNo1, newGrade1);
        System.out.println("Previous Grade : " + oldGrade);
        System.out.println("Updated Grade  : " + studentGrades.get(rollNo1));

        // 3. Conditional replace: replace(K key, V oldValue, V newValue)
        int rollNo2 = 105;
        System.out.println("\n--- 3. Conditional Replace (Roll No: " + rollNo2 + ") ---");
        
        // Failed attempt: Old value is "D", but we specify "C"
        boolean isReplaced1 = studentGrades.replace(rollNo2, "C", "A");
        System.out.println("Attempt replace(105, 'C', 'A') with wrong old value : " + (isReplaced1 ? "Success" : "Failed (Value mismatched)"));

        // Successful attempt: Old value matches "D"
        boolean isReplaced2 = studentGrades.replace(rollNo2, "D", "B+");
        System.out.println("Attempt replace(105, 'D', 'B+') with correct old value : " + (isReplaced2 ? "Success (Updated)" : "Failed"));
        System.out.println("Current Grade for 105: " + studentGrades.get(rollNo2));

        // 4. Replacing a non-existent key
        int nonExistentRoll = 999;
        System.out.println("\n--- 4. Replacing Non-Existent Key (" + nonExistentRoll + ") ---");
        String result = studentGrades.replace(nonExistentRoll, "A+");
        System.out.println("Result for non-existent key: " + result + " (No changes made, key not added)");

        // 5. Display final HashMap
        System.out.println("\n--- 5. Final Updated Map ---");
        for (Map.Entry<Integer, String> entry : studentGrades.entrySet()) {
            System.out.printf("  Roll No: %d -> Grade: %s\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 258 executed successfully!");
        System.out.println("=============================================================");
    }
}
