package Day_4;

import java.util.Arrays;

public class practical_402 {
    
    
    public static void findLargestTwo(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }

        System.out.println("Including duplicates:");
        System.out.println("  Largest: " + first);
        System.out.println("  Second Largest: " + second);
    }

    
    public static void findLargestTwoDistinct(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }

        System.out.println("Distinct elements only:");
        System.out.println("  Largest: " + first);
        if (second == Integer.MIN_VALUE) {
            System.out.println("  Second Largest: (No distinct second largest element exists)");
        } else {
            System.out.println("  Second Largest: " + second);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 10, 6, 40, 9, 40};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("--------------------------------");
        
        findLargestTwo(arr);
        System.out.println("--------------------------------");
        findLargestTwoDistinct(arr);
    }
}
