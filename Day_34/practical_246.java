package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 246 / Day 34: Print ArrayList Using a Normal For Loop
// Tasks:
// - Traverse and print ArrayList using traditional index-based for loop
// - Access elements with get(i)
// - Forward iteration, backward (reverse) iteration, and formatted inline print
// ============================================================================

public class practical_246 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 246: Print ArrayList Using Normal For Loop ===");
        System.out.println("=============================================================\n");

        // 1. Initialize ArrayList
        ArrayList<String> superheroes = new ArrayList<>();
        superheroes.add("Iron Man");
        superheroes.add("Spider-Man");
        superheroes.add("Thor");
        superheroes.add("Captain America");
        superheroes.add("Doctor Strange");

        System.out.println("Original ArrayList: " + superheroes);
        System.out.println("Total Size        : " + superheroes.size());

        // 2. Forward iteration with index using normal for loop
        System.out.println("\n--- 1. Forward Iteration (0 to size - 1) ---");
        for (int i = 0; i < superheroes.size(); i++) {
            System.out.println("  Index [" + i + "] -> " + superheroes.get(i));
        }

        // 3. Reverse (backward) iteration using normal for loop
        System.out.println("\n--- 2. Reverse Iteration (size - 1 down to 0) ---");
        for (int i = superheroes.size() - 1; i >= 0; i--) {
            System.out.println("  Index [" + i + "] -> " + superheroes.get(i));
        }

        // 4. Formatted inline output using normal for loop
        System.out.println("\n--- 3. Formatted Inline Print ---");
        System.out.print("Heroes: ");
        for (int i = 0; i < superheroes.size(); i++) {
            System.out.print(superheroes.get(i));
            if (i < superheroes.size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        System.out.println("\n=============================================================");
        System.out.println("Practical 246 executed successfully!");
        System.out.println("=============================================================");
    }
}
