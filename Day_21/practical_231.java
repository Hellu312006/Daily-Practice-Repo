package Day_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Q11: Conversion between Array and ArrayList (Both Directions)
public class practical_231 {
    public static void main(String[] args) {
        System.out.println("=== 1. Converting Array -> ArrayList ===");

        String[] fruitsArray = { "Apple", "Banana", "Mango", "Orange" };
        System.out.println("Original Array: " + Arrays.toString(fruitsArray));

        // Fixed-size list (cannot add or remove elements)
        List<String> fixedList = Arrays.asList(fruitsArray);
        System.out.println("Fixed-Size List: " + fixedList);

        // Fully mutable ArrayList (can add, remove, modify)
        ArrayList<String> mutableFruitList = new ArrayList<>(Arrays.asList(fruitsArray));
        mutableFruitList.add("Pineapple");
        mutableFruitList.remove("Apple");
        System.out.println("Mutable ArrayList after add/remove: " + mutableFruitList);

        System.out.println("\n=== 2. Converting ArrayList -> Array ===");

        ArrayList<String> cityList = new ArrayList<>();
        cityList.add("Delhi");
        cityList.add("Mumbai");
        cityList.add("Bangalore");
        cityList.add("Hyderabad");
        System.out.println("Original ArrayList: " + cityList);

        // Converting to Array using toArray(T[] a)
        String[] cityArray = cityList.toArray(new String[0]);

        System.out.println("Converted Array: " + Arrays.toString(cityArray));
        System.out.println("Array Length: " + cityArray.length);
        System.out.println("Accessing Index 2 from Array: " + cityArray[2]);
    }
}
