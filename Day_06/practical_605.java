package Day_06;

public class practical_605 {
    public static void main(String[] args) {
        String str1 = "radar";
        String str2 = "apple";
        
        System.out.println("--- Using StringBuilder ---");
        System.out.println("\"" + str1 + "\" is palindrome? " + checkPalindromeWithBuilder(str1));
        System.out.println("\"" + str2 + "\" is palindrome? " + checkPalindromeWithBuilder(str2));
        
        System.out.println("\n--- Using StringBuffer ---");
        System.out.println("\"" + str1 + "\" is palindrome? " + checkPalindromeWithBuffer(str1));
        System.out.println("\"" + str2 + "\" is palindrome? " + checkPalindromeWithBuffer(str2));
    }
    
    public static boolean checkPalindromeWithBuilder(String str) {
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }
    
    public static boolean checkPalindromeWithBuffer(String str) {
        StringBuffer sb = new StringBuffer(str);
        String reversed = sb.reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }
}
