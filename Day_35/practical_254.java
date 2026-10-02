package Day_35;

import java.util.HashMap;

// ============================================================================
// Practical 254 / Day 35: Modern Java HashMap Methods (Type 3: Name -> Marks)
// Tasks:
// - Create HashMap<String, Integer> and add 5 students using put & putIfAbsent
// - Retrieve / Get student marks using get() and getOrDefault()
// - Remove a student key using standard remove() & conditional remove(key, value)
// - Iterate using Java 8+ lambda forEach
// ============================================================================

public class practical_254 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 254: HashMap Type 3 (Modern Java 8+ Methods) ===");
        System.out.println("=============================================================");

        // 1. Create HashMap and add 5 students
        HashMap<String, Integer> studentMarks = new HashMap<>();
        studentMarks.put("John", 88);
        studentMarks.put("Sarah", 95);
        studentMarks.put("Michael", 72);
        studentMarks.put("Emily", 91);
        // putIfAbsent: only adds if key does not exist yet
        studentMarks.putIfAbsent("Daniel", 84);
        studentMarks.putIfAbsent("Sarah", 100); // Will NOT overwrite Sarah's 95

        System.out.println("\n--- 1. Added 5 Students (using put & putIfAbsent) ---");
        studentMarks.forEach((name, marks) -> System.out.printf("  Student: %-10s | Marks: %d\n", name, marks));

        // 2. Get value using key (get and getOrDefault)
        System.out.println("\n--- 2. Get Value using Key ---");
        String existingStudent = "Sarah";
        System.out.println("Marks of [" + existingStudent + "] : " + studentMarks.get(existingStudent));

        String nonExistingStudent = "Lucas";
        // getOrDefault returns a fallback default value (0) instead of null
        int defaultMarks = studentMarks.getOrDefault(nonExistingStudent, 0);
        System.out.println("Marks of [" + nonExistingStudent + "] (using getOrDefault) : " + defaultMarks);

        // 3. Remove a key
        System.out.println("\n--- 3. Remove Key Operations ---");
        // Standard remove by key
        String removeKey = "Michael";
        Integer removedScore = studentMarks.remove(removeKey);
        System.out.println("Removed key '" + removeKey + "' with marks: " + removedScore);

        // Conditional remove (only removes if key is mapped to exact specified value)
        boolean removedWrongVal = studentMarks.remove("Daniel", 50); // fails: marks is 84
        System.out.println("Attempt conditional remove('Daniel', 50): " + (removedWrongVal ? "Success" : "Failed (Value mismatched)"));

        boolean removedCorrectVal = studentMarks.remove("Daniel", 84); // succeeds
        System.out.println("Attempt conditional remove('Daniel', 84): " + (removedCorrectVal ? "Success (Removed)" : "Failed"));

        // 4. Remaining students in Map
        System.out.println("\n--- 4. Final Students in Map ---");
        studentMarks.forEach((name, marks) -> System.out.printf("  Student: %-10s | Marks: %d\n", name, marks));
        System.out.println("Total Count Remaining: " + studentMarks.size());

        System.out.println("\n=============================================================");
        System.out.println("Practical 254 executed successfully!");
        System.out.println("=============================================================");
    }
}
