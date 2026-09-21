package Day_31;

import java.util.Arrays;

// ============================================================================
// Practical 297: Array Analysis & Search Operations (Min/Max, 2nd Largest, Linear Search)
// ============================================================================

public class practical_297 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 297: Array Analysis & Search Operations ===");
        System.out.println("=============================================================\n");

        int[] arr = { 15, 42, 8, 93, 67, 24, 93, 51 };
        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Array Size : " + arr.length);

        // --------------------------------------------------------------------
        // 1. Finding Maximum and Minimum Elements
        // --------------------------------------------------------------------
        System.out.println("\n--- 1. Maximum & Minimum Elements ---");
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Maximum Element: " + max);
        System.out.println("Minimum Element: " + min);

        // --------------------------------------------------------------------
        // 2. Finding Second Largest Element
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Finding Second Largest Element ---");
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second Largest Element does not exist (all elements may be identical).");
        } else {
            System.out.println("Largest Element       : " + largest);
            System.out.println("Second Largest Element: " + secondLargest);
        }

        // --------------------------------------------------------------------
        // 3. Counting Even and Odd Numbers
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Counting Even and Odd Numbers ---");
        int evenCount = 0;
        int oddCount = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Count of Even Numbers: " + evenCount);
        System.out.println("Count of Odd Numbers : " + oddCount);

        // --------------------------------------------------------------------
        // 4. Linear Search Algorithm
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Linear Search for Target Keys ---");
        int target1 = 67;
        int target2 = 100;

        performLinearSearch(arr, target1);
        performLinearSearch(arr, target2);

        System.out.println("\n=============================================================");
        System.out.println("Practical 297 executed successfully!");
        System.out.println("=============================================================");
    }

    // Helper method for linear search
    private static void performLinearSearch(int[] arr, int target) {
        int foundIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Key " + target + " -> Found at index: " + foundIndex);
        } else {
            System.out.println("Key " + target + " -> Not found in array.");
        }
    }
}
