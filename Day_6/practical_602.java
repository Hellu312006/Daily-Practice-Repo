package Day_6;

public class practical_602 {
    public static void main(String[] args) {
        String str = "harshu";
        String reversed = "";
        
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);
    }
}
