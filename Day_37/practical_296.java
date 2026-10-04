package Day_37;

// ============================================================================
// Practical 296 / Day 37: Two Task Program
// Task: Run two concurrent threads:
//       Thread 1 -> Print numbers (1 to 10)
//       Thread 2 -> Print alphabets (A to J)
// ============================================================================

class NumberTaskThread extends Thread {
    public NumberTaskThread() {
        super("Number-Thread");
    }

    @Override
    public void run() {
        System.out.println("  [" + getName() + "] Started printing numbers (1 to 10)...");
        for (int i = 1; i <= 10; i++) {
            System.out.println("    🔢 [" + getName() + "] Number: " + i);
            try {
                Thread.sleep(150); // Small delay to show interleaving
            } catch (InterruptedException e) {
                System.err.println("    [" + getName() + "] Interrupted: " + e.getMessage());
                return;
            }
        }
        System.out.println("  [" + getName() + "] Finished printing numbers.");
    }
}

class AlphabetTaskThread extends Thread {
    public AlphabetTaskThread() {
        super("Alphabet-Thread");
    }

    @Override
    public void run() {
        System.out.println("  [" + getName() + "] Started printing alphabets (A to J)...");
        for (char ch = 'A'; ch <= 'J'; ch++) {
            System.out.println("    🔤 [" + getName() + "] Alphabet: " + ch);
            try {
                Thread.sleep(150); // Small delay to show interleaving
            } catch (InterruptedException e) {
                System.err.println("    [" + getName() + "] Interrupted: " + e.getMessage());
                return;
            }
        }
        System.out.println("  [" + getName() + "] Finished printing alphabets.");
    }
}

public class practical_296 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 296: Two Task Program                       ===");
        System.out.println("=== (Thread 1: Numbers | Thread 2: Alphabets)             ===");
        System.out.println("=============================================================\n");

        NumberTaskThread numberThread = new NumberTaskThread();
        AlphabetTaskThread alphabetThread = new AlphabetTaskThread();

        System.out.println("[Main Thread] Starting both task threads concurrently...\n");
        numberThread.start();
        alphabetThread.start();

        try {
            numberThread.join();
            alphabetThread.join();
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        }

        System.out.println("\n[Main Thread] Both tasks completed successfully!");
        System.out.println("=============================================================");
        System.out.println("Practical 296 executed successfully!");
        System.out.println("=============================================================");
    }
}
