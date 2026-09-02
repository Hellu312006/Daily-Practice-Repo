package Day_14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class practical_146 {

    // Method to check if a character is a consonant
    public static boolean isConsonant(char ch) {
        // Convert to lowercase for uniform check
        ch = Character.toLowerCase(ch);

        // A consonant is an alphabet character (a-z) that is NOT a vowel
        return (ch >= 'a' && ch <= 'z') && 
               !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    // Method to count total and breakdown of consonants
    public static void countConsonants(String str) {
        int totalConsonants = 0;
        Map<Character, Integer> consonantFrequency = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isConsonant(ch)) {
                totalConsonants++;
                char lowerCh = Character.toLowerCase(ch);
                consonantFrequency.put(lowerCh, consonantFrequency.getOrDefault(lowerCh, 0) + 1);
            }
        }

        System.out.println("=== Consonant Count Summary ===");
        System.out.println("Original String: \"" + str + "\"");
        System.out.println("----------------------------------------");
        System.out.println("Total Consonants: " + totalConsonants);
        System.out.println("----------------------------------------");
        System.out.println("Consonant Breakdown (Frequency):");
        
        if (consonantFrequency.isEmpty()) {
            System.out.println("  None found.");
        } else {
            for (Map.Entry<Character, Integer> entry : consonantFrequency.entrySet()) {
                System.out.println("  '" + entry.getKey() + "' : " + entry.getValue() + " time(s)");
            }
        }
        System.out.println();
    }

    // Quick method to return total consonant count
    public static int getConsonantCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isConsonant(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        countConsonants("Java Programming Language");

        // Test Case 2
        String sample2 = "Antigravity AI 2026";
        System.out.println("Quick count for \"" + sample2 + "\": " + getConsonantCount(sample2) + " consonants");

        // Optional: Interactive input from User
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your text: ");
        String userInput = sc.nextLine();
        countConsonants(userInput);
        sc.close();
        */
    }
}
