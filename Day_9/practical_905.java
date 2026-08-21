package Day_9;

import java.util.HashMap;
import java.util.Map;

public class practical_905 {
    
    public static void findDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("String is empty or null.");
            return;
        }

       
        Map<Character, Integer> charCountMap = new HashMap<>();

        
        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Duplicate characters in \"" + str + "\":");
        boolean hasDuplicates = false;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
          
            if (entry.getValue() > 1 && entry.getKey() != ' ') {
                System.out.println("'" + entry.getKey() + "' occurs " + entry.getValue() + " times");
                hasDuplicates = true;
            }
        }

        if (!hasDuplicates) {
            System.out.println("No duplicate characters found.");
        }
    }

    public static void main(String[] args) {
        String testStr = "great responsibility";
        findDuplicates(testStr);
    }
}
