package Day_31;

import java.util.Arrays;

// ============================================================================
// Practical 298: Array Manipulation (In-Place Reversal, Copy, Frequency, Sorted Check)
// ============================================================================

public class practical_298 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 298: Array Manipulation & Validation ===");
        System.out.println("=============================================================\n");

        int[] arr = { 10, 20, 30, 40, 50, 20, 30, 20 };
        System.out.println("Original Sample Array: " + Arrays.toString(arr));

        // --------------------------------------------------------------------
        // 1. Reversing an Array (In-Place Two-Pointer Technique)
        // --------------------------------------------------------------------
        System.out.println("\n--- 1. In-Place Array Reversal (Two-Pointer) ---");
        int[] toReverse = { 10, 20, 30, 40, 50 };
        System.out.println("Before Reversal: " + Arrays.toString(toReverse));

        int start = 0;
        int end = toReverse.length - 1;
        while (start < end) {
            int temp = toReverse[start];
            toReverse[start] = toReverse[end];
            toReverse[end] = temp;
            start++;
            end--;
        }
        System.out.println("After Reversal : " + Arrays.toString(toReverse));

        // --------------------------------------------------------------------
        // 2. Copying Array Elements to Another Array
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Copying Array Elements ---");
        // Method A: Manual element-by-element copy
        int[] manualCopy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            manualCopy[i] = arr[i];
        }
        System.out.println("Manual Loop Copied Array : " + Arrays.toString(manualCopy));

        // Method B: Using Arrays.copyOf()
        int[] builtinCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("Arrays.copyOf Cloned Array: " + Arrays.toString(builtinCopy));

        // --------------------------------------------------------------------
        // 3. Count Frequency / Occurrences of a Target Element
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Element Frequency Counter ---");
        int target = 20;
        int count = 0;

        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        System.out.println("Target Element : " + target);
        System.out.println("Frequency      : " + count + " time(s) in " + Arrays.toString(arr));

        // --------------------------------------------------------------------
        // 4. Check if an Array is Sorted in Ascending Order
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Checking if Array is Sorted ---");
        int[] sortedArray = { 5, 12, 19, 28, 45, 60 };
        int[] unsortedArray = { 15, 8, 30, 22, 50 };

        checkSorted(sortedArray);
        checkSorted(unsortedArray);

        System.out.println("\n=============================================================");
        System.out.println("Practical 298 executed successfully!");
        System.out.println("=============================================================");
    }

    // Helper method to check if array is sorted in ascending order
    private static void checkSorted(int[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println("Array " + Arrays.toString(array) + " -> Sorted: " + (isSorted ? "YES (Ascending)" : "NO (Unsorted)"));
    }
}
