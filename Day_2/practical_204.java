package Day_2;

public class practical_204 {
    public static void main(String[] args) {
        int[] arr = {12, 45, 78, 34, 56, 90};
        int max = arr[0]; 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("The largest element in the array is: " + max);
    }
}
