package Day_08;

import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    String course;
    double gpa;


    public Student() {
        this.rollNumber = 0;
        this.name = "Not Enrolled";
        this.course = "General";
        this.gpa = 0.0;
        System.out.println("Default Constructor invoked. Student not enrolled yet.");
    }

    
    public Student(int rollNumber, String name, String course, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
        System.out.println("Parameterized Constructor invoked for Student: " + name);
    }

    
    public void displayDetails() {
        System.out.println("Roll Number:  " + rollNumber);
        System.out.println("Student Name: " + name);
        System.out.println("Course:       " + course);
        System.out.println("GPA:          " + gpa);
        System.out.println("----------------------------------------");
    }
}

public class practical_803 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Entering Student Details (Parameterized) ===");
        
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();

        
        Student student = new Student(rollNumber, name, course, gpa);
        
        System.out.println("\n--- Displaying Student Details ---");
        student.displayDetails();

        scanner.close();
    }
}
