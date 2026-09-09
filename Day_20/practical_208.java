package Day_20;

import java.util.ArrayList;

// Q3: Get an element using index
public class practical_208 {
    public static void main(String[] args) {
        // Creating an ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Grapes");

        System.out.println("Fruits List: " + fruits);

        // Getting elements using get(index)
        String firstFruit = fruits.get(0);
        String thirdFruit = fruits.get(2);
        String lastFruit = fruits.get(fruits.size() - 1);

        System.out.println("\nElement at index 0: " + firstFruit);
        System.out.println("Element at index 2: " + thirdFruit);
        System.out.println("Last element (index " + (fruits.size() - 1) + "): " + lastFruit);
    }
}
