package Day_37;

import java.util.Scanner;

// ============================================================================
// Practical 284 / Day 37: Print Name 5 Times Using a Thread
// Task: Create a thread that prints a specified name 5 times with index.
// ============================================================================

class NamePrinterThread extends Thread {
    private final String personName;
    private final int repeatCount;

    public NamePrinterThread(String threadName, String personName, int repeatCount) {
        super(threadName);
        this.personName = personName;
        this.repeatCount = repeatCount;
    }

    @Override
    public void run() {
        System.out.println("\n[" + getName() + "] Started printing '" + personName + "' " + repeatCount + " times:\n");
        for (int i = 1; i <= repeatCount; i++) {
            System.out.println("  " + getName() + " [#" + i + "]: Hello, " + personName + "!");
            try {
                // Sleep for 250ms between prints
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.err.println("[" + getName() + "] Interrupted: " + e.getMessage());
                break;
            }
        }
        System.out.println("\n[" + getName() + "] Completed printing name.");
    }
}

public class practical_284 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 284: Print Name 5 Times Using a Thread      ===");
        System.out.println("=============================================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name (or press Enter for default 'Antigravity'): ");
        String input = scanner.nextLine().trim();
        String name = input.isEmpty() ? "Antigravity" : input;

        System.out.println("\n[Main Thread] Creating NamePrinterThread for: " + name);
        NamePrinterThread thread = new NamePrinterThread("NameThread", name, 5);

        System.out.println("[Main Thread] Launching thread...");
        thread.start();

        try {
            thread.join(); // Wait for name printing thread to finish
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 284 executed successfully!");
        System.out.println("=============================================================");
    }
}
