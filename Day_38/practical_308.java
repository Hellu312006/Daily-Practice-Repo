package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// ============================================================================
// Practical 308 / Day 38: Search Student Using PreparedStatement
// Task: Execute flexible and secure searches on the MySQL 'student' table
//       using parameterized PreparedStatement with wildcard matching (LIKE)
//       and multi-criteria filtering (Course & GPA threshold).
// ============================================================================

public class practical_308 {

    // Database connection credentials
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "school_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password

    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // Helper method to display ResultSet in a formatted ASCII table
    private static void printStudentTable(ResultSet rs) throws SQLException {
        String line = "+----+---------+----------------------+-----------------------------+-----------------------+------+";
        System.out.println(line);
        System.out.printf("| %-2s | %-7s | %-20s | %-27s | %-21s | %-4s |\n",
                "ID", "Roll No", "Full Name", "Email", "Course", "GPA");
        System.out.println(line);

        int count = 0;
        while (rs.next()) {
            int id = rs.getInt("student_id");
            int rollNo = rs.getInt("roll_number");
            String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
            String email = rs.getString("email");
            String course = rs.getString("course");
            double gpa = rs.getDouble("gpa");

            System.out.printf("| %-2d | %-7d | %-20s | %-27s | %-21s | %-4.2f |\n",
                    id, rollNo, fullName, email, course, gpa);
            count++;
        }
        System.out.println(line);
        System.out.println("  -> Total matching records: " + count + "\n");
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 308: Search Student Using PreparedStatement ===");
        System.out.println("=============================================================\n");

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("  -> Connected successfully.");

            // -------------------------------------------------------------
            // Search 1: Search students by partial name (Wildcard search)
            // -------------------------------------------------------------
            String nameKeyword = "an"; // Will match 'Diana', 'Ethan', etc.
            System.out.println("\n[Search 1] Finding students with name containing: \"" + nameKeyword + "\"");

            String nameSearchSQL = "SELECT * FROM student WHERE first_name LIKE ? OR last_name LIKE ? ORDER BY student_id ASC;";
            try (PreparedStatement nameStmt = connection.prepareStatement(nameSearchSQL)) {
                String pattern = "%" + nameKeyword + "%";
                nameStmt.setString(1, pattern);
                nameStmt.setString(2, pattern);

                try (ResultSet rs = nameStmt.executeQuery()) {
                    printStudentTable(rs);
                }
            }

            // -------------------------------------------------------------
            // Search 2: Multi-criteria search by Course and Minimum GPA
            // -------------------------------------------------------------
            String targetCourse = "Computer Science";
            double minGpa = 3.80;
            System.out.println("[Search 2] Finding students in Course: \"" + targetCourse + "\" with GPA >= " + minGpa);

            String filterSQL = "SELECT * FROM student WHERE course = ? AND gpa >= ? ORDER BY gpa DESC;";
            try (PreparedStatement filterStmt = connection.prepareStatement(filterSQL)) {
                filterStmt.setString(1, targetCourse);
                filterStmt.setDouble(2, minGpa);

                try (ResultSet rs = filterStmt.executeQuery()) {
                    printStudentTable(rs);
                }
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Error during student search operation!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
        }

        System.out.println("=============================================================");
        System.out.println("Practical 308 execution finished.");
        System.out.println("=============================================================");
    }
}
