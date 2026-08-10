package Day_2;

import java.util.Scanner;

public class practical_206 {
    public static void main(String[] args) {
        int[] arr = {12, 45, 78, 34, 56, 90};
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to search: ");
        int target = scanner.nextInt();
        
        int index = linearSearch(arr, target);
        
        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
        
        scanner.close();
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
