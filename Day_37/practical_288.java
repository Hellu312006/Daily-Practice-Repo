package Day_37;

// ============================================================================
// Practical 288 / Day 37: Use Thread.sleep()
// Task: Demonstrate pausing thread execution using Thread.sleep() with exception handling.
// ============================================================================

class SleepDemoThread extends Thread {
    private final int totalSeconds;

    public SleepDemoThread(String name, int totalSeconds) {
        super(name);
        this.totalSeconds = totalSeconds;
    }

    @Override
    public void run() {
        System.out.println("  [" + getName() + "] Starting countdown timer (" + totalSeconds + " seconds):");
        
        for (int i = totalSeconds; i >= 1; i--) {
            System.out.println("    ⏳ [" + getName() + "] Countdown: " + i + " second(s) remaining...");
            try {
                // Thread.sleep pauses the execution for specified milliseconds (1000ms = 1s)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("    [" + getName() + "] Thread interrupted while sleeping: " + e.getMessage());
                return;
            }
        }
        
        System.out.println("  🚀 [" + getName() + "] Blast off! Countdown completed.\n");
    }
}

public class practical_288 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 288: Use Thread.sleep()                     ===");
        System.out.println("=============================================================");

        System.out.println("\n[Main Thread] Demonstrating Thread.sleep() in background thread...");
        SleepDemoThread timerThread = new SleepDemoThread("TimerThread", 5);
        timerThread.start();

        try {
            // Main thread can also sleep or wait using join()
            timerThread.join();
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Interrupted: " + e.getMessage());
        }

        System.out.println("[Main Thread] Pausing main thread for 1.5 seconds...");
        try {
            Thread.sleep(1500); // Main thread sleeps for 1.5 seconds
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Sleep interrupted: " + e.getMessage());
        }

        System.out.println("[Main Thread] Resumed and finishing execution.");
        System.out.println("\n=============================================================");
        System.out.println("Practical 288 executed successfully!");
        System.out.println("=============================================================");
    }
}
