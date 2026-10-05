package Day_38;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

// ============================================================================
// Practical 297 / Day 38: Connect Java with MySQL
// Task: Establish a connection between a Java application and MySQL Database
//       using JDBC (Java Database Connectivity) and display connection details.
// ============================================================================

public class practical_297 {

    // Database connection configurations
    // Update USER and PASSWORD according to your local MySQL installation
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = ""; // Empty for server-level connection
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Replace with your MySQL password
    
    // Connection URL with timezone and SSL configuration parameters
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 297: Connect Java with MySQL (JDBC)        ===");
        System.out.println("=============================================================\n");

        System.out.println("[Step 1] Loading MySQL JDBC Driver...");
        try {
            // Modern JDBC (4.0+) automatically discovers drivers, but explicit loading
            // is demonstrated here for educational completeness.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("  -> Driver 'com.mysql.cj.jdbc.Driver' loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("  [!] MySQL JDBC Driver not found!");
            System.err.println("      Please ensure 'mysql-connector-j.jar' is added to your classpath.");
            System.err.println("      Error details: " + e.getMessage());
            return;
        }

        System.out.println("\n[Step 2] Establishing connection to MySQL Server...");
        System.out.println("  -> Host     : " + DB_HOST);
        System.out.println("  -> Port     : " + DB_PORT);
        System.out.println("  -> User     : " + DB_USER);
        System.out.println("  -> JDBC URL : " + DB_URL);

        // Using try-with-resources to ensure the Connection is automatically closed
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            
            if (connection != null && !connection.isClosed()) {
                System.out.println("\n[Step 3] Connection established successfully! [STATUS: CONNECTED]");
                
                // Retrieve and display database metadata
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("\n--- MySQL Server Information ---");
                System.out.println("  * Database Product Name    : " + metaData.getDatabaseProductName());
                System.out.println("  * Database Product Version : " + metaData.getDatabaseProductVersion());
                System.out.println("  * JDBC Driver Name         : " + metaData.getDriverName());
                System.out.println("  * JDBC Driver Version      : " + metaData.getDriverVersion());
                System.out.println("  * Connected User           : " + metaData.getUserName());
                System.out.println("  * Read-Only Status         : " + connection.isReadOnly());
                System.out.println("  * Auto-Commit Mode         : " + connection.getAutoCommit());
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Database connection failed!");
            System.err.println("  * SQL State : " + e.getSQLState());
            System.err.println("  * Error Code: " + e.getErrorCode());
            System.err.println("  * Message   : " + e.getMessage());
            System.err.println("\n[Troubleshooting Tips]:");
            System.err.println("  1. Verify that your MySQL server service is running.");
            System.err.println("  2. Verify your port (default 3306), username, and password.");
            System.err.println("  3. Ensure MySQL allows connections from localhost.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 297 execution finished.");
        System.out.println("=============================================================");
    }
}
