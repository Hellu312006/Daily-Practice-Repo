package Day_36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// Practical 277 / Day 36: Student Details File System
// Tasks:
// Manage Student Records in a file with attributes:
// - Name
// - Roll No
// - Course
// - SPI (Semester Performance Index)
// Features: Add Record, View All Records, Search by Roll Number
// ============================================================================

public class practical_277 {
    private static final String FILE_NAME = "student_details.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSampleDataIfEmpty();

        while (true) {
            System.out.println("\n=============================================================");
            System.out.println("=== Practical 277: Student Details File Management System ===");
            System.out.println("=============================================================");
            System.out.println("1. Add New Student Record");
            System.out.println("2. View All Student Records");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudentRecord(scanner);
                    break;
                case "2":
                    viewAllStudents();
                    break;
                case "3":
                    searchStudentByRollNo(scanner);
                    break;
                case "4":
                    System.out.println("\nExiting Student Details System. Thank you!");
                    System.out.println("=============================================================");
                    scanner.close();
                    return;
                default:
                    System.out.println("[INVALID] Invalid choice! Please enter 1, 2, 3, or 4.");
            }
        }
    }

    // 1. Add New Student Record (Appends to File)
    private static void addStudentRecord(Scanner scanner) {
        System.out.println("\n--- Add New Student Record ---");
        System.out.print("Enter Student Name   : ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Roll Number    : ");
        String rollNo = scanner.nextLine().trim();

        System.out.print("Enter Course/Branch  : ");
        String course = scanner.nextLine().trim();

        System.out.print("Enter SPI (0.0 - 10.0): ");
        String spi = scanner.nextLine().trim();

        if (name.isEmpty() || rollNo.isEmpty() || course.isEmpty() || spi.isEmpty()) {
            System.out.println("[ERROR] All fields are mandatory! Record not saved.");
            return;
        }

        // Format: RollNo,Name,Course,SPI
        String recordLine = rollNo + "," + name + "," + course + "," + spi;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(recordLine);
            bw.newLine();
            System.out.println("[SUCCESS] Student record added successfully for: " + name + " (Roll No: " + rollNo + ")");
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to save record: " + e.getMessage());
        }
    }

    // 2. View All Student Records (Reads from File & formats table)
    private static void viewAllStudents() {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("                           ALL STUDENT RECORDS                           ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-12s | %-20s | %-20s | %-6s%n", "Roll No", "Name", "Course", "SPI");
        System.out.println("-------------------------------------------------------------------------");

        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("                   No student records found in file.                     ");
            System.out.println("-------------------------------------------------------------------------");
            return;
        }

        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    System.out.printf("%-12s | %-20s | %-20s | %-6s%n", parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
                    count++;
                }
            }
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Total Students Count: " + count);
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to read student records: " + e.getMessage());
        }
    }

    // 3. Search Student by Roll Number
    private static void searchStudentByRollNo(Scanner scanner) {
        System.out.print("\nEnter Roll Number to search: ");
        String searchRoll = scanner.nextLine().trim();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("[ERROR] Record file not found.");
            return;
        }

        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].trim().equalsIgnoreCase(searchRoll)) {
                    System.out.println("\n[MATCH FOUND]");
                    System.out.println("----------------------------------------");
                    System.out.println("Roll Number : " + parts[0].trim());
                    System.out.println("Name        : " + parts[1].trim());
                    System.out.println("Course      : " + parts[2].trim());
                    System.out.println("SPI         : " + parts[3].trim());
                    System.out.println("----------------------------------------");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("[NOT FOUND] No student found with Roll Number: " + searchRoll);
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Failed searching file: " + e.getMessage());
        }
    }

    // Helper: Initialize with sample data if file does not exist
    private static void initializeSampleDataIfEmpty() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write("101,Aarav Patel,Computer Engineering,8.75\n");
                bw.write("102,Diya Sharma,Information Technology,9.10\n");
                bw.write("103,Rohan Verma,Data Science,8.45\n");
            } catch (IOException e) {
                System.err.println("[INIT ERROR] " + e.getMessage());
            }
        }
    }
}
