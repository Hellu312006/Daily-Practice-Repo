package Day_11;

class Student {
    private String name;
    private int rollNo;
    private double grade;

    
    public Student() {
        this.name = "Unknown";
        this.rollNo = 0;
        this.grade = 0.0;
        System.out.println("Default constructor called.");
    }

    
    public Student(String name, int rollNo, double grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
        System.out.println("Parameterized constructor called for: " + name);
    }

    
    public Student(Student other) {
        this.name = other.name;
        this.rollNo = other.rollNo;
        this.grade = other.grade;
        System.out.println("Copy constructor called. Copied details of: " + other.name);
    }

    
    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number:  " + rollNo);
        System.out.println("Grade:        " + grade);
        System.out.println("----------------------------------------");
    }
}

public class practical_111 {
    public static void main(String[] args) {
        System.out.println("=== Constructor Student Details Demo ===");
        System.out.println();

    
        Student student1 = new Student();
        student1.displayDetails();

        
        Student student2 = new Student("Aarav Sharma", 42, 9.2);
        student2.displayDetails();

        
        Student student3 = new Student(student2);
        student3.displayDetails();
    }
}
 