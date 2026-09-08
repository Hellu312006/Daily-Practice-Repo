package Day_19;

// Custom Exception for Validation Errors
@SuppressWarnings("serial")
class UserValidationException extends Exception {
    public UserValidationException(String message) {
        super(message);
    }
}

// Q15: Mini Real-World Validation Program (User Registration)
public class practical_205 {

    // Validates username, email, and password
    static void registerUser(String username, String email, String password, int age) throws UserValidationException {
        // 1. Username check
        if (username == null || username.trim().isEmpty()) {
            throw new UserValidationException("Username cannot be empty!");
        }

        // 2. Email format check
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new UserValidationException("Invalid Email format: '" + email + "'!");
        }

        // 3. Password length check
        if (password == null || password.length() < 6) {
            throw new UserValidationException("Weak Password! Password must be at least 6 characters long.");
        }

        // 4. Age validation
        if (age < 18) {
            throw new UserValidationException("Age Restriction! User must be 18 or older to register (Provided age: " + age + ").");
        }

        System.out.println("Registration Successful! Welcome, " + username + " (Email: " + email + ")");
    }

    public static void main(String[] args) {
        System.out.println("=== Test 1: Valid User Registration ===");
        try {
            registerUser("Rahul", "rahul@example.com", "pass1234", 22);
        } catch (UserValidationException e) {
            System.out.println("Registration Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 2: Invalid Email ===");
        try {
            registerUser("Aman", "aman_invalid_email", "secure999", 20);
        } catch (UserValidationException e) {
            System.out.println("Registration Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 3: Weak Password ===");
        try {
            registerUser("Priya", "priya@gmail.com", "123", 25);
        } catch (UserValidationException e) {
            System.out.println("Registration Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 4: Underage User ===");
        try {
            registerUser("Kunal", "kunal@yahoo.com", "mypassword", 16);
        } catch (UserValidationException e) {
            System.out.println("Registration Error: " + e.getMessage());
        }
    }
}
