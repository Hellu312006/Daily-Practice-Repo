package Day_14;

import java.util.HashMap;
import java.util.Map;

public class practical_142 {

    // Approach 1: Using HashMap (Recommended for all characters)
    public static void findFrequencyUsingHashMap(String str) {
        System.out.println("--- Character Frequency using HashMap ---");
        
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            // If character already exists, increment count; otherwise initialize to 1
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Display results
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getKey() == ' ') {
                System.out.println("' ' (space) : " + entry.getValue());
            } else {
                System.out.println("'" + entry.getKey() + "'         : " + entry.getValue());
            }
        }
    }

    // Approach 2: Using an ASCII Frequency Array (Fast & Simple)
    public static void findFrequencyUsingArray(String str) {
        System.out.println("\n--- Character Frequency using ASCII Array ---");
        
        int[] freq = new int[256]; // Array to hold counts for ASCII characters

        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        // Print frequency of characters present in the string
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                if ((char) i == ' ') {
                    System.out.println("' ' (space) : " + freq[i]);
                } else {
                    System.out.println("'" + (char) i + "'         : " + freq[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String input = "Java Programming";

        System.out.println("Original String: \"" + input + "\"\n");

        // Calling Approach 1
        findFrequencyUsingHashMap(input);

        // Calling Approach 2
        findFrequencyUsingArray(input);
    }
}
