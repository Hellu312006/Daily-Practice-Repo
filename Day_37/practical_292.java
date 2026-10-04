package Day_37;

// ============================================================================
// Practical 292 / Day 37: Set Thread Priority
// Task: Demonstrate thread priorities (MIN_PRIORITY, NORM_PRIORITY, MAX_PRIORITY)
//       using setPriority() and getPriority().
// ============================================================================

class PriorityWorker extends Thread {
    public PriorityWorker(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("  [" + getName() + "] Started | Priority: " + getPriority());
        long count = 0;
        for (int i = 0; i < 100_000; i++) {
            count += i;
        }
        System.out.println("  [" + getName() + "] Completed work (Sum: " + count + ")");
    }
}

public class practical_292 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 292: Set Thread Priority                    ===");
        System.out.println("=============================================================\n");

        System.out.println("--- Thread Priority Constants in Java ---");
        System.out.println("Thread.MIN_PRIORITY  : " + Thread.MIN_PRIORITY + " (Lowest)");
        System.out.println("Thread.NORM_PRIORITY : " + Thread.NORM_PRIORITY + " (Default)");
        System.out.println("Thread.MAX_PRIORITY  : " + Thread.MAX_PRIORITY + " (Highest)\n");

        // Display default priority of main thread
        System.out.println("Main Thread Priority : " + Thread.currentThread().getPriority() + "\n");

        // Create three threads
        PriorityWorker lowPriorityThread = new PriorityWorker("Low-Priority-Thread");
        PriorityWorker normPriorityThread = new PriorityWorker("Norm-Priority-Thread");
        PriorityWorker highPriorityThread = new PriorityWorker("High-Priority-Thread");

        // Set thread priorities
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);   // Priority 1
        normPriorityThread.setPriority(Thread.NORM_PRIORITY); // Priority 5
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);  // Priority 10

        System.out.println("--- Configured Thread Priorities ---");
        System.out.println(lowPriorityThread.getName() + " -> Priority: " + lowPriorityThread.getPriority());
        System.out.println(normPriorityThread.getName() + " -> Priority: " + normPriorityThread.getPriority());
        System.out.println(highPriorityThread.getName() + " -> Priority: " + highPriorityThread.getPriority());
        System.out.println();

        System.out.println("--- Starting Threads with Different Priorities ---");
        lowPriorityThread.start();
        normPriorityThread.start();
        highPriorityThread.start();

        try {
            lowPriorityThread.join();
            normPriorityThread.join();
            highPriorityThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 292 executed successfully!");
        System.out.println("=============================================================");
    }
}
