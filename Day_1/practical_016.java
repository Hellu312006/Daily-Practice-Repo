package Day_1;

public class practical_016 {
    public static void main(String[] args) {
        
    
 int number = 10;
    long factorial = 1;

    for(int i = 1; i <= number; i++) {
        factorial = factorial * i;
    }
    System.out.println("factorial of " + number + " is " + factorial);
}
}