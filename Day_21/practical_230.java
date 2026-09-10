package Day_21;

import java.util.ArrayList;
import java.util.Iterator;

// Q10: Safe element removal during iteration (Avoiding ConcurrentModificationException)
public class practical_230 {
    public static void main(String[] args) {
        System.out.println("=== 1. Why direct removal in for-each loop fails ===");
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(25);
        nums.add(30);
        nums.add(45);
        nums.add(50);
        System.out.println("Original Numbers: " + nums);

        // Explaining ConcurrentModificationException:
        // for (Integer n : nums) {
        //     if (n % 2 == 0) nums.remove(n); // THROWS ConcurrentModificationException!
        // }

        // Method 1: Safe Removal using explicit Iterator
        System.out.println("\n--- Method 1: Safe Removal using Iterator ---");
        ArrayList<Integer> list1 = new ArrayList<>(nums);
        Iterator<Integer> iterator = list1.iterator();

        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value % 2 == 0) {
                iterator.remove(); // Safely removes current even number
            }
        }
        System.out.println("After removing even numbers (Iterator): " + list1);

        // Method 2: Safe Modern Removal using removeIf (Java 8+ Lambda)
        System.out.println("\n--- Method 2: Modern Java removeIf() ---");
        ArrayList<Integer> list2 = new ArrayList<>(nums);
        list2.removeIf(n -> n > 30); // Remove all numbers greater than 30
        System.out.println("After removing numbers > 30 (removeIf): " + list2);
    }
}
