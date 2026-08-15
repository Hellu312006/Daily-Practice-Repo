package Day_5;

import java.util.Arrays;

public class practical_501 {
    
    public static int findLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {12, 45, 2, 89, 34, 67, 90, 23};
        System.out.println("Array: " + Arrays.toString(arr));
        
        try {
            int largest = findLargest(arr);
            System.out.println("Largest element: " + largest);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
