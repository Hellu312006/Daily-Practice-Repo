package Day_37;

// ============================================================================
// Practical 291 / Day 37: Use Thread.join()
// Task: Demonstrate coordinating thread execution and waiting for completion using join().
// ============================================================================

class WorkerTask extends Thread {
    private final int taskDurationSeconds;

    public WorkerTask(String name, int taskDurationSeconds) {
        super(name);
        this.taskDurationSeconds = taskDurationSeconds;
    }

    @Override
    public void run() {
        System.out.println("  [" + getName() + "] Task started (Duration: " + taskDurationSeconds + "s)...");
        for (int i = 1; i <= taskDurationSeconds; i++) {
            System.out.println("    [" + getName() + "] Working... (" + i + "/" + taskDurationSeconds + "s)");
            try {
                Thread.sleep(500); // 500ms per step
            } catch (InterruptedException e) {
                System.err.println("    [" + getName() + "] Interrupted: " + e.getMessage());
                return;
            }
        }
        System.out.println("  [" + getName() + "] Task completed successfully!");
    }
}

public class practical_291 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 291: Use Thread.join()                      ===");
        System.out.println("=============================================================\n");

        System.out.println("[Main Thread] Creating three worker threads...\n");
        WorkerTask task1 = new WorkerTask("Database-Loader", 3);
        WorkerTask task2 = new WorkerTask("Cache-Initializer", 2);
        WorkerTask task3 = new WorkerTask("Server-Bootstrap", 2);

        // Scenario 1: Sequential dependency using join()
        // Start task1 and wait until it completes before starting task2
        System.out.println("--- Phase 1: Sequential Coordination (Wait for task1) ---");
        task1.start();
        try {
            System.out.println("[Main Thread] Waiting for " + task1.getName() + " to finish using join()...");
            task1.join(); // Main thread halts until task1 completes
            System.out.println("[Main Thread] " + task1.getName() + " is DONE!\n");
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        }

        // Scenario 2: Parallel execution followed by joint completion
        System.out.println("--- Phase 2: Parallel Execution with join() at End ---");
        System.out.println("[Main Thread] Starting task2 and task3 concurrently...");
        task2.start();
        task3.start();

        try {
            System.out.println("[Main Thread] Waiting for both task2 and task3 to finish...");
            task2.join();
            task3.join();
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        }

        System.out.println("\n[Main Thread] All background tasks finished. Application ready to serve!");
        System.out.println("=============================================================");
        System.out.println("Practical 291 executed successfully!");
        System.out.println("=============================================================");
    }
}
