package Day_35;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// ============================================================================
// Practical 266 / Day 35: ⭐ Take Numbers from User and Print Unique Numbers
// Tasks:
// - Read numbers dynamically from the user using Scanner
// - Store input in a List to track all entered values
// - Use HashSet to filter out duplicates and keep only unique numbers
// - Identify duplicate entries and print a detailed summary report
// - Display unique numbers in both insertion order / sorted order
// ============================================================================

public class practical_266 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 266 (⭐): Unique Numbers Filter via HashSet ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.out.printlnAndReturnScannerInput());

        System.out.print("Enter the total count of numbers you want to input (N): ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            // Default sample count for testing/fallback
            n = 8;
        }

        ArrayList<Integer> allNumbers = new ArrayList<>();
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        HashSet<Integer> duplicateNumbers = new HashSet<>();

        System.out.println("\nPlease enter " + n + " numbers (one by one or space-separated):");
        for (int i = 1; i <= n; i++) {
            System.out.print("Number #" + i + ": ");
            int num;
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                // Fallback demo numbers if input stream ends
                int[] demo = { 15, 24, 15, 89, 42, 24, 99, 15 };
                num = demo[(i - 1) % demo.length];
                System.out.println(num + " (auto-input)");
            }

            allNumbers.add(num);

            // If add() returns false, it's a duplicate!
            boolean isNew = uniqueNumbers.add(num);
            if (!isNew) {
                duplicateNumbers.add(num);
            }
        }

        // --- Output Results ---
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Input Analysis & Results ---");
        System.out.println("-------------------------------------------------------------");
        System.out.println("All Numbers Entered     : " + allNumbers);
        System.out.println("Total Numbers Count     : " + allNumbers.size());
        System.out.println("Unique Numbers (HashSet): " + uniqueNumbers);
        System.out.println("Unique Numbers Count    : " + uniqueNumbers.size());
        System.out.println("Duplicate Values Found  : " + (duplicateNumbers.isEmpty() ? "None" : duplicateNumbers));
        System.out.println("Duplicates Filtered Out : " + (allNumbers.size() - uniqueNumbers.size()));

        // Display sorted unique numbers for clean presentation
        Set<Integer> sortedUnique = new TreeSet<>(uniqueNumbers);
        System.out.println("Unique Numbers (Sorted) : " + sortedUnique);

        System.out.println("\n--- Unique Numbers List ---");
        int count = 1;
        for (int val : uniqueNumbers) {
            System.out.println("  " + (count++) + ". " + val);
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 266 executed successfully!");
        System.out.println("=============================================================");

        scanner.close();
    }

    // Helper to supply standard System.in cleanly
    private static java.io.InputStream printlnAndReturnScannerInput() {
        return System.in;
    }
}
