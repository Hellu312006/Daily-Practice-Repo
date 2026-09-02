package Day_14;

import java.util.Arrays;

public class practical_144 {

    // Approach 1: Using Sorting (O(N log N))
    public static boolean isAnagramSorting(String str1, String str2) {
        // Remove whitespace and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Sort both character arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    // Approach 2: Using Frequency Counting Array (O(N) - Most Optimal)
    public static boolean isAnagramCounting(String str1, String str2) {
        // Remove whitespace and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charCounts = new int[256]; // ASCII character array

        for (int i = 0; i < str1.length(); i++) {
            charCounts[str1.charAt(i)]++;
            charCounts[str2.charAt(i)]--;
        }

        // Check if all counts returned to 0
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void testAnagram(String s1, String s2) {
        System.out.println("String 1: \"" + s1 + "\"");
        System.out.println("String 2: \"" + s2 + "\"");

        boolean resultSorting = isAnagramSorting(s1, s2);
        boolean resultCounting = isAnagramCounting(s1, s2);

        System.out.println("Result (Sorting Approach):   " + (resultSorting ? "YES (Anagram)" : "NO (Not Anagram)"));
        System.out.println("Result (Counting Approach):  " + (resultCounting ? "YES (Anagram)" : "NO (Not Anagram)"));
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Anagram Check Demonstration ===\n");

        // Test Case 1: Valid Anagram
        testAnagram("Listen", "Silent");

        // Test Case 2: Valid Anagram with spaces & mixed case
        testAnagram("Debit Card", "Bad Credit");

        // Test Case 3: Not an Anagram
        testAnagram("Hello", "World");
    }
}
