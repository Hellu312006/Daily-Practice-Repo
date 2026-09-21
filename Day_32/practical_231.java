package Day_32;

import java.util.Arrays;

// ============================================================================
// Practical 231 / Day 32: Core Array Operations & Algorithms in Java
// Covers:
// 1. Array Bubble Sort (Ascending Order)
// 2. Binary Search (Iterative Algorithm - O(log N))
// 3. Array Rotation (Left Rotate by K positions)
// 4. Segregating Even and Odd numbers
// ============================================================================

public class practical_231 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 231: Core Array Operations & Algorithms ===");
        System.out.println("=============================================================\n");

        // --------------------------------------------------------------------
        // 1. Bubble Sort (Sorting Array in Ascending Order)
        // --------------------------------------------------------------------
        System.out.println("--- 1. Bubble Sort Algorithm ---");
        int[] numbers = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Unsorted Array : " + Arrays.toString(numbers));

        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swap elements
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: stop if array is already sorted
        }
        System.out.println("Sorted Array   : " + Arrays.toString(numbers));

        // --------------------------------------------------------------------
        // 2. Binary Search on Sorted Array
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Binary Search Algorithm (O(log N)) ---");
        int target = 25;
        int searchResult = binarySearch(numbers, target);

        System.out.println("Search Target  : " + target);
        if (searchResult != -1) {
            System.out.println("Result         : Found at Index " + searchResult);
        } else {
            System.out.println("Result         : Not found in array.");
        }

        // --------------------------------------------------------------------
        // 3. Left Rotate Array by K Positions
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Left Rotate Array by K Positions ---");
        int[] rotateArr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 2;
        System.out.println("Original Array : " + Arrays.toString(rotateArr));
        rotateLeft(rotateArr, k);
        System.out.println("Rotated by " + k + "   : " + Arrays.toString(rotateArr));

        // --------------------------------------------------------------------
        // 4. Segregate Even and Odd Numbers
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Segregate Even and Odd Numbers ---");
        int[] mixArray = { 12, 34, 45, 9, 8, 90, 3 };
        System.out.println("Input Array    : " + Arrays.toString(mixArray));

        int[] segregated = segregateEvenOdd(mixArray);
        System.out.println("Segregated     : " + Arrays.toString(segregated));

        System.out.println("\n=============================================================");
        System.out.println("Practical 231 executed successfully!");
        System.out.println("=============================================================");
    }

    // Helper: Binary Search
    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Helper: Left Rotate Array
    private static void rotateLeft(int[] arr, int k) {
        int len = arr.length;
        k = k % len;
        reverse(arr, 0, k - 1);
        reverse(arr, k, len - 1);
        reverse(arr, 0, len - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Helper: Segregate Even and Odd
    private static int[] segregateEvenOdd(int[] arr) {
        int[] result = new int[arr.length];
        int index = 0;

        // First add all even numbers
        for (int num : arr) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }
        // Then add all odd numbers
        for (int num : arr) {
            if (num % 2 != 0) {
                result[index++] = num;
            }
        }
        return result;
    }
}
