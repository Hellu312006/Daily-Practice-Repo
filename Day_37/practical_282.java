package Day_37;

// ============================================================================
// Practical 282 / Day 37: Create a Thread Using Thread Class
// Task: Define a thread by extending the Thread class, override run(), and start it.
// ============================================================================

class MyCustomThread extends Thread {
    public MyCustomThread(String name) {
        super(name); // Set custom thread name
    }

    @Override
    public void run() {
        // Code executed by the new thread
        System.out.println("[Child Thread] Thread Name : " + Thread.currentThread().getName());
        System.out.println("[Child Thread] Thread ID   : " + Thread.currentThread().threadId());
        System.out.println("[Child Thread] Priority    : " + Thread.currentThread().getPriority());
        System.out.println("[Child Thread] State       : " + Thread.currentThread().getState());
        System.out.println("[Child Thread] Executing task concurrently in the background...");
        
        try {
            Thread.sleep(500); // Simulate some work
        } catch (InterruptedException e) {
            System.err.println("[Child Thread] Interrupted: " + e.getMessage());
        }
        
        System.out.println("[Child Thread] Finished successfully: " + Thread.currentThread().getName());
    }
}

public class practical_282 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 282: Create a Thread Using Thread Class     ===");
        System.out.println("=============================================================\n");

        System.out.println("[Main Thread] Name  : " + Thread.currentThread().getName());
        System.out.println("[Main Thread] State : " + Thread.currentThread().getState() + "\n");

        // Step 1: Create an instance of the custom Thread class
        System.out.println("[Main Thread] Creating child thread instance...");
        MyCustomThread childThread = new MyCustomThread("WorkerThread-1");

        // Step 2: Start the thread using start() method (invokes run() asynchronously)
        System.out.println("[Main Thread] Calling childThread.start()...\n");
        childThread.start();

        // Main thread continues execution concurrently
        try {
            // Wait for worker thread to complete
            childThread.join();
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted while waiting: " + e.getMessage());
        }

        System.out.println("\n[Main Thread] Worker thread has completed execution.");
        System.out.println("=============================================================");
        System.out.println("Practical 282 executed successfully!");
        System.out.println("=============================================================");
    }
}
