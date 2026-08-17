package Day_6;

public class practical_603 {
    public static void main(String[] args) {
        String str = "hello world";
        int[] freq = new int[256];
        
    
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        
        System.out.println("Character | Frequency");
        System.out.println("---------------------");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch] > 0) {
                System.out.println("    " + ch + "     |    " + freq[ch]);
                freq[ch] = 0; 
            }
        }
    }
}
