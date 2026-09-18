package Day_29;

import java.util.Arrays;

public class practical_292 {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 25, 12};

        System.out.println("Original Array    : " + Arrays.toString(arr));

        // -------------------------------------------------------------
        // 1. Bubble Sort Algorithm (Ascending Order)
        // -------------------------------------------------------------
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted Array      : " + Arrays.toString(arr));

        // -------------------------------------------------------------
        // 2. Finding Duplicate Elements in the Sorted Array
        // -------------------------------------------------------------
        System.out.print("Duplicate Elements: ");
        boolean foundDuplicate = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                System.out.print(arr[i] + " ");
                foundDuplicate = true;
                // Skip multiple occurrences of the same duplicate
                while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }
            }
        }
        if (!foundDuplicate) {
            System.out.print("None");
        }
        System.out.println();
    }
}
