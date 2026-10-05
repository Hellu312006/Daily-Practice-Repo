package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// ============================================================================
// Practical 309 / Day 38: Update Student Using PreparedStatement
// Task: Safely update multiple fields (Course, Email, GPA) of an existing
//       student record in MySQL using a parameterized PreparedStatement.
// ============================================================================

public class practical_309 {

    // Database connection credentials
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "school_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password

    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    /**
     * Updates an existing student's course, email, and GPA using PreparedStatement.
     *
     * @param conn      Active database connection
     * @param studentId ID of the student to update
     * @param newCourse Updated course name
     * @param newEmail  Updated email address
     * @param newGpa    Updated GPA score
     * @return number of affected rows (1 if successful, 0 if ID not found)
     */
    public static int updateStudent(Connection conn, int studentId, String newCourse, 
                                    String newEmail, double newGpa) throws SQLException {
        String updateSQL = "UPDATE student SET course = ?, email = ?, gpa = ? WHERE student_id = ?;";

        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            // Positional parameter binding (?)
            pstmt.setString(1, newCourse);
            pstmt.setString(2, newEmail);
            pstmt.setDouble(3, newGpa);
            pstmt.setInt(4, studentId);

            return pstmt.executeUpdate();
        }
    }

    // Helper method to display a student's current profile
    private static void displayStudentProfile(Connection conn, int studentId, String header) throws SQLException {
        String selectSQL = "SELECT * FROM student WHERE student_id = ?;";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setInt(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("  +------------------------------------------------------------+");
                    System.out.println("  | " + String.format("%-58s", header) + " |");
                    System.out.println("  +------------------------------------------------------------+");
                    System.out.printf("  | %-18s : %-37s |\n", "Student ID", rs.getInt("student_id"));
                    System.out.printf("  | %-18s : %-37s |\n", "Roll Number", rs.getInt("roll_number"));
                    System.out.printf("  | %-18s : %-37s |\n", "Full Name", rs.getString("first_name") + " " + rs.getString("last_name"));
                    System.out.printf("  | %-18s : %-37s |\n", "Email Address", rs.getString("email"));
                    System.out.printf("  | %-18s : %-37s |\n", "Enrolled Course", rs.getString("course"));
                    System.out.printf("  | %-18s : %-37.2f |\n", "GPA", rs.getDouble("gpa"));
                    System.out.println("  +------------------------------------------------------------+");
                } else {
                    System.out.println("  [-] No record found for student_id = " + studentId);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 309: Update Student Using PreparedStatement ===");
        System.out.println("=============================================================\n");

        int targetStudentId = 1;
        String updatedCourse = "Data Science & Artificial Intelligence";
        String updatedEmail = "alice.j.advanced@example.com";
        double updatedGpa = 3.96;

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("  -> Connected successfully.");

            // Step 2: Show state before update
            System.out.println("\n[Step 2] Fetching initial student profile before update:");
            displayStudentProfile(connection, targetStudentId, "INITIAL RECORD (BEFORE UPDATE)");

            // Step 3: Execute Update via PreparedStatement
            System.out.println("\n[Step 3] Executing UPDATE statement with new parameters:");
            System.out.println("  * Target Student ID : " + targetStudentId);
            System.out.println("  * New Course        : " + updatedCourse);
            System.out.println("  * New Email         : " + updatedEmail);
            System.out.println("  * New GPA           : " + updatedGpa);

            int rowsUpdated = updateStudent(connection, targetStudentId, updatedCourse, updatedEmail, updatedGpa);

            if (rowsUpdated > 0) {
                System.out.println("\n  [SUCCESS] Student record updated successfully! Rows affected: " + rowsUpdated);

                // Step 4: Show state after update
                System.out.println("\n[Step 4] Fetching modified student profile to verify changes:");
                displayStudentProfile(connection, targetStudentId, "MODIFIED RECORD (AFTER UPDATE)");
            } else {
                System.out.println("\n  [-] Update failed. Student ID " + targetStudentId + " not found.");
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Error during PreparedStatement update!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 309 execution finished.");
        System.out.println("=============================================================");
    }
}
