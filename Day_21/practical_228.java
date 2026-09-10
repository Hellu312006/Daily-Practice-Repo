package Day_21;

import java.util.ArrayList;

// Custom Class for Real-World Object Storage
class StudentRecord {
    private int id;
    private String name;
    private double marks;

    public StudentRecord(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

// Q8: Custom Object ArrayList Management & Searching
public class practical_228 {
    public static void main(String[] args) {
        ArrayList<StudentRecord> students = new ArrayList<>();

        // Adding Custom Objects
        students.add(new StudentRecord(101, "Aarav Sharma", 89.5));
        students.add(new StudentRecord(102, "Priya Verma", 96.0));
        students.add(new StudentRecord(103, "Rohan Das", 74.5));
        students.add(new StudentRecord(104, "Sneha Patel", 91.0));

        System.out.println("=== All Student Records ===");
        for (StudentRecord s : students) {
            System.out.println(s);
        }

        // 1. Finding Topper (Highest Marks)
        StudentRecord topper = students.get(0);
        for (StudentRecord s : students) {
            if (s.getMarks() > topper.getMarks()) {
                topper = s;
            }
        }
        System.out.println("\n🏆 Class Topper: " + topper.getName() + " with " + topper.getMarks() + " marks");

        // 2. Searching student by ID
        int searchId = 102;
        System.out.println("\nSearching for Student with ID: " + searchId);
        boolean found = false;
        for (StudentRecord s : students) {
            if (s.getId() == searchId) {
                System.out.println("Found: " + s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }
}
