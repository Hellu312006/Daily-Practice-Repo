package Day_20;

import java.util.ArrayList;

// Q5: Remove an element
public class practical_210 {
    public static void main(String[] args) {
        // Creating an ArrayList
        ArrayList<String> cities = new ArrayList<>();

        // Adding elements
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");
        cities.add("Kolkata");
        cities.add("Chennai");

        System.out.println("Initial List: " + cities);

        // 1. Remove by index: remove(int index)
        String removedByIndex = cities.remove(1); // removes "Mumbai" at index 1
        System.out.println("\nRemoved element at index 1: " + removedByIndex);
        System.out.println("List after removing index 1: " + cities);

        // 2. Remove by object/value: remove(Object o)
        boolean isRemoved = cities.remove("Chennai");
        System.out.println("\nIs 'Chennai' removed? " + isRemoved);
        System.out.println("Final List after removal: " + cities);
    }
}
