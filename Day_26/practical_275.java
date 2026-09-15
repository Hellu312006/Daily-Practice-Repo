package Day_26;

import java.util.Scanner;

// ============================================================================
// Practical 275: Check Palindrome for Strings and Numbers in Java
// Concepts Covered:
// 1. String Palindrome using Two-Pointer Approach (O(N) Time, O(1) Space)
// 2. String Palindrome using StringBuilder (Simple & Built-in)
// 3. Integer/Number Palindrome using Mathematical Operations (% and /)
// 4. Case-insensitive and clean string validation
// ============================================================================

public class practical_275 {

    // Method 1: String Palindrome using Two-Pointer Technique (DSA Optimal)
    public static boolean isStringPalindromeTwoPointer(String text) {
        if (text == null) return false;

        // Clean string: convert to lowercase and consider alphanumeric characters
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method 2: String Palindrome using StringBuilder.reverse()
    public static boolean isStringPalindromeSimple(String text) {
        if (text == null) return false;
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    // Method 3: Number Palindrome using Math (Digit reversal)
    public static boolean isNumberPalindrome(int number) {
        // Negative numbers cannot be palindromes (e.g. -121 != 121-)
        if (number < 0) return false;

        int original = number;
        int reversed = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reversed = (reversed * 10) + lastDigit;
            number = number / 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("  Practical 275: String & Number Palindrome Demonstration in Java ");
        System.out.println("==================================================================\n");

        // Section 1: Automated Test Cases for Strings
        System.out.println("--- 1. String Palindrome Test Cases ---");
        String[] testStrings = { "Madam", "Racecar", "A man, a plan, a canal: Panama", "Java", "noon" };

        for (String str : testStrings) {
            boolean isPalinTwoPointer = isStringPalindromeTwoPointer(str);
            System.out.printf("Text: \"%-32s\" -> Palindrome: %b\n", str, isPalinTwoPointer);
        }

        // Section 2: Automated Test Cases for Numbers
        System.out.println("\n--- 2. Number Palindrome Test Cases ---");
        int[] testNumbers = { 121, 12321, 1001, 12345, -121, 7 };

        for (int num : testNumbers) {
            boolean isPalinNum = isNumberPalindrome(num);
            System.out.printf("Number: %-8d -> Palindrome: %b\n", num, isPalinNum);
        }

        // Section 3: Interactive User Input Demo
        System.out.println("\n--- 3. Interactive Test with Scanner ---");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any word/sentence to check: ");
        String userInput = scanner.nextLine();

        if (isStringPalindromeTwoPointer(userInput)) {
            System.out.println(" Result: \"" + userInput + "\" is a PALINDROME!");
        } else {
            System.out.println(" Result: \"" + userInput + "\" is NOT a palindrome.");
        }

        System.out.print("\nEnter any integer number to check: ");
        if (scanner.hasNextInt()) {
            int userNum = scanner.nextInt();
            if (isNumberPalindrome(userNum)) {
                System.out.println(" Result: " + userNum + " is a PALINDROME number!");
            } else {
                System.out.println(" Result: " + userNum + " is NOT a palindrome number.");
            }
        } else {
            System.out.println("Invalid numeric input.");
        }

        scanner.close();
        System.out.println("\n==================================================================");
        System.out.println("Practical 275 execution completed.");
        System.out.println("==================================================================");
    }
}
