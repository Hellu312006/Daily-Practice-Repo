package Day_30;

import java.util.Arrays;

public class practical_295 {

    // ==========================================
    // 1. Binary Search (Iterative Approach) - O(log N)
    // ==========================================
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents integer overflow

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in right half
            } else {
                high = mid - 1; // Search in left half
            }
        }
        return -1; // Target not found
    }

    // ==========================================
    // 2. Binary Search (Recursive Approach) - O(log N)
    // ==========================================
    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1; // Base case: not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, mid + 1, high, target);
        } else {
            return binarySearchRecursive(arr, low, mid - 1, target);
        }
    }

    // ==========================================
    // 3. Find Second Largest & Second Smallest - O(N)
    // ==========================================
    public static void findSecondLargestAndSmallest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array must contain at least 2 elements.");
            return;
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            // Find smallest and second smallest
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }

            // Find largest and second largest
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("Smallest Element        : " + smallest);
        System.out.println("Second Smallest Element : " + secondSmallest);
        System.out.println("Largest Element         : " + largest);
        System.out.println("Second Largest Element  : " + secondLargest);
    }

    // ==========================================
    // 4. Rotate Array Left by K positions
    // ==========================================
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle k > array length
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
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

    // ==========================================
    // Main Method
    // ==========================================
    public static void main(String[] args) {
        // --- Test 1: Binary Search ---
        System.out.println("=== 1. Binary Search (Iterative & Recursive) ===");
        int[] sortedArr = {12, 24, 35, 47, 58, 69, 80, 95};
        int target = 58;

        System.out.println("Sorted Array : " + Arrays.toString(sortedArr));
        System.out.println("Target Value : " + target);

        int iterIndex = binarySearchIterative(sortedArr, target);
        int recIndex = binarySearchRecursive(sortedArr, 0, sortedArr.length - 1, target);

        System.out.println("Iterative Binary Search Index : " + iterIndex);
        System.out.println("Recursive Binary Search Index : " + recIndex);

        // --- Test 2: Second Largest & Smallest ---
        System.out.println("\n=== 2. Second Smallest & Second Largest (O(N)) ===");
        int[] numbers = {45, 12, 85, 32, 89, 39, 69, 89, 12};
        System.out.println("Array : " + Arrays.toString(numbers));
        findSecondLargestAndSmallest(numbers);

        // --- Test 3: Array Rotation ---
        System.out.println("\n=== 3. Left Rotate Array by K positions ===");
        int[] toRotate = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Original Array      : " + Arrays.toString(toRotate));
        rotateLeft(toRotate, k);
        System.out.println("Left Rotated by " + k + " : " + Arrays.toString(toRotate));
    }
}
