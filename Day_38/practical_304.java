package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// ============================================================================
// Practical 304 / Day 38: Update Student Course
// Task: Update the enrolled course of a specific student in the MySQL 'student'
//       table using a parameterized UPDATE PreparedStatement and verify changes.
// ============================================================================

public class practical_304 {

    // Database connection credentials
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "school_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password

    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 304: Update Student Course (JDBC Update)   ===");
        System.out.println("=============================================================\n");

        int targetStudentId = 2;
        String newCourse = "Artificial Intelligence & Machine Learning";

        String fetchQuery = "SELECT student_id, first_name, last_name, course FROM student WHERE student_id = ?;";
        String updateQuery = "UPDATE student SET course = ? WHERE student_id = ?;";

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("  -> Connected successfully.");

            // Step 2: Check current student details before update
            System.out.println("\n[Step 2] Fetching current record for student_id = " + targetStudentId + "...");
            String studentName = "";
            String oldCourse = "";
            boolean exists = false;

            try (PreparedStatement fetchStmt = connection.prepareStatement(fetchQuery)) {
                fetchStmt.setInt(1, targetStudentId);
                try (ResultSet rs = fetchStmt.executeQuery()) {
                    if (rs.next()) {
                        exists = true;
                        studentName = rs.getString("first_name") + " " + rs.getString("last_name");
                        oldCourse = rs.getString("course");
                        System.out.println("  -> Student Name  : " + studentName);
                        System.out.println("  -> Current Course: " + oldCourse);
                    } else {
                        System.out.println("  [-] Student with ID " + targetStudentId + " not found!");
                        System.out.println("      Please ensure records exist by running practical_300 or practical_301.");
                        return;
                    }
                }
            }

            // Step 3: Execute UPDATE query
            if (exists) {
                System.out.println("\n[Step 3] Executing UPDATE statement:");
                System.out.println("  * Updating course from: \"" + oldCourse + "\"");
                System.out.println("  * Updating course to  : \"" + newCourse + "\"");

                try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, newCourse);
                    updateStmt.setInt(2, targetStudentId);

                    int rowsAffected = updateStmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("\n  [+] Update successful! (" + rowsAffected + " row updated)");
                    } else {
                        System.out.println("\n  [-] No rows were updated.");
                    }
                }

                // Step 4: Verify the updated record
                System.out.println("\n[Step 4] Verifying updated record from database:");
                try (PreparedStatement verifyStmt = connection.prepareStatement(fetchQuery)) {
                    verifyStmt.setInt(1, targetStudentId);
                    try (ResultSet rs = verifyStmt.executeQuery()) {
                        if (rs.next()) {
                            System.out.println("  +------------------------------------------------------------+");
                            System.out.println("  |                   UPDATED STUDENT RECORD                   |");
                            System.out.println("  +------------------------------------------------------------+");
                            System.out.printf("  | %-18s : %-37s |\n", "Student ID", rs.getInt("student_id"));
                            System.out.printf("  | %-18s : %-37s |\n", "Full Name", studentName);
                            System.out.printf("  | %-18s : %-37s |\n", "Updated Course", rs.getString("course"));
                            System.out.println("  +------------------------------------------------------------+");
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Error updating student course!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 304 execution finished.");
        System.out.println("=============================================================");
    }
}
