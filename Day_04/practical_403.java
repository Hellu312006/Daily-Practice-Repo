package Day_04;

import java.util.Arrays;
import java.util.HashSet;

public class practical_403 {
    
    
    public static void findAllDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        
        for (int num : arr) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }
        
        if (duplicates.isEmpty()) {
            System.out.println("No duplicate numbers found.");
        } else {
            System.out.println("Duplicate numbers: " + duplicates);
        }
    }
    
    public static int findSingleDuplicateFloyd(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        
    
        int tortoise = arr[0];
        int hare = arr[0];
        
        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (tortoise != hare);

        tortoise = arr[0];
        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }
        
        return tortoise;
    }

    public static void main(String[] args) {
        
        int[] arr1 = {4, 3, 2, 7, 8, 2, 3, 1, 8};
        System.out.println("Array 1: " + Arrays.toString(arr1));
        findAllDuplicates(arr1);
        
        System.out.println("--------------------------------");
        
        
        int[] arr2 = {1, 3, 4, 2, 2};
        System.out.println("Array 2: " + Arrays.toString(arr2));
        int duplicate = findSingleDuplicateFloyd(arr2);
        System.out.println("Single duplicate number found: " + duplicate);
    }
}
