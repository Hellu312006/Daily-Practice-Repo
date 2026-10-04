package Day_37;

// ============================================================================
// Practical 283 / Day 37: Print Numbers 1 to 10 Using a Thread
// Task: Use a separate thread to iterate and print numbers from 1 to 10 with delay.
// ============================================================================

class NumberPrinterThread extends Thread {
    private final int start;
    private final int end;

    public NumberPrinterThread(String name, int start, int end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] Started counting from " + start + " to " + end + ":\n");
        for (int i = start; i <= end; i++) {
            System.out.println("  " + getName() + " -> Number: " + i);
            try {
                // Sleep for 200ms to simulate a timed background task
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.err.println("[" + getName() + "] Interrupted: " + e.getMessage());
                break;
            }
        }
        System.out.println("\n[" + getName() + "] Finished counting numbers from " + start + " to " + end + ".");
    }
}

public class practical_283 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 283: Print Numbers 1 to 10 Using a Thread   ===");
        System.out.println("=============================================================\n");

        System.out.println("[Main Thread] Creating NumberPrinterThread...");
        NumberPrinterThread thread = new NumberPrinterThread("NumberThread", 1, 10);

        System.out.println("[Main Thread] Starting NumberPrinterThread...\n");
        thread.start();

        try {
            thread.join(); // Wait for the counting thread to complete
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 283 executed successfully!");
        System.out.println("=============================================================");
    }
}
