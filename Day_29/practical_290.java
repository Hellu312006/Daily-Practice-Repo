package Day_29;

public class practical_290 {
    public static void main(String[] args) {
        int[] arr = {14, 25, 33, 40, 55, 62, 77, 88};

        // 1. Linear Search for an Element
        int target = 55;
        int foundIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }

        System.out.print("Array: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("\n----------------------------------");

        if (foundIndex != -1) {
            System.out.println("Element " + target + " found at index: " + foundIndex);
        } else {
            System.out.println("Element " + target + " not found in array.");
        }

        // 2. Count Even and Odd Numbers
        int evenCount = 0;
        int oddCount = 0;

        for (int val : arr) {
            if (val % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even numbers count: " + evenCount);
        System.out.println("Odd numbers count : " + oddCount);
    }
}
