package Day_28;

import java.util.Arrays;

// ============================================================================
// Practical 287: Comprehensive Array Operations in Java (1D & 2D Arrays)
// ============================================================================

public class practical_287 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 287: Array Operations & Manipulation in Java ===");
        System.out.println("=============================================================\n");

        // --------------------------------------------------------------------
        // 1. Array Declaration, Initialization, and Traversal
        // --------------------------------------------------------------------
        System.out.println("--- 1. Declaration & Traversal ---");
        int[] numbers = { 45, 12, 89, 23, 67, 5, 99, 34 };

        System.out.println("Original Array : " + Arrays.toString(numbers));
        System.out.println("Array Length   : " + numbers.length);

        // --------------------------------------------------------------------
        // 2. Finding Maximum, Minimum, Sum, and Average
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Min, Max, Sum & Average ---");
        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int num : numbers) {
            if (num < min) min = num;
            if (num > max) max = num;
            sum += num;
        }
        double average = (double) sum / numbers.length;

        System.out.println("Minimum Element: " + min);
        System.out.println("Maximum Element: " + max);
        System.out.println("Sum of Elements: " + sum);
        System.out.printf("Average Value  : %.2f\n", average);

        // --------------------------------------------------------------------
        // 3. Reversing an Array (In-Place Two-Pointer Technique)
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Array In-Place Reversal ---");
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
        System.out.println("Reversed Array : " + Arrays.toString(numbers));

        // --------------------------------------------------------------------
        // 4. Sorting & Searching (Built-in Arrays Utility Methods)
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Sorting & Binary Search ---");
        Arrays.sort(numbers); // Sorts array in ascending order
        System.out.println("Sorted Array   : " + Arrays.toString(numbers));

        int target = 67;
        int searchIndex = Arrays.binarySearch(numbers, target);
        if (searchIndex >= 0) {
            System.out.println("Found " + target + " at sorted index: " + searchIndex);
        } else {
            System.out.println(target + " not found in array.");
        }

        // --------------------------------------------------------------------
        // 5. 2D Array (Matrix) Operations
        // --------------------------------------------------------------------
        System.out.println("\n--- 5. 2D Array (Matrix 3x3) ---");
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        System.out.println("Matrix Elements:");
        int diagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
                if (i == j) {
                    diagonalSum += matrix[i][j]; // Sum of principal diagonal
                }
            }
            System.out.println();
        }
        System.out.println("Principal Diagonal Sum: " + diagonalSum);

        System.out.println("\n=============================================================");
        System.out.println("Array practical executed successfully!");
    }
}
