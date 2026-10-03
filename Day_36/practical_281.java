package Day_36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ============================================================================
// Practical 281 / Day 36: Student Record System
// Flow:
//   Add Student  -->  Save in file  -->  Read Student  -->  Display Student
// ============================================================================

class Student {
    private String id;
    private String name;
    private String course;
    private double gpa;

    public Student(String id, String name, String course, double gpa) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    // Convert student object to comma-separated file format
    public String toFileFormat() {
        return id + "," + name + "," + course + "," + gpa;
    }

    // Static parser to construct a Student from a comma-separated line
    public static Student fromFileFormat(String line) {
        String[] tokens = line.split(",");
        if (tokens.length == 4) {
            try {
                return new Student(tokens[0].trim(), tokens[1].trim(), tokens[2].trim(), Double.parseDouble(tokens[3].trim()));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getGpa() { return gpa; }
}

public class practical_281 {
    private static final String DATABASE_FILE = "student_db.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeDatabaseIfEmpty();

        while (true) {
            System.out.println("\n=============================================================");
            System.out.println("=== Practical 281: Student Record Management System       ===");
            System.out.println("=============================================================");
            System.out.println("Flow: [Add Student] -> [Save to File] -> [Read] -> [Display]");
            System.out.println("-------------------------------------------------------------");
            System.out.println("1. Add Student & Save into File");
            System.out.println("2. Read All Students from File & Display");
            System.out.println("3. Read & Display Top Performing Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addAndSaveStudent(scanner);
                    break;
                case "2":
                    readAndDisplayStudents();
                    break;
                case "3":
                    displayTopStudent();
                    break;
                case "4":
                    System.out.println("\nExiting Student Record System. Have a great day!");
                    System.out.println("=============================================================");
                    scanner.close();
                    return;
                default:
                    System.out.println("[INVALID] Choice must be between 1 and 4.");
            }
        }
    }

    // Step 1: Add Student --> Save in file
    private static void addAndSaveStudent(Scanner scanner) {
        System.out.println("\n--- 1. Add Student Record ---");
        System.out.print("Enter Student ID (e.g., S101): ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter Student Name           : ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Course Name            : ");
        String course = scanner.nextLine().trim();

        System.out.print("Enter GPA (e.g., 3.8 / 9.2)  : ");
        String gpaStr = scanner.nextLine().trim();

        double gpa;
        try {
            gpa = Double.parseDouble(gpaStr);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Invalid GPA number format! Record not saved.");
            return;
        }

        Student student = new Student(id, name, course, gpa);

        // Save to File (Append mode)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATABASE_FILE, true))) {
            bw.write(student.toFileFormat());
            bw.newLine();
            System.out.println("[SAVED] Student successfully saved to file '" + DATABASE_FILE + "'!");
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to save student to file: " + e.getMessage());
        }
    }

    // Step 2: Read Students from File --> Display Students in Table
    private static void readAndDisplayStudents() {
        System.out.println("\n--- 2. Reading from File & Displaying Records ---");
        List<Student> studentList = loadStudentsFromFile();

        if (studentList.isEmpty()) {
            System.out.println("No student records found in database.");
            return;
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-22s | %-6s%n", "ID", "Name", "Course", "GPA");
        System.out.println("-----------------------------------------------------------------------");

        for (Student s : studentList) {
            System.out.printf("%-10s | %-20s | %-22s | %-6.2f%n", s.getId(), s.getName(), s.getCourse(), s.getGpa());
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Total Students Displayed: " + studentList.size());
    }

    // Display Top Student by reading file
    private static void displayTopStudent() {
        List<Student> students = loadStudentsFromFile();
        if (students.isEmpty()) {
            System.out.println("[INFO] No students to evaluate.");
            return;
        }

        Student topStudent = students.get(0);
        for (Student s : students) {
            if (s.getGpa() > topStudent.getGpa()) {
                topStudent = s;
            }
        }

        System.out.println("\n--- Top Performing Student ---");
        System.out.println("ID     : " + topStudent.getId());
        System.out.println("Name   : " + topStudent.getName());
        System.out.println("Course : " + topStudent.getCourse());
        System.out.printf("GPA    : %.2f%n", topStudent.getGpa());
    }

    // Core Reader: Reads file and parses lines into Student objects
    private static List<Student> loadStudentsFromFile() {
        List<Student> list = new ArrayList<>();
        File file = new File(DATABASE_FILE);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Student s = Student.fromFileFormat(line);
                    if (s != null) {
                        list.add(s);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Failed reading students from file: " + e.getMessage());
        }
        return list;
    }

    // Setup helper with initial sample data
    private static void initializeDatabaseIfEmpty() {
        File file = new File(DATABASE_FILE);
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write("S101,Aarav Sharma,Artificial Intelligence,9.4\n");
                bw.write("S102,Sneha Patel,Software Engineering,8.9\n");
                bw.write("S103,Vikram Singh,Cybersecurity,9.1\n");
            } catch (IOException e) {
                System.err.println("[INIT ERROR] " + e.getMessage());
            }
        }
    }
}
