package Day_35;

import java.util.HashSet;

// ============================================================================
// Practical 264 / Day 35: Check If Value Exists using contains() in HashSet
// Tasks:
// - Populate a HashSet with lottery / ID numbers
// - Check for existing numbers using contains()
// - Check for non-existing numbers using contains()
// - Demonstrate fast O(1) membership lookup in practical scenarios
// ============================================================================

public class practical_264 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 264: HashSet contains() Method ===");
        System.out.println("=============================================================\n");

        // 1. Create and populate HashSet with Lucky Draw Winning Numbers
        HashSet<Integer> winningNumbers = new HashSet<>();
        winningNumbers.add(1045);
        winningNumbers.add(2089);
        winningNumbers.add(3312);
        winningNumbers.add(4578);
        winningNumbers.add(5120);
        winningNumbers.add(6789);

        System.out.println("Winning Lottery Ticket Pool: " + winningNumbers);
        System.out.println("Total Winning Numbers      : " + winningNumbers.size());

        // 2. Check for an existing number
        int checkTicket1 = 3312;
        System.out.println("\n--- 1. Checking Ticket #" + checkTicket1 + " ---");
        if (winningNumbers.contains(checkTicket1)) {
            System.out.println("🎉 Congratulations! Ticket #" + checkTicket1 + " is a WINNER!");
        } else {
            System.out.println("❌ Sorry, Ticket #" + checkTicket1 + " is not in the winning pool.");
        }

        // 3. Check for a non-existing number
        int checkTicket2 = 9999;
        System.out.println("\n--- 2. Checking Ticket #" + checkTicket2 + " ---");
        if (winningNumbers.contains(checkTicket2)) {
            System.out.println("🎉 Congratulations! Ticket #" + checkTicket2 + " is a WINNER!");
        } else {
            System.out.println("❌ Sorry, Ticket #" + checkTicket2 + " is NOT a winning ticket.");
        }

        // 4. Batch verification of multiple ticket numbers
        System.out.println("\n--- 3. Batch Verification ---");
        int[] playerTickets = { 1045, 7777, 5120, 8888, 2089 };
        for (int ticket : playerTickets) {
            boolean isWinner = winningNumbers.contains(ticket);
            System.out.printf("  Ticket #%-5d -> %s\n", ticket, (isWinner ? "✓ WINNER" : "✗ NOT A WINNER"));
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 264 executed successfully!");
        System.out.println("=============================================================");
    }
}
