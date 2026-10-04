package Day_37;

// ============================================================================
// Practical 286 / Day 37: Display Thread Name
// Task: Display default and custom thread names using getName() and Thread.currentThread().getName().
// ============================================================================

class DisplayNameThread extends Thread {
    // Constructor 1: Uses JVM default naming (Thread-0, Thread-1, ...)
    public DisplayNameThread() {
        super();
    }

    // Constructor 2: Uses custom user-defined name
    public DisplayNameThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // Display thread name from inside run() method
        System.out.println("  [Inside run()] Thread.currentThread().getName() : " + Thread.currentThread().getName());
        System.out.println("  [Inside run()] this.getName()                   : " + this.getName());
    }
}

public class practical_286 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 286: Display Thread Name                    ===");
        System.out.println("=============================================================\n");

        // 1. Display Main Thread Name
        System.out.println("--- 1. Main Thread Information ---");
        Thread mainThread = Thread.currentThread();
        System.out.println("Main Thread Name: " + mainThread.getName());
        System.out.println();

        // 2. Display Default Child Thread Name (assigned by JVM)
        System.out.println("--- 2. Default Named Thread ---");
        DisplayNameThread defaultThread = new DisplayNameThread();
        System.out.println("Default Thread Name before start (getName()): " + defaultThread.getName());
        defaultThread.start();

        try {
            defaultThread.join();
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e.getMessage());
        }

        System.out.println();

        // 3. Display Custom Named Thread
        System.out.println("--- 3. Custom Named Thread ---");
        DisplayNameThread customThread = new DisplayNameThread("MyCustomWorkerThread");
        System.out.println("Custom Thread Name before start (getName()) : " + customThread.getName());
        customThread.start();

        try {
            customThread.join();
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 286 executed successfully!");
        System.out.println("=============================================================");
    }
}
