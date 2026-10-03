package Day_36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// Practical 278 / Day 36: Employee Details File System
// Tasks:
// Manage Employee Records in a file with attributes:
// - Name
// - ID
// - Salary
// - Department
// Features: Add Employee, View All Records, Search by ID, Salary Analytics
// ============================================================================

public class practical_278 {
    private static final String FILE_NAME = "employee_details.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSampleDataIfEmpty();

        while (true) {
            System.out.println("\n=============================================================");
            System.out.println("=== Practical 278: Employee Details File Management System ===");
            System.out.println("=============================================================");
            System.out.println("1. Add New Employee Record");
            System.out.println("2. View All Employee Records");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. View Department & Salary Analytics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addEmployeeRecord(scanner);
                    break;
                case "2":
                    viewAllEmployees();
                    break;
                case "3":
                    searchEmployeeByID(scanner);
                    break;
                case "4":
                    viewSalaryAnalytics();
                    break;
                case "5":
                    System.out.println("\nExiting Employee Details System. Thank you!");
                    System.out.println("=============================================================");
                    scanner.close();
                    return;
                default:
                    System.out.println("[INVALID] Invalid choice! Please enter 1, 2, 3, 4, or 5.");
            }
        }
    }

    // 1. Add New Employee Record (Appends to File)
    private static void addEmployeeRecord(Scanner scanner) {
        System.out.println("\n--- Add New Employee Record ---");
        System.out.print("Enter Employee ID         : ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter Employee Name       : ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Salary ($ / INR)    : ");
        String salary = scanner.nextLine().trim();

        System.out.print("Enter Department (e.g. IT): ");
        String department = scanner.nextLine().trim();

        if (id.isEmpty() || name.isEmpty() || salary.isEmpty() || department.isEmpty()) {
            System.out.println("[ERROR] All fields are mandatory! Record not saved.");
            return;
        }

        // Format: ID,Name,Salary,Department
        String recordLine = id + "," + name + "," + salary + "," + department;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(recordLine);
            bw.newLine();
            System.out.println("[SUCCESS] Employee record saved successfully for: " + name + " (ID: " + id + ")");
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to save record: " + e.getMessage());
        }
    }

    // 2. View All Employee Records (Reads from File & formats table)
    private static void viewAllEmployees() {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("                           ALL EMPLOYEE RECORDS                          ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-10s | %-22s | %-14s | %-16s%n", "Emp ID", "Name", "Salary", "Department");
        System.out.println("-------------------------------------------------------------------------");

        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("                   No employee records found in file.                    ");
            System.out.println("-------------------------------------------------------------------------");
            return;
        }

        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    System.out.printf("%-10s | %-22s | $%-13s | %-16s%n",
                            parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
                    count++;
                }
            }
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Total Employees Count: " + count);
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to read employee records: " + e.getMessage());
        }
    }

    // 3. Search Employee by ID
    private static void searchEmployeeByID(Scanner scanner) {
        System.out.print("\nEnter Employee ID to search: ");
        String searchId = scanner.nextLine().trim();

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
                if (parts.length == 4 && parts[0].trim().equalsIgnoreCase(searchId)) {
                    System.out.println("\n[MATCH FOUND]");
                    System.out.println("----------------------------------------");
                    System.out.println("Employee ID : " + parts[0].trim());
                    System.out.println("Name        : " + parts[1].trim());
                    System.out.println("Salary      : $" + parts[2].trim());
                    System.out.println("Department  : " + parts[3].trim());
                    System.out.println("----------------------------------------");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("[NOT FOUND] No employee found with ID: " + searchId);
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Failed searching employee file: " + e.getMessage());
        }
    }

    // 4. View Salary Analytics
    private static void viewSalaryAnalytics() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("[INFO] No records available for analytics.");
            return;
        }

        double totalSalary = 0.0;
        int count = 0;
        double maxSalary = Double.MIN_VALUE;
        String highestPaid = "N/A";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        double salary = Double.parseDouble(parts[2].trim());
                        totalSalary += salary;
                        count++;
                        if (salary > maxSalary) {
                            maxSalary = salary;
                            highestPaid = parts[1].trim() + " (" + parts[3].trim() + ")";
                        }
                    } catch (NumberFormatException ignored) {}
                }
            }

            System.out.println("\n-------------------------------------------------------------");
            System.out.println("--- Employee Payroll & Salary Analytics ---");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Total Employees Tracked : " + count);
            System.out.printf("Total Payroll Amount    : $%.2f%n", totalSalary);
            System.out.printf("Average Employee Salary : $%.2f%n", (count > 0 ? totalSalary / count : 0.0));
            System.out.printf("Highest Paid Employee   : %s ($%.2f)%n", highestPaid, (maxSalary == Double.MIN_VALUE ? 0.0 : maxSalary));
            System.out.println("-------------------------------------------------------------");

        } catch (IOException e) {
            System.err.println("[ERROR] Analytics failed: " + e.getMessage());
        }
    }

    // Helper: Initialize with sample data if file does not exist
    private static void initializeSampleDataIfEmpty() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write("E101,Alice Johnson,85000.0,Software Engineering\n");
                bw.write("E102,Bob Smith,62000.0,Human Resources\n");
                bw.write("E103,Catherine Lee,95000.0,Product Management\n");
                bw.write("E104,David Miller,72000.0,DevOps\n");
            } catch (IOException e) {
                System.err.println("[INIT ERROR] " + e.getMessage());
            }
        }
    }
}
