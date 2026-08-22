package Day_09;

import java.util.Arrays;

public class practical_906 {
    
    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        
        String cleanStr1 = str1.replaceAll("\\s", "").toLowerCase();
        String cleanStr2 = str2.replaceAll("\\s", "").toLowerCase();

       
        if (cleanStr1.length() != cleanStr2.length()) {
            return false;
        }

       
        char[] charArray1 = cleanStr1.toCharArray();
        char[] charArray2 = cleanStr2.toCharArray();

        
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        String s3 = "hello";
        String s4 = "world";

        System.out.println("Anagram Verification:");
        System.out.println("----------------------------------------");
        System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are anagrams: " + isAnagram(s1, s2));
        System.out.println("\"" + s3 + "\" and \"" + s4 + "\" are anagrams: " + isAnagram(s3, s4));
    }
}
