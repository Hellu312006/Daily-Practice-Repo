package Day_31;

public class practical_298 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 20, 30, 20};

        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n-------------------------------------------");

        // 1. Reversing the Array (In-Place)
        int[] reversedArr = {10, 20, 30, 40, 50};
        int start = 0;
        int end = reversedArr.length - 1;

        while (start < end) {
            int temp = reversedArr[start];
            reversedArr[start] = reversedArr[end];
            reversedArr[end] = temp;
            start++;
            end--;
        }

        System.out.print("Reversed Array: ");
        for (int num : reversedArr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 2. Copying Array Elements to another Array
        int[] copiedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copiedArr[i] = arr[i];
        }

        System.out.print("Copied Array  : ");
        for (int num : copiedArr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 3. Count Frequency / Occurrences of a Target Element
        int target = 20;
        int count = 0;

        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        System.out.println("Frequency of element " + target + ": " + count + " time(s)");

        // 4. Check if an Array is Sorted in Ascending Order
        int[] sortedCheck = {5, 12, 19, 28, 45, 60};
        boolean isSorted = true;

        for (int i = 0; i < sortedCheck.length - 1; i++) {
            if (sortedCheck[i] > sortedCheck[i + 1]) {
                isSorted = false;
                break;
            }
        }

        System.out.print("Array {5, 12, 19, 28, 45, 60} is sorted: " + isSorted);
        System.out.println();
    }
}
