package Day_26;

import java.util.Scanner;

// ============================================================================
// Practical 277: Reverse Each Word in a Given Sentence
// Example:
// Input : "Java is very fun"
// Output: "avaJ si yrev nuf"
// ============================================================================

public class practical_277 {

    // Simple method to reverse each word
    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return sentence;
        }

        // Split sentence into words using space
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // Reverse current word using StringBuilder
            String reversedWord = new StringBuilder(word).reverse().toString();
            result.append(reversedWord).append(" ");
        }

        // Remove trailing space and return
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("=== Practical 277: Reverse Each Word in Sentence ===");

        // Test with sample sentence
        String sample = "Java is very fun and easy";
        System.out.println("Original Sentence : " + sample);
        System.out.println("Reversed Words    : " + reverseWords(sample));

        // Interactive Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your own sentence: ");
        String input = scanner.nextLine();

        System.out.println("Output           : " + reverseWords(input));
        scanner.close();
    }
}
