package Day_20;

import java.util.ArrayList;

// Q4: Update an element using set()
public class practical_209 {
    public static void main(String[] args) {
        // Creating an ArrayList
        ArrayList<String> languages = new ArrayList<>();

        // Adding elements
        languages.add("C");
        languages.add("C++");
        languages.add("Python");
        languages.add("JavaScript");

        System.out.println("Before Update: " + languages);

        // Updating element at index 1 ("C++" -> "Java")
        String oldVal = languages.set(1, "Java");

        System.out.println("Replaced element: " + oldVal);
        System.out.println("After Update (index 1 changed to Java): " + languages);

        // Updating another element at index 0 ("C" -> "Go")
        languages.set(0, "Go");
        System.out.println("After updating index 0 to Go: " + languages);
    }
}
