package Day_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ============================================================================
// Practical 311 / Day 38: Comprehensive Student Management System (SMS)
// Task: Build a complete, interactive, menu-driven CRUD application in Java
//       backed by MySQL database using JDBC and PreparedStatements.
//
// Architecture:
//                       Student Management System
//                                   ↓
//             ┌─────────────────────┼─────────────────────┐
//             ↓                     ↓                     ↓
//        1. Insert             2. Search             3. Update
//             ↓                     ↓                     ↓
//        4. Delete             5. Display            6. Statistics
//             └─────────────────────┬─────────────────────┘
//                                   ↓
//                            MySQL Database
// ============================================================================

public class practical_311 {

    // Database connection credentials
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "school_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root"; // Update with your MySQL password

    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // ========================================================================
    // CRUD Operations (Data Access Layer)
    // ========================================================================

    /**
     * 1. INSERT: Adds a new student to the database using PreparedStatement.
     */
    public static void insertStudent(Connection conn, Scanner scanner) {
        System.out.println("\n--- [1] ADD NEW STUDENT ---");
        try {
            System.out.print("Enter Roll Number       : ");
            int rollNo = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter First Name        : ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Enter Last Name         : ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Enter Email Address     : ");
            String email = scanner.nextLine().trim();

            System.out.print("Enter Course Name       : ");
            String course = scanner.nextLine().trim();

            System.out.print("Enter GPA (0.0 to 4.0)  : ");
            double gpa = Double.parseDouble(scanner.nextLine().trim());

            String sql = "INSERT INTO student (roll_number, first_name, last_name, email, course, gpa) "
                       + "VALUES (?, ?, ?, ?, ?, ?);";

            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setInt(1, rollNo);
                pstmt.setString(2, firstName);
                pstmt.setString(3, lastName);
                pstmt.setString(4, email);
                pstmt.setString(5, course);
                pstmt.setDouble(6, gpa);

                int affected = pstmt.executeUpdate();
                if (affected > 0) {
                    try (ResultSet keys = pstmt.getGeneratedKeys()) {
                        long generatedId = keys.next() ? keys.getLong(1) : -1;
                        System.out.println("\n  [SUCCESS] Student enrolled successfully with ID: " + generatedId);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("  [!] Invalid number format. Please enter valid numeric values.");
        } catch (SQLException e) {
            System.err.println("  [!] Database error: " + e.getMessage());
        }
    }

    /**
     * 2. DISPLAY: Lists all students in a formatted tabular ASCII layout.
     */
    public static void displayAllStudents(Connection conn) {
        System.out.println("\n--- [2] ALL ENROLLED STUDENTS ---");
        String sql = "SELECT student_id, roll_number, first_name, last_name, email, course, gpa, enrollment_date "
                   + "FROM student ORDER BY student_id ASC;";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            String line = "+----+---------+----------------------+-----------------------------+-----------------------+------+---------------------+";
            System.out.println(line);
            System.out.printf("| %-2s | %-7s | %-20s | %-27s | %-21s | %-4s | %-19s |\n",
                    "ID", "Roll No", "Full Name", "Email", "Course", "GPA", "Enrollment Date");
            System.out.println(line);

            int count = 0;
            while (rs.next()) {
                int id = rs.getInt("student_id");
                int rollNo = rs.getInt("roll_number");
                String name = rs.getString("first_name") + " " + rs.getString("last_name");
                String email = rs.getString("email");
                String course = rs.getString("course");
                double gpa = rs.getDouble("gpa");
                String enrollDate = rs.getString("enrollment_date");

                System.out.printf("| %-2d | %-7d | %-20s | %-27s | %-21s | %-4.2f | %-19s |\n",
                        id, rollNo, name, email, course, gpa, enrollDate);
                count++;
            }
            System.out.println(line);
            System.out.println("  -> Total Students: " + count);

        } catch (SQLException e) {
            System.err.println("  [!] Database error: " + e.getMessage());
        }
    }

    /**
     * 3. SEARCH: Finds students by Student ID, Roll Number, or Name keyword.
     */
    public static void searchStudent(Connection conn, Scanner scanner) {
        System.out.println("\n--- [3] SEARCH STUDENT ---");
        System.out.println("  [1] Search by Student ID");
        System.out.println("  [2] Search by Roll Number");
        System.out.println("  [3] Search by Name keyword");
        System.out.print("Select search option: ");

        String choice = scanner.nextLine().trim();
        String sql = "";

        try {
            switch (choice) {
                case "1":
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    sql = "SELECT * FROM student WHERE student_id = ?;";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setInt(1, id);
                        printSearchResults(pstmt.executeQuery());
                    }
                    break;

                case "2":
                    System.out.print("Enter Roll Number: ");
                    int roll = Integer.parseInt(scanner.nextLine().trim());
                    sql = "SELECT * FROM student WHERE roll_number = ?;";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setInt(1, roll);
                        printSearchResults(pstmt.executeQuery());
                    }
                    break;

                case "3":
                    System.out.print("Enter Name keyword: ");
                    String kw = scanner.nextLine().trim();
                    sql = "SELECT * FROM student WHERE first_name LIKE ? OR last_name LIKE ?;";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        String pattern = "%" + kw + "%";
                        pstmt.setString(1, pattern);
                        pstmt.setString(2, pattern);
                        printSearchResults(pstmt.executeQuery());
                    }
                    break;

                default:
                    System.out.println("  [-] Invalid search choice.");
            }
        } catch (NumberFormatException e) {
            System.err.println("  [!] Invalid number entered.");
        } catch (SQLException e) {
            System.err.println("  [!] Database error: " + e.getMessage());
        }
    }

    private static void printSearchResults(ResultSet rs) throws SQLException {
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("\n  +------------------------------------------------------------+");
            System.out.println("  |                     MATCHING RECORD                        |");
            System.out.println("  +------------------------------------------------------------+");
            System.out.printf("  | %-18s : %-37d |\n", "Student ID", rs.getInt("student_id"));
            System.out.printf("  | %-18s : %-37d |\n", "Roll Number", rs.getInt("roll_number"));
            System.out.printf("  | %-18s : %-37s |\n", "Full Name", rs.getString("first_name") + " " + rs.getString("last_name"));
            System.out.printf("  | %-18s : %-37s |\n", "Email", rs.getString("email"));
            System.out.printf("  | %-18s : %-37s |\n", "Course", rs.getString("course"));
            System.out.printf("  | %-18s : %-37.2f |\n", "GPA", rs.getDouble("gpa"));
            System.out.printf("  | %-18s : %-37s |\n", "Enrolled Date", rs.getTimestamp("enrollment_date"));
            System.out.println("  +------------------------------------------------------------+");
        }
        if (!found) {
            System.out.println("  [-] No matching student records found.");
        }
    }

    /**
     * 4. UPDATE: Modifies existing student details (Course, Email, or GPA).
     */
    public static void updateStudent(Connection conn, Scanner scanner) {
        System.out.println("\n--- [4] UPDATE STUDENT RECORD ---");
        try {
            System.out.print("Enter Student ID to Update: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            // Check existence
            String checkSql = "SELECT student_id, first_name, last_name, course, email, gpa FROM student WHERE student_id = ?;";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, id);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("  [-] Student ID " + id + " does not exist.");
                        return;
                    }
                    System.out.println("  -> Current: " + rs.getString("first_name") + " " + rs.getString("last_name")
                            + " | Course: " + rs.getString("course") + " | GPA: " + rs.getDouble("gpa"));
                }
            }

            System.out.print("Enter New Course (leave blank to keep unchanged): ");
            String newCourse = scanner.nextLine().trim();

            System.out.print("Enter New Email (leave blank to keep unchanged): ");
            String newEmail = scanner.nextLine().trim();

            System.out.print("Enter New GPA (-1 to keep unchanged): ");
            String gpaInput = scanner.nextLine().trim();
            double newGpa = gpaInput.isEmpty() ? -1 : Double.parseDouble(gpaInput);

            // Build dynamic update query
            String updateSql = "UPDATE student SET "
                    + "course = CASE WHEN ? = '' THEN course ELSE ? END, "
                    + "email = CASE WHEN ? = '' THEN email ELSE ? END, "
                    + "gpa = CASE WHEN ? < 0 THEN gpa ELSE ? END "
                    + "WHERE student_id = ?;";

            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                updateStmt.setString(1, newCourse);
                updateStmt.setString(2, newCourse);
                updateStmt.setString(3, newEmail);
                updateStmt.setString(4, newEmail);
                updateStmt.setDouble(5, newGpa);
                updateStmt.setDouble(6, newGpa);
                updateStmt.setInt(7, id);

                int rows = updateStmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("\n  [SUCCESS] Student record ID " + id + " updated successfully!");
                } else {
                    System.out.println("  [-] No changes applied.");
                }
            }

        } catch (NumberFormatException e) {
            System.err.println("  [!] Invalid numeric input format.");
        } catch (SQLException e) {
            System.err.println("  [!] Database error: " + e.getMessage());
        }
    }

    /**
     * 5. DELETE: Removes a student record by ID with confirmation.
     */
    public static void deleteStudent(Connection conn, Scanner scanner) {
        System.out.println("\n--- [5] DELETE STUDENT RECORD ---");
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Are you sure you want to delete Student ID " + id + "? (yes/no): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (!confirm.equals("yes") && !confirm.equals("y")) {
                System.out.println("  [-] Deletion cancelled.");
                return;
            }

            String deleteSql = "DELETE FROM student WHERE student_id = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
                pstmt.setInt(1, id);
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("  [SUCCESS] Student ID " + id + " deleted successfully.");
                } else {
                    System.out.println("  [-] Student ID " + id + " not found.");
                }
            }

        } catch (NumberFormatException e) {
            System.err.println("  [!] Invalid ID format.");
        } catch (SQLException e) {
            System.err.println("  [!] Database error: " + e.getMessage());
        }
    }

    /**
     * 6. STATISTICS: Displays summary analytics of student records.
     */
    public static void displayStatistics(Connection conn) {
        System.out.println("\n--- [6] SYSTEM ANALYTICS & SUMMARY ---");
        String countSql = "SELECT COUNT(*) AS total, AVG(gpa) AS avg_gpa, MIN(gpa) AS min_gpa, MAX(gpa) AS max_gpa FROM student;";
        String groupSql = "SELECT course, COUNT(*) AS cnt FROM student GROUP BY course ORDER BY cnt DESC;";

        try (Statement stmt = conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(countSql)) {
                if (rs.next()) {
                    System.out.println("  +------------------------------------------------------------+");
                    System.out.printf("  | Total Students       : %-35d |\n", rs.getInt("total"));
                    System.out.printf("  | Overall Average GPA  : %-35.2f |\n", rs.getDouble("avg_gpa"));
                    System.out.printf("  | Highest GPA          : %-35.2f |\n", rs.getDouble("max_gpa"));
                    System.out.printf("  | Lowest GPA           : %-35.2f |\n", rs.getDouble("min_gpa"));
                    System.out.println("  +------------------------------------------------------------+");
                }
            }

            System.out.println("\n  Course Distribution:");
            try (ResultSet rs = stmt.executeQuery(groupSql)) {
                while (rs.next()) {
                    System.out.printf("    - %-25s : %d student(s)\n", rs.getString("course"), rs.getInt("cnt"));
                }
            }

        } catch (SQLException e) {
            System.err.println("  [!] Database error: " + e.getMessage());
        }
    }

    // ========================================================================
    // Main Entry Point & Interactive Menu Loop
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("===     🎓 STUDENT MANAGEMENT SYSTEM (Java + MySQL)       ===");
        System.out.println("=============================================================\n");

        System.out.println("Connecting to MySQL Database: '" + DB_NAME + "'...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("[+] Connected to database successfully!\n");

            boolean running = true;
            while (running) {
                System.out.println("\n=============================================================");
                System.out.println("                   STUDENT MANAGEMENT MENU                   ");
                System.out.println("=============================================================");
                System.out.println("  [1] ➕ Add New Student (Insert)");
                System.out.println("  [2] 📋 View All Students (Display)");
                System.out.println("  [3] 🔍 Search Student (Search)");
                System.out.println("  [4] ✏️  Update Student Record (Update)");
                System.out.println("  [5] 🗑️  Delete Student Record (Delete)");
                System.out.println("  [6] 📊 View Summary Statistics");
                System.out.println("  [7] 🚪 Exit System");
                System.out.println("=============================================================");
                System.out.print("Enter your choice (1-7): ");

                String input = scanner.hasNextLine() ? scanner.nextLine().trim() : "7";

                switch (input) {
                    case "1":
                        insertStudent(connection, scanner);
                        break;
                    case "2":
                        displayAllStudents(connection);
                        break;
                    case "3":
                        searchStudent(connection, scanner);
                        break;
                    case "4":
                        updateStudent(connection, scanner);
                        break;
                    case "5":
                        deleteStudent(connection, scanner);
                        break;
                    case "6":
                        displayStatistics(connection);
                        break;
                    case "7":
                        System.out.println("\nExiting Student Management System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("[-] Invalid choice. Please enter a number between 1 and 7.");
                }
            }

        } catch (SQLException e) {
            System.err.println("\n[!] Connection Error: " + e.getMessage());
            System.err.println("    Please ensure MySQL server is running and 'school_db' exists.");
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 311 execution finished.");
        System.out.println("=============================================================");
    }
}
