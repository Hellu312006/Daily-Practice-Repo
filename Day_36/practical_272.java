package Day_36;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// ============================================================================
// Practical 272 / Day 36: Write Student Information into a File
// Task: Collect student records and write them into a text file using FileWriter
// ============================================================================

public class practical_272 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 272: Write Student Information into a File  ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        String outputFileName = "student_records.txt";

        System.out.println("Enter Student Details:");
        System.out.print("1. Roll Number  : ");
        String rollNo = scanner.nextLine().trim();
        if (rollNo.isEmpty()) rollNo = "101";

        System.out.print("2. Student Name : ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "John Doe";

        System.out.print("3. Course/Branch: ");
        String course = scanner.nextLine().trim();
        if (course.isEmpty()) course = "Computer Science";

        System.out.print("4. Semester     : ");
        String semester = scanner.nextLine().trim();
        if (semester.isEmpty()) semester = "4";

        System.out.print("5. GPA / Marks  : ");
        String marks = scanner.nextLine().trim();
        if (marks.isEmpty()) marks = "8.9";

        // Write student information to file using FileWriter (in append mode) and PrintWriter
        try (FileWriter fw = new FileWriter(outputFileName, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("==========================================");
            pw.println("             STUDENT RECORD               ");
            pw.println("==========================================");
            pw.println("Roll Number : " + rollNo);
            pw.println("Name        : " + name);
            pw.println("Course      : " + course);
            pw.println("Semester    : " + semester);
            pw.println("GPA / Marks : " + marks);
            pw.println("Recorded At : " + java.time.LocalDateTime.now().toString());
            pw.println("==========================================\n");

            System.out.println("\n-------------------------------------------------------------");
            System.out.println("[SUCCESS] Student information written to file successfully!");
            System.out.println("File Saved As : " + outputFileName);
            System.out.println("-------------------------------------------------------------");
            System.out.println("Summary:");
            System.out.println("Roll No: " + rollNo + " | Name: " + name + " | Course: " + course + " | GPA: " + marks);

        } catch (IOException e) {
            System.err.println("[ERROR] Failed to write student information: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 272 executed successfully!");
        System.out.println("=============================================================");
    }
}
