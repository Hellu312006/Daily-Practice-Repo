package Day_9;

public class practical_901 {
    public static String reverseWithStringBuilder(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseWithTwoPointers(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        
        while (left < right) {
            
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
    
    public static String reverseIterative(String str) {
        if (str == null) {
            return null;
        }
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    public static void main(String[] args) {
        String str = "Hely";

        System.out.println("Original String: " + str);
        System.out.println("----------------------------------------");
        System.out.println("Reverse (StringBuilder): " + reverseWithStringBuilder(str));
        System.out.println("Reverse (Two Pointers):  " + reverseWithTwoPointers(str));
        System.out.println("Reverse (Iterative):     " + reverseIterative(str));
    }
}
