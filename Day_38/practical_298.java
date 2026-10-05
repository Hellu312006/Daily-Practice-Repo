package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ============================================================================
// Practical 298 / Day 38: Create a Database Using MySQL
// Task: Connect to MySQL server and execute a DDL (Data Definition Language)
//       query to create a new database dynamically using JDBC Statement.
// ============================================================================

public class practical_298 {

    // Database server configuration (connecting to server root level)
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password
    
    // Target database to create
    private static final String TARGET_DATABASE = "school_db";

    private static final String SERVER_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 298: Create a Database Using MySQL (JDBC)   ===");
        System.out.println("=============================================================\n");

        System.out.println("[Step 1] Connecting to MySQL Server...");
        
        // Try-with-resources automatically closes both Connection and Statement
        try (Connection connection = DriverManager.getConnection(SERVER_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            System.out.println("  -> Successfully connected to MySQL Server.");

            // Step 2: Formulate the SQL DDL command
            String createDbQuery = "CREATE DATABASE IF NOT EXISTS " + TARGET_DATABASE + ";";
            System.out.println("\n[Step 2] Executing SQL Query:");
            System.out.println("  -> SQL: " + createDbQuery);

            // Step 3: Execute query using executeUpdate()
            // executeUpdate() is used for DDL statements (CREATE, DROP, ALTER) and DML (INSERT, UPDATE, DELETE)
            int result = statement.executeUpdate(createDbQuery);
            System.out.println("  -> Query executed successfully. Return value: " + result);
            System.out.println("  [+] Database '" + TARGET_DATABASE + "' created or already exists!");

            // Step 4: Verify that the database exists by listing databases
            System.out.println("\n[Step 3] Verifying database list on server:");
            try (ResultSet resultSet = statement.executeQuery("SHOW DATABASES;")) {
                boolean found = false;
                while (resultSet.next()) {
                    String dbName = resultSet.getString(1);
                    if (TARGET_DATABASE.equalsIgnoreCase(dbName)) {
                        System.out.println("  [*] " + dbName + "  <-- (Target Database Verified)");
                        found = true;
                    } else {
                        System.out.println("      - " + dbName);
                    }
                }
                if (found) {
                    System.out.println("\n  [SUCCESS] Database '" + TARGET_DATABASE + "' confirmed on server!");
                }
            }

        } catch (SQLException e) {
            System.err.println("\n[!] SQL Operation Failed!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
            System.err.println("\n[Troubleshooting Tips]:");
            System.err.println("  1. Verify MySQL server is active.");
            System.err.println("  2. Check user privileges for CREATE DATABASE permission.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 298 execution finished.");
        System.out.println("=============================================================");
    }
}
