package Day_37;

// ============================================================================
// Practical 289 / Day 37: Create Thread Using Runnable Interface
// Task: Implement the Runnable interface, override run(), and pass it to Thread object.
// ============================================================================

// Step 1: Implement the java.lang.Runnable interface
class MyRunnableTask implements Runnable {
    private final String taskDescription;

    public MyRunnableTask(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    // Step 2: Override the run() method
    @Override
    public void run() {
        System.out.println("  [Runnable Thread] Executing task: " + taskDescription);
        System.out.println("  [Runnable Thread] Running on Thread: " + Thread.currentThread().getName());
        System.out.println("  [Runnable Thread] Thread Priority : " + Thread.currentThread().getPriority());
        
        try {
            Thread.sleep(400); // Simulate processing
        } catch (InterruptedException e) {
            System.err.println("  [Runnable Thread] Interrupted: " + e.getMessage());
        }
        
        System.out.println("  [Runnable Thread] Task completed successfully!");
    }
}

public class practical_289 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 289: Create Thread Using Runnable Interface ===");
        System.out.println("=============================================================\n");

        System.out.println("[Main Thread] Creating Runnable task instance...");
        // Step 3: Instantiate the Runnable class
        MyRunnableTask task = new MyRunnableTask("Data Processing Task");

        // Step 4: Create Thread instance and pass Runnable target
        System.out.println("[Main Thread] Wrapping Runnable inside a Thread object...");
        Thread workerThread = new Thread(task, "RunnableWorkerThread-1");

        // Step 5: Start the thread
        System.out.println("[Main Thread] Starting the thread...\n");
        workerThread.start();

        try {
            workerThread.join();
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        }

        System.out.println("\n[Main Thread] Runnable thread execution finished.");
        System.out.println("=============================================================");
        System.out.println("Practical 289 executed successfully!");
        System.out.println("=============================================================");
    }
}
