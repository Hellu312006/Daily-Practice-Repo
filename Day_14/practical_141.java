package Day_14;

import java.util.Scanner;

public class practical_141 {

    // Method to count vowels and consonants in a string
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int specialChars = 0;

        String lowerStr = str.toLowerCase();

        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (ch >= '0' && ch <= '9') {
                digits++;
            } else if (!Character.isWhitespace(ch)) {
                specialChars++;
            }
        }

        System.out.println("=== Character Count Result ===");
        System.out.println("Input String:         \"" + str + "\"");
        System.out.println("----------------------------------------");
        System.out.println("Number of Consonants: " + consonants);
        System.out.println("Number of Vowels:     " + vowels);
        System.out.println("Number of Digits:     " + digits);
        System.out.println("Special Characters:   " + specialChars);
    }

    public static void main(String[] args) {
        // Test with a sample string
        String sample = "Hello World! Java Programming 2026";
        countVowelsAndConsonants(sample);

        // Optional: Interactive input via Scanner
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a string: ");
        String userInput = sc.nextLine();
        countVowelsAndConsonants(userInput);
        sc.close();
        */
    }
}
