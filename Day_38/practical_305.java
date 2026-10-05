package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// ============================================================================
// Practical 305 / Day 38: Delete Student
// Task: Remove a specific student record from the MySQL 'student' table
//       using a parameterized DELETE PreparedStatement and verify deletion.
// ============================================================================

public class practical_305 {

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
        System.out.println("=== Practical 305: Delete Student from MySQL Table (JDBC) ===");
        System.out.println("=============================================================\n");

        int targetStudentId = 6;

        String selectQuery = "SELECT student_id, roll_number, first_name, last_name, email FROM student WHERE student_id = ?;";
        String deleteQuery = "DELETE FROM student WHERE student_id = ?;";

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("  -> Connected successfully.");

            // Step 2: Check if the record exists before deletion
            System.out.println("\n[Step 2] Locating student record (student_id = " + targetStudentId + ")...");
            boolean exists = false;
            String studentName = "";

            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
                selectStmt.setInt(1, targetStudentId);
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        exists = true;
                        studentName = rs.getString("first_name") + " " + rs.getString("last_name");
                        System.out.println("  -> Found record: [" + rs.getInt("student_id") + "] " 
                                + studentName + " (Roll: " + rs.getInt("roll_number") + ")");
                    } else {
                        System.out.println("  [-] No record found with student_id = " + targetStudentId + " to delete.");
                        System.out.println("      Please verify the ID or run practical_300/practical_301 first.");
                        return;
                    }
                }
            }

            // Step 3: Execute the DELETE statement
            if (exists) {
                System.out.println("\n[Step 3] Executing DELETE operation...");
                System.out.println("  -> SQL: " + deleteQuery);

                try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                    deleteStmt.setInt(1, targetStudentId);

                    int rowsAffected = deleteStmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("  [+] Successfully deleted student '" + studentName 
                                + "' (ID: " + targetStudentId + ")! Rows affected: " + rowsAffected);
                    } else {
                        System.out.println("  [-] Deletion failed. No rows affected.");
                    }
                }

                // Step 4: Verify deletion
                System.out.println("\n[Step 4] Verifying deletion from database:");
                try (PreparedStatement verifyStmt = connection.prepareStatement(selectQuery)) {
                    verifyStmt.setInt(1, targetStudentId);
                    try (ResultSet rs = verifyStmt.executeQuery()) {
                        if (!rs.next()) {
                            System.out.println("  [CONFIRMED] Record with student_id = " + targetStudentId + " no longer exists in table.");
                        } else {
                            System.out.println("  [!] Warning: Record still found in database.");
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Error deleting student record!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 305 execution finished.");
        System.out.println("=============================================================");
    }
}
