package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// ============================================================================
// Practical 310 / Day 38: Delete Student Using PreparedStatement
// Task: Safely delete a specific student record from the MySQL 'student' table
//       using a parameterized PreparedStatement and verify complete removal.
// ============================================================================

public class practical_310 {

    // Database connection credentials
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "school_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password

    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    /**
     * Deletes a student record by their unique Roll Number.
     *
     * @param conn   Active database connection
     * @param rollNo Unique roll number of the student
     * @return number of affected rows (1 if deleted, 0 if not found)
     */
    public static int deleteStudentByRollNumber(Connection conn, int rollNo) throws SQLException {
        String deleteSQL = "DELETE FROM student WHERE roll_number = ?;";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, rollNo);
            return pstmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 310: Delete Student Using PreparedStatement ===");
        System.out.println("=============================================================\n");

        int targetRollNumber = 105; // Target roll number to remove

        String selectSQL = "SELECT * FROM student WHERE roll_number = ?;";

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("  -> Connected successfully.");

            // Step 2: Check if record exists before deleting
            System.out.println("\n[Step 2] Locating target student with Roll Number = " + targetRollNumber + "...");
            boolean found = false;
            String studentName = "";

            try (PreparedStatement checkStmt = connection.prepareStatement(selectSQL)) {
                checkStmt.setInt(1, targetRollNumber);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        found = true;
                        studentName = rs.getString("first_name") + " " + rs.getString("last_name");
                        System.out.println("  -> Record Found:");
                        System.out.println("     * Student ID : " + rs.getInt("student_id"));
                        System.out.println("     * Roll Number: " + rs.getInt("roll_number"));
                        System.out.println("     * Full Name  : " + studentName);
                        System.out.println("     * Course     : " + rs.getString("course"));
                    } else {
                        System.out.println("  [-] No student found with Roll Number " + targetRollNumber + ".");
                        System.out.println("      Please ensure records exist by running practical_300/practical_301 first.");
                        return;
                    }
                }
            }

            // Step 3: Execute parameterized deletion
            if (found) {
                System.out.println("\n[Step 3] Deleting record using PreparedStatement...");
                int rowsDeleted = deleteStudentByRollNumber(connection, targetRollNumber);

                if (rowsDeleted > 0) {
                    System.out.println("  [SUCCESS] Deleted student '" + studentName 
                            + "' (Roll No: " + targetRollNumber + ")! Rows affected: " + rowsDeleted);
                } else {
                    System.out.println("  [-] Deletion failed. No rows affected.");
                }

                // Step 4: Verify record has been removed
                System.out.println("\n[Step 4] Verifying record deletion from database:");
                try (PreparedStatement verifyStmt = connection.prepareStatement(selectSQL)) {
                    verifyStmt.setInt(1, targetRollNumber);
                    try (ResultSet rs = verifyStmt.executeQuery()) {
                        if (!rs.next()) {
                            System.out.println("  [CONFIRMED] Record with Roll Number " + targetRollNumber + " has been successfully removed.");
                        } else {
                            System.out.println("  [!] Warning: Record still found in database.");
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Error during PreparedStatement deletion!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 310 execution finished.");
        System.out.println("=============================================================");
    }
}
