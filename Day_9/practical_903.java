package Day_9;

public class practical_903 {
    
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        
        
        String cleanStr = str.toLowerCase();
        int left = 0;
        int right = cleanStr.length() - 1;
        
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "radar";
        String str2 = "hello";

        System.out.println("Testing Palindrome Program:");
        System.out.println("----------------------------------------");
        System.out.println("\"" + str1 + "\" is palindrome: " + isPalindrome(str1));
        System.out.println("\"" + str2 + "\" is palindrome: " + isPalindrome(str2));
    }
}
