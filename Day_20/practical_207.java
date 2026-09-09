package Day_20;

import java.util.ArrayList;

// Q2: Add 5 integers and print them
public class practical_207 {
    public static void main(String[] args) {
        // Creating an ArrayList of Integer type
        ArrayList<Integer> numbers = new ArrayList<>();

        // Adding 5 integers to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Printing the ArrayList
        System.out.println("=== ArrayList of Integers ===");
        System.out.println("Numbers List: " + numbers);

        System.out.println("\nPrinting integers using for loop:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("Element at index " + i + ": " + numbers.get(i));
        }
    }
}
