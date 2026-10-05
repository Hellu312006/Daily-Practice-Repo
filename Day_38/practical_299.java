package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ============================================================================
// Practical 299 / Day 38: Create Student Table
// Task: Connect to the MySQL database and execute a DDL SQL query to create a
//       'student' table with primary key, constraints, and standard attributes,
//       then verify its schema structure.
// ============================================================================

public class practical_299 {

    // Database connection parameters
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "school_db"; // Target database
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password

    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 299: Create Student Table in MySQL (JDBC)   ===");
        System.out.println("=============================================================\n");

        System.out.println("[Step 1] Connecting to database: '" + DB_NAME + "'...");

        // Try-with-resources ensures proper cleanup of Connection and Statement
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            System.out.println("  -> Successfully connected to database '" + DB_NAME + "'.");

            // Step 2: Define the CREATE TABLE SQL Query
            String createTableQuery = "CREATE TABLE IF NOT EXISTS student ("
                    + "    student_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "    roll_number INT NOT NULL UNIQUE,"
                    + "    first_name VARCHAR(50) NOT NULL,"
                    + "    last_name VARCHAR(50),"
                    + "    email VARCHAR(100) UNIQUE,"
                    + "    course VARCHAR(50) DEFAULT 'Computer Science',"
                    + "    gpa DECIMAL(3, 2) DEFAULT 0.00,"
                    + "    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                    + ");";

            System.out.println("\n[Step 2] Executing CREATE TABLE SQL statement:");
            System.out.println("-------------------------------------------------------------");
            System.out.println(createTableQuery);
            System.out.println("-------------------------------------------------------------");

            // Step 3: Execute table creation DDL
            statement.executeUpdate(createTableQuery);
            System.out.println("  [+] Table 'student' created successfully (or already exists)!");

            // Step 4: Describe table schema and display column details
            System.out.println("\n[Step 3] Verifying Table Schema ('DESCRIBE student'):");
            System.out.println("+----------------------+----------------------+------+-----+-------------------+----------------+");
            System.out.printf("| %-20s | %-20s | %-4s | %-3s | %-17s | %-14s |\n",
                    "Field", "Type", "Null", "Key", "Default", "Extra");
            System.out.println("+----------------------+----------------------+------+-----+-------------------+----------------+");

            try (ResultSet rs = statement.executeQuery("DESCRIBE student;")) {
                while (rs.next()) {
                    String field = rs.getString("Field");
                    String type = rs.getString("Type");
                    String isNull = rs.getString("Null");
                    String key = rs.getString("Key");
                    String def = rs.getString("Default") == null ? "NULL" : rs.getString("Default");
                    String extra = rs.getString("Extra") == null ? "" : rs.getString("Extra");

                    System.out.printf("| %-20s | %-20s | %-4s | %-3s | %-17s | %-14s |\n",
                            field, type, isNull, key, def, extra);
                }
            }
            System.out.println("+----------------------+----------------------+------+-----+-------------------+----------------+");
            System.out.println("  [SUCCESS] Student table structure verified successfully!");

        } catch (SQLException e) {
            System.err.println("\n[!] SQL Execution Error!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
            System.err.println("\n[Troubleshooting Tips]:");
            System.err.println("  1. Ensure database '" + DB_NAME + "' exists (Run practical_298 first).");
            System.err.println("  2. Verify MySQL credentials and permissions.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 299 execution finished.");
        System.out.println("=============================================================");
    }
}
