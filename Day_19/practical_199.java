package Day_19;

// Custom Exception for Age Validation
@SuppressWarnings("serial")
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Q9: User Age Validation using Custom Exception
public class practical_199 {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // throw keyword se custom exception trigger kiya
            throw new InvalidAgeException("Age " + age + " is invalid! Voting ke liye minimum age 18 honi chahiye.");
        } else {
            System.out.println("Age " + age + " is valid: Welcome! Aap vote dene ke liye eligible hain.");
        }
    }

    public static void main(String[] args) {
        int userAge1 = 21;
        int userAge2 = 15;

        // Test 1: Valid Age
        try {
            System.out.println("Validating User 1 (Age: " + userAge1 + "):");
            validateAge(userAge1);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println();

        // Test 2: Invalid Age
        try {
            System.out.println("Validating User 2 (Age: " + userAge2 + "):");
            validateAge(userAge2);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
