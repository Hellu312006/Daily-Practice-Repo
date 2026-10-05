package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ============================================================================
// Practical 306 / Day 38: Display Total Students
// Task: Calculate and display the total number of students and department
//       breakdowns using SQL Aggregate functions (COUNT, AVG, MIN, MAX) via JDBC.
// ============================================================================

public class practical_306 {

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
        System.out.println("=== Practical 306: Display Total Students (SQL Aggregate) ===");
        System.out.println("=============================================================\n");

        String totalCountQuery = "SELECT COUNT(*) AS total_students, "
                               + "AVG(gpa) AS avg_gpa, "
                               + "MIN(gpa) AS min_gpa, "
                               + "MAX(gpa) AS max_gpa "
                               + "FROM student;";

        String courseGroupingQuery = "SELECT course, COUNT(*) AS count_per_course, AVG(gpa) AS course_avg_gpa "
                                   + "FROM student GROUP BY course ORDER BY count_per_course DESC;";

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            System.out.println("  -> Connected successfully.");

            // Step 2: Execute Overall Aggregate Query
            System.out.println("\n[Step 2] Executing Aggregate Query: COUNT(*), AVG(gpa), MIN(gpa), MAX(gpa)...");
            try (ResultSet rs = statement.executeQuery(totalCountQuery)) {
                if (rs.next()) {
                    int total = rs.getInt("total_students");
                    double avgGpa = rs.getDouble("avg_gpa");
                    double minGpa = rs.getDouble("min_gpa");
                    double maxGpa = rs.getDouble("max_gpa");

                    System.out.println("\n  +------------------------------------------------------------+");
                    System.out.println("  |                 OVERALL ENROLLMENT SUMMARY                 |");
                    System.out.println("  +------------------------------------------------------------+");
                    System.out.printf("  | %-25s : %-30d |\n", "Total Students Enrolled", total);
                    System.out.printf("  | %-25s : %-30.2f |\n", "Average Class GPA", avgGpa);
                    System.out.printf("  | %-25s : %-30.2f |\n", "Minimum GPA", minGpa);
                    System.out.printf("  | %-25s : %-30.2f |\n", "Maximum GPA", maxGpa);
                    System.out.println("  +------------------------------------------------------------+");
                }
            }

            // Step 3: Execute Group By Course Query
            System.out.println("\n[Step 3] Breakdown by Enrolled Course (GROUP BY course):");
            System.out.println("+----------------------------------+------------------+--------------+");
            System.out.printf("| %-32s | %-16s | %-12s |\n", "Course Name", "Student Count", "Avg GPA");
            System.out.println("+----------------------------------+------------------+--------------+");

            try (ResultSet rs = statement.executeQuery(courseGroupingQuery)) {
                while (rs.next()) {
                    String course = rs.getString("course");
                    int count = rs.getInt("count_per_course");
                    double avgGpa = rs.getDouble("course_avg_gpa");

                    System.out.printf("| %-32s | %-16d | %-12.2f |\n", course, count, avgGpa);
                }
            }
            System.out.println("+----------------------------------+------------------+--------------+");

        } catch (SQLException e) {
            System.err.println("\n[!] Error executing count query!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
            System.err.println("\n[Troubleshooting Tips]:");
            System.err.println("  1. Verify that 'school_db' and 'student' table exist.");
            System.err.println("  2. Run practical_300/practical_301 to insert student records first.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 306 execution finished.");
        System.out.println("=============================================================");
    }
}
