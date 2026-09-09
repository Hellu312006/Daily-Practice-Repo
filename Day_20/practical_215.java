package Day_20;

import java.util.ArrayList;

// Q10: Print ArrayList using enhanced for loop (for-each loop)
public class practical_215 {
    public static void main(String[] args) {
        ArrayList<String> heroes = new ArrayList<>();

        heroes.add("Iron Man");
        heroes.add("Captain America");
        heroes.add("Thor");
        heroes.add("Spider-Man");
        heroes.add("Hulk");

        System.out.println("=== Printing ArrayList using Enhanced For Loop ===");
        for (String hero : heroes) {
            System.out.println("Hero: " + hero);
        }
    }
}
