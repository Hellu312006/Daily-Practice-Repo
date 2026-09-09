package Day_20;

import java.util.ArrayList;

// Q9: Print ArrayList using normal for loop
public class practical_214 {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Grapes");

        System.out.println("=== Printing ArrayList using Normal For Loop ===");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("Index " + i + ": " + fruits.get(i));
        }
    }
}
