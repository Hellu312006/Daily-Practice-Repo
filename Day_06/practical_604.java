package Day_06;

import java.util.Arrays;

public class practical_604 {
    public static void main(String[] args) {
        String str1 = "Listen";
        String str2 = "Silent";
        
        boolean isAnagram = checkAnagram(str1, str2);
        
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        if (isAnagram) {
            System.out.println("Result: The strings are anagrams.");
        } else {
            System.out.println("Result: The strings are not anagrams.");
        }
    }
    
    public static boolean checkAnagram(String str1, String str2) {
        
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
}
