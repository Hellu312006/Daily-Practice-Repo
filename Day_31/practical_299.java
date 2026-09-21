package Day_31;

import java.util.Arrays;

// ============================================================================
// Practical 299: Advanced Array Operations (Merge, Unique Duplicates, Intersection)
// ============================================================================

public class practical_299 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 299: Advanced Array Operations ===");
        System.out.println("=============================================================\n");

        // --------------------------------------------------------------------
        // 1. Merging Two Arrays into a Third Array
        // --------------------------------------------------------------------
        System.out.println("--- 1. Merging Two 1D Arrays ---");
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8, 10 };

        System.out.println("Array 1      : " + Arrays.toString(arr1));
        System.out.println("Array 2      : " + Arrays.toString(arr2));

        int[] merged = new int[arr1.length + arr2.length];

        // Copy elements from arr1
        for (int i = 0; i < arr1.length; i++) {
            merged[i] = arr1[i];
        }
        // Copy elements from arr2
        for (int i = 0; i < arr2.length; i++) {
            merged[arr1.length + i] = arr2[i];
        }

        System.out.println("Merged Array : " + Arrays.toString(merged));
        System.out.println("Merged Length: " + merged.length);

        // --------------------------------------------------------------------
        // 2. Finding Unique Duplicate Elements in an Array
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Finding Unique Duplicate Elements ---");
        int[] numbers = { 10, 20, 30, 20, 40, 50, 30, 60, 10, 20 };
        System.out.println("Sample Array : " + Arrays.toString(numbers));

        System.out.print("Duplicates   : ");
        boolean[] visited = new boolean[numbers.length];
        boolean foundDuplicate = false;

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }
            boolean isDuplicate = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    isDuplicate = true;
                    visited[j] = true;
                }
            }
            if (isDuplicate) {
                System.out.print(numbers[i] + " ");
                foundDuplicate = true;
            }
        }
        if (!foundDuplicate) {
            System.out.print("None");
        }
        System.out.println();

        // --------------------------------------------------------------------
        // 3. Finding Common Elements Between Two Arrays (Intersection)
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Common Elements (Array Intersection) ---");
        int[] setA = { 10, 20, 30, 40, 50 };
        int[] setB = { 30, 40, 50, 60, 70 };

        System.out.println("Array A      : " + Arrays.toString(setA));
        System.out.println("Array B      : " + Arrays.toString(setB));

        System.out.print("Intersection : ");
        boolean foundCommon = false;

        for (int i = 0; i < setA.length; i++) {
            // Avoid duplicate checks from setA
            boolean alreadyChecked = false;
            for (int k = 0; k < i; k++) {
                if (setA[k] == setA[i]) {
                    alreadyChecked = true;
                    break;
                }
            }
            if (alreadyChecked) {
                continue;
            }

            for (int j = 0; j < setB.length; j++) {
                if (setA[i] == setB[j]) {
                    System.out.print(setA[i] + " ");
                    foundCommon = true;
                    break;
                }
            }
        }
        if (!foundCommon) {
            System.out.print("No common elements found");
        }
        System.out.println();

        System.out.println("\n=============================================================");
        System.out.println("Practical 299 executed successfully!");
        System.out.println("=============================================================");
    }
}
