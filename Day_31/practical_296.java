package Day_31;

import java.util.Arrays;

// ============================================================================
// Practical 296: Basic Array Operations in Java (Declaration, Traversal & Sum)
// ============================================================================

public class practical_296 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 296: Basic Array Operations in Java ===");
        System.out.println("=============================================================\n");

        // --------------------------------------------------------------------
        // 1. Array Declaration and Initialization
        // --------------------------------------------------------------------
        System.out.println("--- 1. Declaration & Initialization ---");
        int[] arr = { 10, 20, 30, 40, 50 };
        System.out.println("Initialized Array: " + Arrays.toString(arr));

        // --------------------------------------------------------------------
        // 2. Accessing Array Elements using Index
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Accessing Elements by Index ---");
        System.out.println("First element (index 0)         : " + arr[0]);
        System.out.println("Second element (index 1)        : " + arr[1]);
        System.out.println("Middle element (index 2)        : " + arr[2]);
        System.out.println("Last element (index length - 1) : " + arr[arr.length - 1]);

        // --------------------------------------------------------------------
        // 3. Modifying an Array Element
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Modifying an Element ---");
        System.out.println("Original element at index 2     : " + arr[2]);
        arr[2] = 35; // Changing value at index 2 from 30 to 35
        System.out.println("Updated element at index 2      : " + arr[2]);
        System.out.println("Array after modification        : " + Arrays.toString(arr));

        // --------------------------------------------------------------------
        // 4. Array Length Property
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Array Length Property ---");
        System.out.println("Total number of elements (arr.length): " + arr.length);

        // --------------------------------------------------------------------
        // 5. Printing Array using Standard For Loop
        // --------------------------------------------------------------------
        System.out.println("\n--- 5. Traversal using Standard For Loop ---");
        System.out.print("Array elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println();

        // --------------------------------------------------------------------
        // 6. Printing Array using Enhanced For-Each Loop
        // --------------------------------------------------------------------
        System.out.println("\n--- 6. Traversal using Enhanced For-Each Loop ---");
        System.out.print("Array elements: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // --------------------------------------------------------------------
        // 7. Calculate Sum and Average of Array Elements
        // --------------------------------------------------------------------
        System.out.println("\n--- 7. Sum & Average Calculation ---");
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;

        System.out.println("Sum of all elements : " + sum);
        System.out.printf("Average of elements : %.2f\n", average);

        System.out.println("\n=============================================================");
        System.out.println("Practical 296 executed successfully!");
        System.out.println("=============================================================");
    }
}
