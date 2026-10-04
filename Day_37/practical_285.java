package Day_37;

// ============================================================================
// Practical 285 / Day 37: Create Two Threads
// Task: Create and start two separate threads running concurrently in Java.
// ============================================================================

class WorkerThread extends Thread {
    private final int count;
    private final int delayMs;

    public WorkerThread(String name, int count, int delayMs) {
        super(name);
        this.count = count;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {
        System.out.println("  [" + getName() + "] Started execution.");
        for (int i = 1; i <= count; i++) {
            System.out.println("    -> " + getName() + " is processing step " + i + "/" + count);
            try {
                Thread.sleep(delayMs); // Pause to show concurrent interleaving
            } catch (InterruptedException e) {
                System.err.println("    [" + getName() + "] Interrupted: " + e.getMessage());
                break;
            }
        }
        System.out.println("  [" + getName() + "] Finished execution.");
    }
}

public class practical_285 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 285: Create Two Threads                     ===");
        System.out.println("=============================================================\n");

        System.out.println("[Main Thread] Creating Thread 1 and Thread 2...");
        
        // Creating first thread
        WorkerThread thread1 = new WorkerThread("Thread-Alpha", 4, 300);
        
        // Creating second thread
        WorkerThread thread2 = new WorkerThread("Thread-Beta", 4, 200);

        System.out.println("[Main Thread] Starting both threads concurrently...\n");
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        }

        System.out.println("\n[Main Thread] Both threads have finished execution.");
        System.out.println("=============================================================");
        System.out.println("Practical 285 executed successfully!");
        System.out.println("=============================================================");
    }
}
