package Day_23;

import java.io.IOException;

// Q8: Declare exceptions in method signature using the 'throws' keyword
public class practical_248 {

    // Method declaring that it may throw ArithmeticException
    public static int computeDivision(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not permitted in computeDivision().");
        }
        return a / b;
    }

    // Method declaring that it may throw checked IOException
    public static void checkFileStatus(String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new IOException("File name cannot be null or empty.");
        }
        System.out.println("Accessing file: " + filename);
    }

    public static void main(String[] args) {
        System.out.println("=== Method Declaration with 'throws' Demo ===");

        // Test 1: Calling computeDivision() which declares 'throws ArithmeticException'
        try {
            System.out.println("\n--- Test 1: Valid Division ---");
            int res1 = computeDivision(40, 5);
            System.out.println("Result: " + res1);

            System.out.println("\n--- Test 2: Invalid Division ---");
            int res2 = computeDivision(40, 0);
            System.out.println("Result: " + res2);
        } catch (ArithmeticException e) {
            System.out.println("Caller caught exception from computeDivision(): " + e.getMessage());
        }

        // Test 2: Calling checkFileStatus() which declares 'throws IOException'
        try {
            System.out.println("\n--- Test 3: File check with invalid name ---");
            checkFileStatus("");
        } catch (IOException e) {
            System.out.println("Caller caught checked exception from checkFileStatus(): " + e.getMessage());
        }

        System.out.println("\nMethod calls with throws keyword completed safely.");
    }
}
