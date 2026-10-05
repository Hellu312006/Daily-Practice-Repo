package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ============================================================================
// Practical 300 / Day 38: Insert One Student into MySQL Table
// Task: Connect to MySQL database 'school_db' and insert a single student record
//       using JDBC PreparedStatement (parameterized query) and retrieve the
//       auto-generated primary key ID.
// ============================================================================

public class practical_300 {

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
        System.out.println("=== Practical 300: Insert One Student into MySQL Table     ===");
        System.out.println("=============================================================\n");

        // Student data to insert
        int rollNumber = 101;
        String firstName = "Alice";
        String lastName = "Johnson";
        String email = "alice.johnson@example.com";
        String course = "Computer Science";
        double gpa = 3.85;

        // SQL parameterized INSERT statement
        String insertSQL = "INSERT INTO student (roll_number, first_name, last_name, email, course, gpa) "
                         + "VALUES (?, ?, ?, ?, ?, ?);";

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             // Request generated keys so we can read the AUTO_INCREMENT student_id
             PreparedStatement pstmt = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("  -> Connected successfully.");

            System.out.println("\n[Step 2] Preparing INSERT statement with parameters:");
            System.out.println("  * Roll Number : " + rollNumber);
            System.out.println("  * First Name  : " + firstName);
            System.out.println("  * Last Name   : " + lastName);
            System.out.println("  * Email       : " + email);
            System.out.println("  * Course      : " + course);
            System.out.println("  * GPA         : " + gpa);

            // Bind values to placeholders (?)
            pstmt.setInt(1, rollNumber);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, email);
            pstmt.setString(5, course);
            pstmt.setDouble(6, gpa);

            System.out.println("\n[Step 3] Executing INSERT query...");
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("  [+] Insert successful! Rows affected: " + rowsAffected);

                // Step 4: Retrieve auto-generated student_id
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long generatedId = generatedKeys.getLong(1);
                        System.out.println("  [+] Generated Primary Key (student_id): " + generatedId);
                    }
                }
            } else {
                System.out.println("  [-] No rows were inserted.");
            }

            // Step 5: Verify by fetching the inserted row
            System.out.println("\n[Step 4] Verifying inserted record in database:");
            String verifySQL = "SELECT * FROM student WHERE roll_number = ?";
            try (PreparedStatement verifyStmt = connection.prepareStatement(verifySQL)) {
                verifyStmt.setInt(1, rollNumber);
                try (ResultSet rs = verifyStmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("  +------------------------------------------------------+");
                        System.out.println("  | ID     : " + rs.getInt("student_id"));
                        System.out.println("  | Roll No: " + rs.getInt("roll_number"));
                        System.out.println("  | Name   : " + rs.getString("first_name") + " " + rs.getString("last_name"));
                        System.out.println("  | Email  : " + rs.getString("email"));
                        System.out.println("  | Course : " + rs.getString("course"));
                        System.out.println("  | GPA    : " + rs.getDouble("gpa"));
                        System.out.println("  | Date   : " + rs.getTimestamp("enrollment_date"));
                        System.out.println("  +------------------------------------------------------+");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Error inserting student record!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
            System.err.println("\n[Troubleshooting Tips]:");
            System.err.println("  1. Ensure database 'school_db' and table 'student' exist (Run practical_298 and practical_299).");
            System.err.println("  2. Check if roll_number or email already exists (UNIQUE constraint violation).");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 300 execution finished.");
        System.out.println("=============================================================");
    }
}
