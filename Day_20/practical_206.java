package Day_20;

import java.util.ArrayList;

// Q1: Create an ArrayList and print 5 names
public class practical_206 {
    public static void main(String[] args) {
        // Creating an ArrayList of String type
        ArrayList<String> names = new ArrayList<>();

        // Adding 5 names to the ArrayList
        names.add("Amit");
        names.add("Rahul");
        names.add("Priya");
        names.add("Sneha");
        names.add("Vikas");

        // Printing all names
        System.out.println("=== ArrayList of Names ===");
        System.out.println("Direct Print: " + names);

        System.out.println("\nPrinting names one by one:");
        for (String name : names) {
            System.out.println("- " + name);
        }
    }
}
