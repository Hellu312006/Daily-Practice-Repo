package Day_33;

import java.math.BigInteger;
import java.util.stream.LongStream;

// ============================================================================
// Practical 235 / Day 33: Program to Find Factorial of a Number in Java
// Example:
// Input  : 5
// Output : 120 (5 * 4 * 3 * 2 * 1 = 120)
//
// Covers:
// 1. Iterative Approach (Using for loop) - O(N) Time, O(1) Space
// 2. Recursive Approach - O(N) Time, O(N) Call Stack Space
// 3. Java 8 Streams Approach - Functional Style
// 4. BigInteger Approach (For handling very large numbers beyond 20!)
// 5. Step-by-step Multiplication Breakdown
// ============================================================================

public class practical_235 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 235: Factorial of a Number in Java ===");
        System.out.println("=============================================================\n");

        int input = 5;

        // --------------------------------------------------------------------
        // 1. Primary Problem Demonstration with Input: 5 -> Output: 120
        // --------------------------------------------------------------------
        System.out.println("--- Problem Statement Demo ---");
        System.out.println("Input  : " + input);
        System.out.println("Output : " + factorialIterative(input));
        System.out.println("Trace  : " + getFactorialExpression(input) + " = " + factorialIterative(input));
        System.out.println();

        // --------------------------------------------------------------------
        // 2. Comparing Multiple Methods
        // --------------------------------------------------------------------
        System.out.println("-------------------------------------------------------------");
        System.out.println("PART 1: COMPARISON OF APPROACHES (Input: " + input + ")");
        System.out.println("-------------------------------------------------------------");

        long iterResult = factorialIterative(input);
        long recurResult = factorialRecursive(input);
        long streamResult = factorialStream(input);
        BigInteger bigIntResult = factorialBigInteger(input);

        System.out.println("1. Iterative Method (Loop)   : " + iterResult);
        System.out.println("2. Recursive Method          : " + recurResult);
        System.out.println("3. Java 8 Stream Method      : " + streamResult);
        System.out.println("4. BigInteger Method         : " + bigIntResult);
        System.out.println();

        // --------------------------------------------------------------------
        // 3. Testing with Various Test Cases (Edge Cases & Large Numbers)
        // --------------------------------------------------------------------
        System.out.println("-------------------------------------------------------------");
        System.out.println("PART 2: TEST CASES (0!, 1!, 7!, 12!, 20!, 30!)");
        System.out.println("-------------------------------------------------------------");
        int[] testCases = { 0, 1, 3, 7, 10, 15, 20 };

        for (int n : testCases) {
            System.out.printf("%2d! = %-22d [%s]\n", n, factorialIterative(n), getFactorialExpression(n));
        }

        // --------------------------------------------------------------------
        // 4. Large Factorials with BigInteger (Handling integer overflow)
        // Note: Standard 'long' overflows after 20!
        // --------------------------------------------------------------------
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("PART 3: LARGE FACTORIALS (Handling 64-bit Overflow)");
        System.out.println("-------------------------------------------------------------");
        int largeNumber = 35;
        System.out.println(largeNumber + "! using BigInteger:");
        System.out.println(factorialBigInteger(largeNumber));

        System.out.println("\n=============================================================");
        System.out.println("Practical 235 executed successfully!");
        System.out.println("=============================================================");
    }

    // ------------------------------------------------------------------------
    // Method 1: Iterative Approach (for-loop)
    // ------------------------------------------------------------------------
    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // ------------------------------------------------------------------------
    // Method 2: Recursive Approach
    // ------------------------------------------------------------------------
    public static long factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    // ------------------------------------------------------------------------
    // Method 3: Java 8 Stream Approach
    // ------------------------------------------------------------------------
    public static long factorialStream(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) return 1;
        return LongStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }

    // ------------------------------------------------------------------------
    // Method 4: BigInteger Approach (Arbitrary Precision)
    // ------------------------------------------------------------------------
    public static BigInteger factorialBigInteger(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // ------------------------------------------------------------------------
    // Helper: Formats the multiplication string (e.g., "5 * 4 * 3 * 2 * 1")
    // ------------------------------------------------------------------------
    public static String getFactorialExpression(int n) {
        if (n <= 1) return "1";
        if (n > 8) return n + " * " + (n - 1) + " * ... * 1";

        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            sb.append(i);
            if (i > 1) {
                sb.append(" * ");
            }
        }
        return sb.toString();
    }
}
