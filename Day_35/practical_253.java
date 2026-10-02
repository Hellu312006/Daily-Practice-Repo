package Day_35;

import java.util.HashMap;
import java.util.Map;

// ============================================================================
// Practical 253 / Day 35: HashMap with Custom Objects (Type 2: ID -> Student Object)
// Tasks:
// - Define a Student model class (id, name, course, marks)
// - Create HashMap<Integer, Student> and store 5 student objects
// - Retrieve / Get a student object using Student ID (key)
// - Remove a student object using Student ID (key)
// ============================================================================

public class practical_253 {

    // Student model class
    static class Student {
        private int id;
        private String name;
        private String course;
        private double marks;

        public Student(int id, String name, String course, double marks) {
            this.id = id;
            this.name = name;
            this.course = course;
            this.marks = marks;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getCourse() { return course; }
        public double getMarks() { return marks; }

        @Override
        public String toString() {
            return String.format("Student[ID=%d, Name='%s', Course='%s', Marks=%.1f]", id, name, course, marks);
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 253: HashMap Type 2 (ID -> Student Object) ===");
        System.out.println("=============================================================\n");

        // 1. Create HashMap and add 5 Student objects
        HashMap<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student(1, "Sophia Williams", "Computer Science", 92.5));
        studentMap.put(2, new Student(2, "Liam Martinez", "Information Technology", 85.0));
        studentMap.put(3, new Student(3, "Olivia Davis", "Data Science", 96.0));
        studentMap.put(4, new Student(4, "Noah Taylor", "Software Engineering", 78.5));
        studentMap.put(5, new Student(5, "Ava Anderson", "Cyber Security", 89.0));

        System.out.println("--- 1. Stored 5 Student Objects in HashMap ---");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println("  Key [" + entry.getKey() + "] -> " + entry.getValue());
        }

        // 2. Get value using key
        int searchId = 3;
        System.out.println("\n--- 2. Get Student Object by Key ---");
        Student foundStudent = studentMap.get(searchId);
        if (foundStudent != null) {
            System.out.println("Retrieved Student Details:");
            System.out.println("  ID     : " + foundStudent.getId());
            System.out.println("  Name   : " + foundStudent.getName());
            System.out.println("  Course : " + foundStudent.getCourse());
            System.out.println("  Marks  : " + foundStudent.getMarks());
        } else {
            System.out.println("Student with ID [" + searchId + "] not found.");
        }

        // 3. Remove a key
        int removeId = 4;
        System.out.println("\n--- 3. Remove a Student by Key ---");
        Student removedStudent = studentMap.remove(removeId);
        System.out.println("Removed Student: " + removedStudent);

        // 4. Remaining students list
        System.out.println("\n--- 4. Remaining Students in Map ---");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println("  Key [" + entry.getKey() + "] -> " + entry.getValue().getName() + " (" + entry.getValue().getCourse() + ")");
        }
        System.out.println("Total Count Remaining: " + studentMap.size());

        System.out.println("\n=============================================================");
        System.out.println("Practical 253 executed successfully!");
        System.out.println("=============================================================");
    }
}
