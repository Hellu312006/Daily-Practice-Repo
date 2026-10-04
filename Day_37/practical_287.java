package Day_37;

// ============================================================================
// Practical 287 / Day 37: Change Thread Name
// Task: Demonstrate changing the name of main thread and custom worker threads using setName().
// ============================================================================

class RenamableThread extends Thread {
    public RenamableThread(String initialName) {
        super(initialName);
    }

    @Override
    public void run() {
        System.out.println("  [Worker Thread] Initial Name inside run(): " + getName());
        
        // Dynamically changing thread name during execution
        this.setName("Worker-Renamed-At-Runtime");
        System.out.println("  [Worker Thread] Updated Name inside run(): " + getName());
    }
}

public class practical_287 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 287: Change Thread Name                     ===");
        System.out.println("=============================================================\n");

        // 1. Changing Main Thread's Name
        Thread mainThread = Thread.currentThread();
        System.out.println("--- 1. Changing Main Thread Name ---");
        System.out.println("Original Main Thread Name : " + mainThread.getName());
        
        mainThread.setName("CustomMasterThread");
        System.out.println("Updated Main Thread Name  : " + mainThread.getName());
        System.out.println();

        // 2. Changing Custom Thread Name before starting
        System.out.println("--- 2. Changing Worker Thread Name Before start() ---");
        RenamableThread worker = new RenamableThread("OldWorkerName");
        System.out.println("Initial Worker Name       : " + worker.getName());

        worker.setName("NewPreLaunchName");
        System.out.println("Worker Name after setName : " + worker.getName());
        System.out.println();

        // 3. Starting the thread and modifying name dynamically inside run()
        System.out.println("--- 3. Modifying Worker Thread Name Inside run() ---");
        worker.start();

        try {
            worker.join();
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e.getMessage());
        }

        System.out.println("Worker Name after finish  : " + worker.getName());

        // Restore main thread name for cleanliness
        mainThread.setName("main");

        System.out.println("\n=============================================================");
        System.out.println("Practical 287 executed successfully!");
        System.out.println("=============================================================");
    }
}
