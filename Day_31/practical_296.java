package Day_31;

public class practical_296 {
    public static void main(String[] args) {
        // 1. Declare and initialize an array
        int[] arr = {10, 20, 30, 40, 50};

        // 2. Accessing array elements using index
        System.out.println("First element: " + arr[0]);
        System.out.println("Second element: " + arr[1]);
        System.out.println("Last element: " + arr[arr.length - 1]);

        // 3. Modifying an element
        arr[2] = 35; // Changing value at index 2 from 30 to 35
        System.out.println("Modified element at index 2: " + arr[2]);

        // 4. Array length
        System.out.println("Size of array: " + arr.length);

        // 5. Printing array using standard for loop
        System.out.print("Array elements (using for loop): ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 6. Printing array using for-each loop
        System.out.print("Array elements (using for-each loop): ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 7. Calculate sum of array elements
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Sum of all elements: " + sum);
    }
}
