package Day_1;

public class practical_20 {
    public static void main(String[] args) {
        int number = 570;
        int original = number;
        int sum = 0;
        while(number >0){
            int digit = number %10;
            sum = sum + (digit * digit * digit);
            number = number / 10;
            
        }
        if (sum == original) {
            System.out.println(original + " is an Armstrong number.");
        } else {
            System.out.println(original + " is not an Armstrong number.");
        }
    }
    
}
