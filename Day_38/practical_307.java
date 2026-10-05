package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ============================================================================
// Practical 307 / Day 38: Insert Student Using PreparedStatement
// Task: Implement a modular and secure record insertion workflow using
//       JDBC PreparedStatement with parameter placeholders (?) to prevent
//       SQL injection and handle data types accurately.
// ============================================================================

public class practical_307 {

    // Database connection credentials
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "school_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password

    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    /**
     * Inserts a student record into the MySQL database using a PreparedStatement.
     *
     * @param conn      Active database connection
     * @param rollNo    Unique roll number
     * @param firstName First name
     * @param lastName  Last name
     * @param email     Email address
     * @param course    Course name
     * @param gpa       Grade Point Average
     * @return auto-generated student_id, or -1 if insertion failed
     */
    public static long insertStudent(Connection conn, int rollNo, String firstName, String lastName,
                                     String email, String course, double gpa) throws SQLException {

        String insertSQL = "INSERT INTO student (roll_number, first_name, last_name, email, course, gpa) "
                         + "VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
            // Positional parameter binding
            pstmt.setInt(1, rollNo);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, email);
            pstmt.setString(5, course);
            pstmt.setDouble(6, gpa);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 307: Insert Student Using PreparedStatement ===");
        System.out.println("=============================================================\n");

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("  -> Connected successfully.");

            // Sample student data to insert
            int rollNo = 107;
            String fName = "Grace";
            String lName = "Hopper";
            String email = "grace.hopper@example.com";
            String course = "Computer Science & Systems";
            double gpa = 3.98;

            System.out.println("\n[Step 2] Inserting new student using PreparedStatement:");
            System.out.println("  * Roll Number : " + rollNo);
            System.out.println("  * Name        : " + fName + " " + lName);
            System.out.println("  * Email       : " + email);
            System.out.println("  * Course      : " + course);
            System.out.println("  * GPA         : " + gpa);

            long newId = insertStudent(connection, rollNo, fName, lName, email, course, gpa);

            if (newId != -1) {
                System.out.println("\n  [SUCCESS] Student inserted successfully!");
                System.out.println("  -> Assigned Student ID : " + newId);

                // Step 3: Fetch and print the inserted record
                System.out.println("\n[Step 3] Fetching inserted record to verify:");
                String selectSQL = "SELECT * FROM student WHERE student_id = ?;";
                try (PreparedStatement fetchStmt = connection.prepareStatement(selectSQL)) {
                    fetchStmt.setLong(1, newId);
                    try (ResultSet rs = fetchStmt.executeQuery()) {
                        if (rs.next()) {
                            System.out.println("  +------------------------------------------------------------+");
                            System.out.printf("  | ID         : %-45d |\n", rs.getInt("student_id"));
                            System.out.printf("  | Roll No    : %-45d |\n", rs.getInt("roll_number"));
                            System.out.printf("  | Name       : %-45s |\n", rs.getString("first_name") + " " + rs.getString("last_name"));
                            System.out.printf("  | Email      : %-45s |\n", rs.getString("email"));
                            System.out.printf("  | Course     : %-45s |\n", rs.getString("course"));
                            System.out.printf("  | GPA        : %-45.2f |\n", rs.getDouble("gpa"));
                            System.out.printf("  | Enrolled   : %-45s |\n", rs.getTimestamp("enrollment_date"));
                            System.out.println("  +------------------------------------------------------------+");
                        }
                    }
                }
            } else {
                System.out.println("\n  [-] Insertion failed. No ID generated.");
            }

        } catch (SQLException e) {
            System.err.println("\n[!] PreparedStatement Insertion Error!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
            System.err.println("\n[Troubleshooting Tips]:");
            System.err.println("  1. Check if roll_number or email is already registered (UNIQUE constraint).");
            System.err.println("  2. Ensure table 'student' exists in 'school_db'.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 307 execution finished.");
        System.out.println("=============================================================");
    }
}
