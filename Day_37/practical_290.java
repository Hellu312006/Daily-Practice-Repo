package Day_37;

// ============================================================================
// Practical 290 / Day 37: Create Two Runnable Threads
// Task: Create and run two concurrent threads using the Runnable interface.
// ============================================================================

class TaskRunnable implements Runnable {
    private final String taskName;
    private final int steps;
    private final int delayMs;

    public TaskRunnable(String taskName, int steps, int delayMs) {
        this.taskName = taskName;
        this.steps = steps;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("  [" + threadName + "] Started task: " + taskName);

        for (int i = 1; i <= steps; i++) {
            System.out.println("    -> [" + threadName + "] Working on " + taskName + " (Step " + i + "/" + steps + ")");
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                System.err.println("    [" + threadName + "] Task interrupted: " + e.getMessage());
                return;
            }
        }

        System.out.println("  [" + threadName + "] Finished task: " + taskName);
    }
}

public class practical_290 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 290: Create Two Runnable Threads            ===");
        System.out.println("=============================================================\n");

        // 1. Create two separate Runnable instances
        TaskRunnable downloadTask = new TaskRunnable("File Downloader", 4, 300);
        TaskRunnable processTask = new TaskRunnable("Data Parser", 4, 200);

        // 2. Pass each Runnable instance into a Thread object
        Thread thread1 = new Thread(downloadTask, "Downloader-Thread");
        Thread thread2 = new Thread(processTask, "Parser-Thread");

        System.out.println("[Main Thread] Starting both Runnable threads concurrently...\n");
        
        // 3. Start both threads
        thread1.start();
        thread2.start();

        // 4. Wait for both threads to complete execution
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        }

        System.out.println("\n[Main Thread] Both Runnable threads have completed.");
        System.out.println("=============================================================");
        System.out.println("Practical 290 executed successfully!");
        System.out.println("=============================================================");
    }
}
