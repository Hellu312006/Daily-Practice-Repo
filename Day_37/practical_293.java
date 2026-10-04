package Day_37;

// ============================================================================
// Practical 293 / Day 37: Display Current Thread Information
// Task: Retrieve and display detailed metadata of current thread (Name, ID, State, Priority, Group, Daemon status).
// ============================================================================

class DetailedWorkerThread extends Thread {
    public DetailedWorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("--- Inside Child Thread ---");
        displayThreadDetails(Thread.currentThread());
    }

    public static void displayThreadDetails(Thread t) {
        System.out.println("  Thread Name    : " + t.getName());
        System.out.println("  Thread ID      : " + t.threadId());
        System.out.println("  Priority       : " + t.getPriority());
        System.out.println("  State          : " + t.getState());
        System.out.println("  Thread Group   : " + (t.getThreadGroup() != null ? t.getThreadGroup().getName() : "None"));
        System.out.println("  Is Alive?      : " + t.isAlive());
        System.out.println("  Is Daemon?     : " + t.isDaemon());
        System.out.println("  Is Interrupted?: " + t.isInterrupted());
    }
}

public class practical_293 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 293: Display Current Thread Information     ===");
        System.out.println("=============================================================\n");

        // 1. Display Current Thread (Main Thread) Details
        System.out.println("--- Current Thread (Main Thread) Information ---");
        Thread currentMain = Thread.currentThread();
        DetailedWorkerThread.displayThreadDetails(currentMain);
        System.out.println();

        // 2. Display Child Thread Details from within child execution
        DetailedWorkerThread worker = new DetailedWorkerThread("Background-Worker-01");
        
        System.out.println("--- Child Thread Information (Before start()) ---");
        DetailedWorkerThread.displayThreadDetails(worker);
        System.out.println();

        System.out.println("[Main Thread] Starting Child Thread...\n");
        worker.start();

        try {
            worker.join();
        } catch (InterruptedException e) {
            System.err.println("Main interrupted: " + e.getMessage());
        }

        System.out.println("\n--- Child Thread Information (After Completion) ---");
        DetailedWorkerThread.displayThreadDetails(worker);

        System.out.println("\n=============================================================");
        System.out.println("Practical 293 executed successfully!");
        System.out.println("=============================================================");
    }
}
