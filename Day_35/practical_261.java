package Day_35;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// ============================================================================
// Practical 261 / Day 35: Student Roll Number -> Name Management System
// Tasks:
// - Implement a complete Student Management System using HashMap
// - 1. Add / Enroll Student (Validate duplicate Roll Numbers)
// - 2. Search / Get Student Name by Roll Number
// - 3. Update Existing Student Name
// - 4. Delete / Remove Student by Roll Number
// - 5. Display All Students in Sorted Order (using TreeMap)
// - 6. Generate Summary Statistics
// ============================================================================

public class practical_261 {

    // Student Registry using HashMap
    private static HashMap<Integer, String> studentRegistry = new HashMap<>();

    // 1. Add Student
    public static boolean enrollStudent(int rollNo, String name) {
        if (studentRegistry.containsKey(rollNo)) {
            System.out.println("  [Error] Roll Number " + rollNo + " is already enrolled (" + studentRegistry.get(rollNo) + ").");
            return false;
        }
        studentRegistry.put(rollNo, name);
        System.out.println("  [Success] Enrolled: Roll No " + rollNo + " -> " + name);
        return true;
    }

    // 2. Search Student
    public static void searchStudent(int rollNo) {
        System.out.println("Searching for Roll No [" + rollNo + "]...");
        if (studentRegistry.containsKey(rollNo)) {
            System.out.println("  ✓ Student Found: " + studentRegistry.get(rollNo));
        } else {
            System.out.println("  ✗ No student registered with Roll No " + rollNo);
        }
    }

    // 3. Update Student Name
    public static boolean updateStudent(int rollNo, String newName) {
        if (!studentRegistry.containsKey(rollNo)) {
            System.out.println("  [Error] Cannot update. Roll No " + rollNo + " does not exist.");
            return false;
        }
        String oldName = studentRegistry.replace(rollNo, newName);
        System.out.println("  [Success] Updated Roll No " + rollNo + ": '" + oldName + "' -> '" + newName + "'");
        return true;
    }

    // 4. Delete Student
    public static boolean removeStudent(int rollNo) {
        if (!studentRegistry.containsKey(rollNo)) {
            System.out.println("  [Error] Cannot delete. Roll No " + rollNo + " not found.");
            return false;
        }
        String removedName = studentRegistry.remove(rollNo);
        System.out.println("  [Success] Removed: Roll No " + rollNo + " (" + removedName + ")");
        return true;
    }

    // 5. Display All Students (Sorted by Roll Number)
    public static void displayAllStudents() {
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-10s | %-25s\n", "Roll No", "Student Name");
        System.out.println("-------------------------------------------------------------");

        if (studentRegistry.isEmpty()) {
            System.out.println("  No students currently enrolled.");
        } else {
            // Use TreeMap to display in sorted order of Roll Numbers
            TreeMap<Integer, String> sortedMap = new TreeMap<>(studentRegistry);
            for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
                System.out.printf("%-10d | %-25s\n", entry.getKey(), entry.getValue());
            }
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Total Enrolled Students: " + studentRegistry.size());
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 261: Student Roll Number -> Name System ===");
        System.out.println("=============================================================\n");

        // Step 1: Enroll 5 Initial Students
        System.out.println("--- 1. Enrolling Students ---");
        enrollStudent(104, "David Miller");
        enrollStudent(101, "Alice Johnson");
        enrollStudent(105, "Emma Watson");
        enrollStudent(102, "Bob Smith");
        enrollStudent(103, "Charlie Brown");

        // Attempt duplicate enrollment
        System.out.println("\n--- Testing Duplicate Roll Number Validation ---");
        enrollStudent(101, "Alice Cooper"); // Should fail

        // Step 2: Display All Enrolled Students
        displayAllStudents();

        // Step 3: Search by Roll Number
        System.out.println("\n--- 2. Student Search ---");
        searchStudent(103);
        searchStudent(199); // Non-existent

        // Step 4: Update Student Name
        System.out.println("\n--- 3. Update Student Record ---");
        updateStudent(102, "Robert Smith");
        updateStudent(999, "Unknown"); // Failed update

        // Step 5: Delete a Student
        System.out.println("\n--- 4. Delete Student Record ---");
        removeStudent(104);

        // Step 6: Final Registry Display
        System.out.println("\n--- 5. Final Student Registry ---");
        displayAllStudents();

        System.out.println("\n=============================================================");
        System.out.println("Practical 261 executed successfully!");
        System.out.println("=============================================================");
    }
}
