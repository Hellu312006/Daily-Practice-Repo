package Day_35;

import java.util.HashMap;
import java.util.Map;

// ============================================================================
// Practical 256 / Day 35: Check If Value Exists using containsValue()
// Tasks:
// - Create and populate a HashMap with student details
// - Check existence of specific values using containsValue()
// - Search and find all keys associated with a matching value
// ============================================================================

public class practical_256 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 256: HashMap containsValue() Method ===");
        System.out.println("=============================================================\n");

        // 1. Create HashMap and populate with Roll No -> Course Name
        HashMap<Integer, String> studentCourses = new HashMap<>();
        studentCourses.put(101, "Java Fullstack");
        studentCourses.put(102, "Python Data Science");
        studentCourses.put(103, "Cloud Computing");
        studentCourses.put(104, "Java Fullstack");
        studentCourses.put(105, "Cyber Security");

        System.out.println("--- Current Student Course Enrollments ---");
        for (Map.Entry<Integer, String> entry : studentCourses.entrySet()) {
            System.out.printf("  Roll No: %d -> Enrolled in: %s\n", entry.getKey(), entry.getValue());
        }

        // 2. Check for an existing value
        String searchValue1 = "Cloud Computing";
        System.out.println("\n--- Checking for Existing Value (\"" + searchValue1 + "\") ---");
        if (studentCourses.containsValue(searchValue1)) {
            System.out.println("✓ Value \"" + searchValue1 + "\" is present in the map!");
        } else {
            System.out.println("✗ Value \"" + searchValue1 + "\" is NOT present in the map.");
        }

        // 3. Check for a non-existing value
        String searchValue2 = "Blockchain";
        System.out.println("\n--- Checking for Non-Existing Value (\"" + searchValue2 + "\") ---");
        if (studentCourses.containsValue(searchValue2)) {
            System.out.println("✓ Value \"" + searchValue2 + "\" is present in the map!");
        } else {
            System.out.println("✗ Value \"" + searchValue2 + "\" is NOT present in the map.");
        }

        // 4. Find all keys that map to a specific value
        String targetCourse = "Java Fullstack";
        System.out.println("\n--- Finding All Roll Numbers Enrolled in \"" + targetCourse + "\" ---");
        if (studentCourses.containsValue(targetCourse)) {
            System.out.println("Students enrolled in " + targetCourse + ":");
            for (Map.Entry<Integer, String> entry : studentCourses.entrySet()) {
                if (entry.getValue().equals(targetCourse)) {
                    System.out.println("  -> Roll No: " + entry.getKey());
                }
            }
        } else {
            System.out.println("No students found in course: " + targetCourse);
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 256 executed successfully!");
        System.out.println("=============================================================");
    }
}
