package Day_35;

import java.util.HashMap;
import java.util.Map;

// ============================================================================
// Practical 252 / Day 35: HashMap Basics (Type 1: Roll No -> Student Name)
// Tasks:
// - Create HashMap<Integer, String> and add 5 students
// - Retrieve / Get student name using Roll Number (key)
// - Remove a student using Roll Number (key)
// - Display results and iterate through the map
// ============================================================================

public class practical_252 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 252: HashMap Type 1 (Roll No -> Name) ===");
        System.out.println("=============================================================\n");

        // 1. Create HashMap and add 5 students
        HashMap<Integer, String> students = new HashMap<>();
        students.put(101, "Alice Johnson");
        students.put(102, "Bob Smith");
        students.put(103, "Charlie Brown");
        students.put(104, "David Miller");
        students.put(105, "Emma Watson");

        System.out.println("--- 1. Added 5 Students to HashMap ---");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.printf("  Roll No: %d -> Name: %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println("Total Students Count: " + students.size());

        // 2. Get value using key
        int searchRollNo = 103;
        System.out.println("\n--- 2. Get Value using Key ---");
        if (students.containsKey(searchRollNo)) {
            String studentName = students.get(searchRollNo);
            System.out.println("Found Student with Roll No [" + searchRollNo + "]: " + studentName);
        } else {
            System.out.println("Roll No [" + searchRollNo + "] not found!");
        }

        // 3. Remove a key
        int removeRollNo = 102;
        System.out.println("\n--- 3. Remove a Key from HashMap ---");
        String removedStudent = students.remove(removeRollNo);
        System.out.println("Removed Student: " + removedStudent + " (Roll No: " + removeRollNo + ")");

        // 4. Display remaining students
        System.out.println("\n--- 4. Remaining Students after Removal ---");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.printf("  Roll No: %d -> Name: %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println("Updated Total Count: " + students.size());

        System.out.println("\n=============================================================");
        System.out.println("Practical 252 executed successfully!");
        System.out.println("=============================================================");
    }
}