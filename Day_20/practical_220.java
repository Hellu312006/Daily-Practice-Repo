package Day_20;

import java.util.ArrayList;

// Student class to hold name and marks
class Student {
    private String name;
    private int marks;

    // Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name + " | Marks: " + marks);
    }
}

// Q15: Create a Student ArrayList using a Student class and display student names and marks
public class practical_220 {
    public static void main(String[] args) {
        // Creating an ArrayList of custom Student objects
        ArrayList<Student> studentList = new ArrayList<>();

        // Adding Student objects to the ArrayList
        studentList.add(new Student("Rahul Sharma", 88));
        studentList.add(new Student("Priya Verma", 95));
        studentList.add(new Student("Aman Gupta", 74));
        studentList.add(new Student("Sneha Patel", 91));
        studentList.add(new Student("Kunal Singh", 82));

        System.out.println("=== Student Records in ArrayList ===");
        for (Student s : studentList) {
            s.display();
        }

        System.out.println("\n=== Detailed Display (Name & Marks) ===");
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.println((i + 1) + ". Student Name: " + s.getName() + " -> Marks: " + s.getMarks());
        }
    }
}
