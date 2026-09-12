package Day_23;

// Custom Exception Class for Marks Validation
@SuppressWarnings("serial")
class MarksException extends Exception {
    public MarksException(String message) {
        super(message);
    }
}

// Q14: Create and handle custom MarksException
public class practical_254 {

    // Method to validate semester exam marks
    public static void validateMarks(String studentName, double marks) throws MarksException {
        System.out.println("Evaluating Marks for: " + studentName + " (Score: " + marks + "/100)");

        if (marks < 0) {
            throw new MarksException("Invalid Marks: Marks cannot be negative (" + marks + ") for " + studentName);
        } else if (marks > 100) {
            throw new MarksException("Out of Range: Marks cannot exceed 100 (" + marks + ") for " + studentName);
        } else if (marks < 35) {
            throw new MarksException("Failed: " + studentName + " scored " + marks + ", below passing mark of 35!");
        } else {
            System.out.println("Result: PASSED! " + studentName + " scored " + marks + " / 100.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Custom MarksException Demonstration ===");

        // Test 1: Valid Passing Marks
        try {
            validateMarks("Priya Patel", 88.5);
        } catch (MarksException e) {
            System.out.println("Exception Caught: " + e.getMessage() + "\n");
        }

        // Test 2: Failing Marks
        try {
            validateMarks("Vikas Mehra", 28.0);
        } catch (MarksException e) {
            System.out.println("Exception Caught: " + e.getMessage() + "\n");
        }

        // Test 3: Marks greater than 100
        try {
            validateMarks("Sneha Roy", 105.0);
        } catch (MarksException e) {
            System.out.println("Exception Caught: " + e.getMessage() + "\n");
        }

        // Test 4: Negative Marks
        try {
            validateMarks("Rohan Joshi", -10.0);
        } catch (MarksException e) {
            System.out.println("Exception Caught: " + e.getMessage() + "\n");
        }

        System.out.println("All MarksException tests completed successfully.");
    }
}
