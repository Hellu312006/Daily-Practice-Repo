package Day_5;

public class practical_502 {
    public static void main(String[] args) {
        int[] arr = {12, 45, 7, 30, 22};
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        System.out.println("minimum = " + min);
    }
}
