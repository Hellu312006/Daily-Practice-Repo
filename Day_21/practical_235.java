package Day_21;

import java.util.ArrayList;

// Custom Exception for Student Not Found
@SuppressWarnings("serial")
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Marks
@SuppressWarnings("serial")
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

// Student Entity
class StudentProfile {
    private int id;
    private String name;
    private double marks;

    public StudentProfile(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks + "%";
    }
}

// Q15: Mini Real-World Project: Student Registry with ArrayList & Exception Handling
public class practical_235 {
    private ArrayList<StudentProfile> registry = new ArrayList<>();

    // Add Student with validation
    public void addStudent(int id, String name, double marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Invalid Marks (" + marks + ")! Marks must be between 0 and 100.");
        }
        registry.add(new StudentProfile(id, name, marks));
        System.out.println("Enrolled: " + name + " (ID: " + id + ")");
    }

    // Search Student by ID
    public StudentProfile searchStudent(int id) throws StudentNotFoundException {
        for (StudentProfile s : registry) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found in registry!");
    }

    // Display All Students
    public void displayAll() {
        System.out.println("\n=== All Enrolled Students ===");
        for (StudentProfile s : registry) {
            System.out.println(s);
        }
    }

    // Calculate Class Average
    public double calculateAverage() {
        if (registry.isEmpty()) return 0.0;
        double sum = 0;
        for (StudentProfile s : registry) sum += s.getMarks();
        return sum / registry.size();
    }

    public static void main(String[] args) {
        practical_235 system = new practical_235();

        System.out.println("=== Student Registry System Demo ===");

        // 1. Adding Students
        try {
            system.addStudent(101, "Rahul Sharma", 88.5);
            system.addStudent(102, "Priya Verma", 94.0);
            system.addStudent(103, "Aman Gupta", 76.0);
            // This will throw InvalidMarksException
            system.addStudent(104, "Invalid User", 125.0);
        } catch (InvalidMarksException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }

        // 2. Display All
        system.displayAll();

        // 3. Search Students
        System.out.println("\n=== Searching Students ===");
        try {
            StudentProfile found = system.searchStudent(102);
            System.out.println("Search Result: " + found);

            // This will throw StudentNotFoundException
            system.searchStudent(999);
        } catch (StudentNotFoundException e) {
            System.out.println("Search Error: " + e.getMessage());
        }

        // 4. Class Statistics
        System.out.println("\nClass Average Marks: " + String.format("%.2f", system.calculateAverage()) + "%");
    }
}
