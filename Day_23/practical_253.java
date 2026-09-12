package Day_23;

// Custom Exception Class for Age Validation
@SuppressWarnings("serial")
class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

// Q13: Create and handle custom AgeException
public class practical_253 {

    // Method validating driving license eligibility
    public static void checkDrivingEligibility(String name, int age) throws AgeException {
        System.out.println("Checking eligibility for: " + name + " (Age: " + age + ")");
        if (age < 0) {
            throw new AgeException("Invalid Age: Age cannot be negative (" + age + ") for applicant " + name);
        } else if (age < 18) {
            throw new AgeException("Underage: " + name + " is " + age + " years old. Minimum required age is 18!");
        } else if (age > 75) {
            throw new AgeException("Overage: " + name + " is " + age + " years old. Special medical clearance required for age > 75!");
        } else {
            System.out.println("Status: APPROVED! " + name + " is eligible for a driving license.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Custom AgeException Demonstration ===");

        // Test Case 1: Valid Applicant
        try {
            checkDrivingEligibility("Rahul Sharma", 24);
        } catch (AgeException e) {
            System.out.println("Exception Caught: " + e.getMessage() + "\n");
        }

        // Test Case 2: Underage Applicant
        try {
            checkDrivingEligibility("Aman Gupta", 15);
        } catch (AgeException e) {
            System.out.println("Exception Caught: " + e.getMessage() + "\n");
        }

        // Test Case 3: Overage Applicant
        try {
            checkDrivingEligibility("Shri Ram Lal", 80);
        } catch (AgeException e) {
            System.out.println("Exception Caught: " + e.getMessage() + "\n");
        }

        // Test Case 4: Negative Age
        try {
            checkDrivingEligibility("Invalid User", -5);
        } catch (AgeException e) {
            System.out.println("Exception Caught: " + e.getMessage() + "\n");
        }

        System.out.println("All AgeException tests completed safely.");
    }
}
