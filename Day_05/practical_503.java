package Day_05;

public class practical_503 {
    public static void main(String[] args) {
        int[] arr = {12, 45, 7, 30, 22};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        
        System.out.println("sum = " + sum);
    }
}
