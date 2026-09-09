package Day_20;

import java.util.ArrayList;

// Q8: Check whether ArrayList is empty using isEmpty()
public class practical_213 {
    public static void main(String[] args) {
        ArrayList<String> cart = new ArrayList<>();

        // Checking empty list
        System.out.println("Is cart empty? " + cart.isEmpty());
        if (cart.isEmpty()) {
            System.out.println("Your shopping cart is currently empty.");
        }

        // Adding items
        cart.add("Laptop");
        cart.add("Headphones");

        System.out.println("\nCart items: " + cart);
        System.out.println("Is cart empty now? " + cart.isEmpty());

        // Clearing items
        cart.clear();
        System.out.println("\nCart cleared.");
        System.out.println("Is cart empty after clear()? " + cart.isEmpty());
    }
}
