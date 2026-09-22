package Day_33;

// ============================================================================
// Practical 236 / Day 33: Simple Palindrome Check in Java
// A Palindrome is a number or word that reads the same backward as forward.
// Examples:
// Numbers : 121 -> Palindrome, 123 -> Not Palindrome
// Words   : "madam" -> Palindrome, "hello" -> Not Palindrome
// ============================================================================

public class practical_236 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 236: Palindrome Checker (Number & String) ===");
        System.out.println("=============================================================\n");

        // --------------------------------------------------------------------
        // 1. Check Palindrome for Numbers
        // --------------------------------------------------------------------
        System.out.println("--- 1. Number Palindrome Check ---");
        int[] numbers = { 121, 12321, 123, -121, 4554 };

        for (int num : numbers) {
            boolean isPal = isNumberPalindrome(num);
            System.out.println("Number: " + num + " -> " + (isPal ? "Palindrome" : "Not a Palindrome"));
        }

        // --------------------------------------------------------------------
        // 2. Check Palindrome for Strings
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. String Palindrome Check ---");
        String[] words = { "madam", "radar", "hello", "racecar", "Java" };

        for (String word : words) {
            boolean isPal = isStringPalindrome(word);
            System.out.println("Word  : \"" + word + "\" -> " + (isPal ? "Palindrome" : "Not a Palindrome"));
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 236 executed successfully!");
        System.out.println("=============================================================");
    }

    // ------------------------------------------------------------------------
    // Simple Method 1: Check if a number is Palindrome
    // ------------------------------------------------------------------------
    public static boolean isNumberPalindrome(int num) {
        // Negative numbers are not palindromes (e.g., -121 != 121-)
        if (num < 0) return false;

        int original = num;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = (reversed * 10) + digit;
            num /= 10;
        }

        return original == reversed;
    }

    // ------------------------------------------------------------------------
    // Simple Method 2: Check if a string is Palindrome (Two-Pointer)
    // ------------------------------------------------------------------------
    public static boolean isStringPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }
        return true;
    }
}
