package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ============================================================================
// Practical 302 / Day 38: Display All Students
// Task: Retrieve and display all student records from the MySQL database
//       using JDBC Statement and ResultSet in a formatted tabular layout.
// ============================================================================

public class practical_302 {

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
        System.out.println("=== Practical 302: Display All Students from MySQL (JDBC) ===");
        System.out.println("=============================================================");

        String selectQuery = "SELECT student_id, roll_number, first_name, last_name, email, "
                           + "course, gpa, enrollment_date FROM student ORDER BY student_id ASC;";

        System.out.println("\n[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(selectQuery)) {

            System.out.println("  -> Connected successfully.");
            System.out.println("\n[Step 2] Fetching student records from table 'student':");
            System.out.println("  -> Query: " + selectQuery + "\n");

            // Format and print table header
            String line = "+----+---------+----------------------+-----------------------------+-----------------------+------+---------------------+";
            System.out.println(line);
            System.out.printf("| %-2s | %-7s | %-20s | %-27s | %-21s | %-4s | %-19s |\n",
                    "ID", "Roll No", "Full Name", "Email", "Course", "GPA", "Enrollment Date");
            System.out.println(line);

            int totalStudents = 0;
            double totalGpa = 0.0;

            // Iterate over all rows in the ResultSet
            while (rs.next()) {
                int id = rs.getInt("student_id");
                int rollNo = rs.getInt("roll_number");
                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                String email = rs.getString("email");
                String course = rs.getString("course");
                double gpa = rs.getDouble("gpa");
                String enrollDate = rs.getString("enrollment_date");

                System.out.printf("| %-2d | %-7d | %-20s | %-27s | %-21s | %-4.2f | %-19s |\n",
                        id, rollNo, fullName, email, course, gpa, enrollDate);

                totalStudents++;
                totalGpa += gpa;
            }
            System.out.println(line);

            // Step 3: Print summary metrics
            System.out.println("\n[Step 3] Summary Statistics:");
            System.out.println("  * Total Students Found : " + totalStudents);
            if (totalStudents > 0) {
                System.out.printf("  * Class Average GPA    : %.2f\n", (totalGpa / totalStudents));
            } else {
                System.out.println("  [!] No student records currently in database. Run practical_300 and practical_301 first.");
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Error retrieving student records!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
            System.err.println("\n[Troubleshooting Tips]:");
            System.err.println("  1. Ensure MySQL service is running.");
            System.err.println("  2. Verify that 'school_db' and 'student' table exist (Run practical_298 and practical_299).");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 302 execution finished.");
        System.out.println("=============================================================");
    }
}
