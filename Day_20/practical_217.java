package Day_20;

import java.util.ArrayList;
import java.util.Collections;

// Q12: Reverse an ArrayList
public class practical_217 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println("Original List: " + colors);

        // Reversing ArrayList using Collections.reverse()
        Collections.reverse(colors);

        System.out.println("Reversed List: " + colors);
    }
}
