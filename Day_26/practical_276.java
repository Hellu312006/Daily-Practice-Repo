package Day_26;

import java.util.Scanner;

// ============================================================================
// Practical 276: Demonstrate substring() Method & Substring Operations in Java
// Concepts Covered:
// 1. substring(int beginIndex) - From beginIndex to end of string
// 2. substring(int beginIndex, int endIndex) - From beginIndex to (endIndex - 1)
// 3. StringIndexOutOfBoundsException handling with invalid indices
// 4. Practical use cases:
//    - Extract domain from email
//    - Extract file extension from filename
//    - Generating all substrings of a string
// 5. Custom substring implementation logic
// ============================================================================

public class practical_276 {

    // Custom implementation of substring to understand internal logic
    public static String customSubstring(String str, int start, int end) {
        if (str == null) {
            throw new NullPointerException("Input string cannot be null");
        }
        if (start < 0 || end > str.length() || start > end) {
            throw new StringIndexOutOfBoundsException(
                "Invalid indices: start=" + start + ", end=" + end + ", length=" + str.length()
            );
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Use Case 1: Extract domain name from email
    public static String extractEmailDomain(String email) {
        int atIndex = email.indexOf('@');
        if (atIndex != -1 && atIndex < email.length() - 1) {
            return email.substring(atIndex + 1);
        }
        return "Invalid email";
    }

    // Use Case 2: Extract file extension
    public static String extractFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex + 1);
        }
        return "No extension found";
    }

    // Use Case 3: Generate all possible substrings of a string
    public static void printAllSubstrings(String str) {
        System.out.println("All substrings of \"" + str + "\":");
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.print("\"" + str.substring(i, j) + "\" ");
                count++;
            }
        }
        System.out.println("\nTotal substrings generated: " + count);
    }

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("     Practical 276: Java String substring() Demonstration        ");
        System.out.println("==================================================================\n");

        String sample = "JavaProgramming";
        System.out.println("Original String: \"" + sample + "\" (Length: " + sample.length() + ")");
        System.out.println("Indices:          012345678901234\n");

        // 1. substring(beginIndex)
        System.out.println("--- 1. substring(int beginIndex) ---");
        System.out.println("sample.substring(4)    -> \"" + sample.substring(4) + "\"");
        System.out.println("sample.substring(0)    -> \"" + sample.substring(0) + "\"");

        // 2. substring(beginIndex, endIndex)
        System.out.println("\n--- 2. substring(int beginIndex, int endIndex) ---");
        System.out.println("sample.substring(0, 4) -> \"" + sample.substring(0, 4) + "\"  (Index 0 to 3)");
        System.out.println("sample.substring(4, 11)-> \"" + sample.substring(4, 11) + "\" (Index 4 to 10)");

        // 3. Exception Handling with invalid indices
        System.out.println("\n--- 3. Handling StringIndexOutOfBoundsException ---");
        try {
            System.out.println("Attempting sample.substring(5, 25)...");
            sample.substring(5, 25);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("[Caught Exception]: " + e.getMessage());
        }

        try {
            System.out.println("Attempting sample.substring(8, 3)...");
            sample.substring(8, 3);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("[Caught Exception]: " + e.getMessage());
        }

        // 4. Practical Real-World Use Cases
        System.out.println("\n--- 4. Real-World Applications ---");
        String email = "student123@charusat.edu.in";
        System.out.println("Email: " + email);
        System.out.println("Extracted Domain: " + extractEmailDomain(email));

        String file = "practical_276.java";
        System.out.println("File Name: " + file);
        System.out.println("Extracted Extension: " + extractFileExtension(file));

        // 5. Custom Substring Implementation Verification
        System.out.println("\n--- 5. Custom Substring Method Test ---");
        String customRes = customSubstring("Developer", 0, 3);
        System.out.println("customSubstring(\"Developer\", 0, 3) -> \"" + customRes + "\"");

        // 6. Substring Combinations
        System.out.println("\n--- 6. Generating All Substrings ---");
        printAllSubstrings("JAVA");

        // 7. Interactive Scanner Demo
        System.out.println("\n--- 7. Interactive Scanner Input Demo ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        if (userInput.length() >= 3) {
            System.out.println("First 3 characters : \"" + userInput.substring(0, 3) + "\"");
            System.out.println("Remaining characters: \"" + userInput.substring(3) + "\"");
        } else {
            System.out.println("String length is less than 3: \"" + userInput + "\"");
        }

        scanner.close();
        System.out.println("\n==================================================================");
        System.out.println("Practical 276 execution completed.");
        System.out.println("==================================================================");
    }
}
