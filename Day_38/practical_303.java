package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// ============================================================================
// Practical 303 / Day 38: Search Student by ID
// Task: Search for a specific student record in the MySQL 'student' table
//       by primary key (student_id) using a parameterized PreparedStatement.
// ============================================================================

public class practical_303 {

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
        System.out.println("=== Practical 303: Search Student by ID (JDBC)            ===");
        System.out.println("=============================================================\n");

        // Target student_id to search for
        int searchId = 1;

        String searchQuery = "SELECT student_id, roll_number, first_name, last_name, email, "
                           + "course, gpa, enrollment_date FROM student WHERE student_id = ?;";

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(searchQuery)) {

            System.out.println("  -> Connected successfully.");

            System.out.println("\n[Step 2] Executing search query for student_id = " + searchId + "...");
            pstmt.setInt(1, searchId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("\n  [+] Student Record Found!\n");
                    System.out.println("  +------------------------------------------------------------+");
                    System.out.println("  |                     STUDENT PROFILE CARD                   |");
                    System.out.println("  +------------------------------------------------------------+");
                    System.out.printf("  | %-18s : %-37s |\n", "Student ID", rs.getInt("student_id"));
                    System.out.printf("  | %-18s : %-37s |\n", "Roll Number", rs.getInt("roll_number"));
                    System.out.printf("  | %-18s : %-37s |\n", "Full Name", rs.getString("first_name") + " " + rs.getString("last_name"));
                    System.out.printf("  | %-18s : %-37s |\n", "Email Address", rs.getString("email"));
                    System.out.printf("  | %-18s : %-37s |\n", "Enrolled Course", rs.getString("course"));
                    System.out.printf("  | %-18s : %-37.2f |\n", "GPA", rs.getDouble("gpa"));
                    System.out.printf("  | %-18s : %-37s |\n", "Enrollment Date", rs.getTimestamp("enrollment_date"));
                    System.out.println("  +------------------------------------------------------------+");
                } else {
                    System.out.println("\n  [-] No student found with student_id = " + searchId);
                    System.out.println("      Please verify the ID or run practical_300/practical_301 to insert records.");
                }
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Error executing search query!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
            System.err.println("\n[Troubleshooting Tips]:");
            System.err.println("  1. Ensure MySQL server is running on port 3306.");
            System.err.println("  2. Ensure 'school_db' and 'student' table exist.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 303 execution finished.");
        System.out.println("=============================================================");
    }
}
