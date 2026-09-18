package Day_29;

public class practical_291 {
    public static void main(String[] args) {
        int[] numbers = {12, 45, 7, 89, 34, 67, 23};

        System.out.print("Original Array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // -------------------------------------------------------------
        // 1. Reverse the Array (In-Place using Two-Pointers)
        // -------------------------------------------------------------
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }

        System.out.print("Reversed Array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n---------------------------------------------");

        // -------------------------------------------------------------
        // 2. Find the Second Largest Element in the Array
        // -------------------------------------------------------------
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("Largest Element       : " + largest);
        System.out.println("Second Largest Element: " + secondLargest);
    }
}
