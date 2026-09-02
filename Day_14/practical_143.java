package Day_14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class practical_143 {

    // Approach 1: Using HashMap (Prints duplicate characters with their counts)
    public static void findDuplicatesWithCount(String str) {
        System.out.println("=== Duplicate Characters with Counts (Using HashMap) ===");
        
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        boolean found = false;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1 && entry.getKey() != ' ') {
                System.out.println("'" + entry.getKey() + "' appears " + entry.getValue() + " times");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No duplicate characters found.");
        }
    }

    // Approach 2: Using HashSet (Quick check for duplicate characters)
    public static void findDuplicatesUsingSet(String str) {
        System.out.println("\n=== Duplicate Characters Found (Using HashSet) ===");

        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (ch != ' ') {
                // If already in 'seen' set, add to 'duplicates' set
                if (!seen.add(ch)) {
                    duplicates.add(ch);
                }
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicate characters found.");
        } else {
            System.out.println("Duplicate characters: " + duplicates);
        }
    }

    public static void main(String[] args) {
        String input = "Great responsibility";

        System.out.println("Original String: \"" + input + "\"\n");

        // Approach 1: Using HashMap
        findDuplicatesWithCount(input);

        // Approach 2: Using HashSet
        findDuplicatesUsingSet(input);
    }
}
