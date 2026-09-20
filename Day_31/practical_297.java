package Day_31;

public class practical_297 {
    public static void main(String[] args) {
        int[] arr = {15, 42, 8, 93, 67, 24, 93, 51};

        System.out.print("Array elements: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n-------------------------------------------");

        // 1. Finding Maximum and Minimum Elements
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

        // 2. Finding Second Largest Element
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
        System.out.println("Second Largest Element: " + secondLargest);

        // 3. Counting Even and Odd Numbers
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

        // 4. Linear Search for a Key
        int target = 67;
        int foundIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Element " + target + " found at index: " + foundIndex);
        } else {
            System.out.println("Element " + target + " not found in array.");
        }
    }
}
