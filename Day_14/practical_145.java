package Day_14;

import java.util.Scanner;

public class practical_145 {

    // Method to count total and individual vowels
    public static void countVowels(String str) {
        int totalVowels = 0;
        int countA = 0, countE = 0, countI = 0, countO = 0, countU = 0;

        String lowerStr = str.toLowerCase();

        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);

            switch (ch) {
                case 'a':
                    countA++;
                    totalVowels++;
                    break;
                case 'e':
                    countE++;
                    totalVowels++;
                    break;
                case 'i':
                    countI++;
                    totalVowels++;
                    break;
                case 'o':
                    countO++;
                    totalVowels++;
                    break;
                case 'u':
                    countU++;
                    totalVowels++;
                    break;
                default:
                    // Not a vowel, continue
                    break;
            }
        }

        System.out.println("=== Vowel Count Summary ===");
        System.out.println("Original String: \"" + str + "\"");
        System.out.println("----------------------------------------");
        System.out.println("Total Vowels Found: " + totalVowels);
        System.out.println("----------------------------------------");
        System.out.println("Breakdown:");
        System.out.println("  'a' / 'A' : " + countA);
        System.out.println("  'e' / 'E' : " + countE);
        System.out.println("  'i' / 'I' : " + countI);
        System.out.println("  'o' / 'O' : " + countO);
        System.out.println("  'u' / 'U' : " + countU);
        System.out.println();
    }

    // Alternative Approach: Using String.indexOf() (Short & Concise)
    public static int countTotalVowelsQuick(String str) {
        String vowels = "aeiouAEIOU";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard sentence
        countVowels("Antigravity Artificial Intelligence");

        // Test Case 2: Quick count check
        String test2 = "Java Programming";
        System.out.println("Quick count for \"" + test2 + "\": " + countTotalVowelsQuick(test2) + " vowels");

        // Optional: Interactive input from User
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your custom string: ");
        String userInput = sc.nextLine();
        countVowels(userInput);
        sc.close();
        */
    }
}
