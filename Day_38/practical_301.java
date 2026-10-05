package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

// ============================================================================
// Practical 301 / Day 38: Insert Multiple Students into MySQL Table
// Task: Insert multiple student records efficiently into the MySQL 'student'
//       table using JDBC Batch Processing (addBatch, executeBatch) and
//       transaction management (commit, rollback).
// ============================================================================

public class practical_301 {

    // Database connection credentials
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "school_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password

    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // Helper data model representing a Student record
    static class StudentData {
        int rollNumber;
        String firstName;
        String lastName;
        String email;
        String course;
        double gpa;

        public StudentData(int rollNumber, String firstName, String lastName, String email, String course, double gpa) {
            this.rollNumber = rollNumber;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.course = course;
            this.gpa = gpa;
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 301: Insert Multiple Students (Batch Insert)===");
        System.out.println("=============================================================\n");

        // List of students to insert
        List<StudentData> studentList = Arrays.asList(
            new StudentData(102, "Bob", "Smith", "bob.smith@example.com", "Information Technology", 3.65),
            new StudentData(103, "Charlie", "Brown", "charlie.brown@example.com", "Data Science", 3.90),
            new StudentData(104, "Diana", "Prince", "diana.prince@example.com", "Cyber Security", 3.78),
            new StudentData(105, "Ethan", "Hunt", "ethan.hunt@example.com", "Software Engineering", 3.55),
            new StudentData(106, "Fiona", "Gallagher", "fiona.g@example.com", "Computer Science", 3.92)
        );

        String insertSQL = "INSERT INTO student (roll_number, first_name, last_name, email, course, gpa) "
                         + "VALUES (?, ?, ?, ?, ?, ?);";

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("  -> Connected successfully.");

            // Disable auto-commit for transaction control and faster batch inserts
            connection.setAutoCommit(false);
            System.out.println("  -> Disabled Auto-Commit for transactional batch execution.");

            try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {

                System.out.println("\n[Step 2] Queuing student records for batch insert:");
                System.out.println("+---------+----------------------+-----------------------------+-----------------------+------+");
                System.out.printf("| %-7s | %-20s | %-27s | %-21s | %-4s |\n",
                        "Roll No", "Full Name", "Email Address", "Course", "GPA");
                System.out.println("+---------+----------------------+-----------------------------+-----------------------+------+");

                for (StudentData s : studentList) {
                    pstmt.setInt(1, s.rollNumber);
                    pstmt.setString(2, s.firstName);
                    pstmt.setString(3, s.lastName);
                    pstmt.setString(4, s.email);
                    pstmt.setString(5, s.course);
                    pstmt.setDouble(6, s.gpa);

                    // Add current record parameters to the batch
                    pstmt.addBatch();

                    System.out.printf("| %-7d | %-20s | %-27s | %-21s | %-4.2f |\n",
                            s.rollNumber, (s.firstName + " " + s.lastName), s.email, s.course, s.gpa);
                }
                System.out.println("+---------+----------------------+-----------------------------+-----------------------+------+");

                System.out.println("\n[Step 3] Executing batch query (executeBatch())...");
                int[] results = pstmt.executeBatch();

                // Commit transaction to finalize changes
                connection.commit();
                System.out.println("  [+] Transaction committed successfully!");

                int successCount = 0;
                for (int res : results) {
                    if (res >= 0 || res == Statement.SUCCESS_NO_INFO) {
                        successCount++;
                    }
                }
                System.out.println("  [+] Total records inserted: " + successCount + " / " + studentList.size());

            } catch (SQLException batchEx) {
                System.err.println("\n[!] Batch execution failed! Rolling back transaction...");
                connection.rollback();
                System.err.println("  -> Transaction rolled back. No partial changes were saved.");
                throw batchEx;
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Database Error during batch insert:");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 301 execution finished.");
        System.out.println("=============================================================");
    }
}
