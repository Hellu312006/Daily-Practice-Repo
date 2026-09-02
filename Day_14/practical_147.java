package Day_14;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class practical_147 {

    // 1. Method to count frequency of each WORD in a given string
    public static void countWordFrequency(String sentence) {
        System.out.println("=== 1. Word Frequency in a Sentence ===");
        System.out.println("Input Sentence: \"" + sentence + "\"");

        // Split sentence into words (handles multiple spaces and ignores punctuation)
        String cleanSentence = sentence.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = cleanSentence.split("\\s+");

        // Using LinkedHashMap to maintain insertion order
        Map<String, Integer> wordCountMap = new LinkedHashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("\nWord Frequencies:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.printf("  %-12s : %d time(s)%n", "\"" + entry.getKey() + "\"", entry.getValue());
        }
        System.out.println();
    }

    // 2. Method to count frequency of each ELEMENT in an Array
    public static void countArrayElementFrequency(int[] numbers) {
        System.out.println("=== 2. Number Frequency in an Array ===");
        System.out.print("Input Array: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + (i < numbers.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : numbers) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("\nElement Frequencies:");
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            System.out.printf("  Element %-4d : %d time(s)%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Word Frequency
        String sampleText = "Java is powerful, Java is versatile, and Java is fast!";
        countWordFrequency(sampleText);

        // Test Case 2: Array Element Frequency
        int[] sampleArray = {10, 20, 10, 30, 40, 20, 10, 50, 40, 10};
        countArrayElementFrequency(sampleArray);
    }
}
