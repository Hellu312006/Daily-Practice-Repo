package Day_37;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// ============================================================================
// Practical 295 / Day 37: Clock Simulation
// Task: Simulate a running clock/timer displaying elapsed seconds using a thread.
// ============================================================================

class ClockThread extends Thread {
    private final int totalSeconds;

    public ClockThread(int totalSeconds) {
        super("Clock-Thread");
        this.totalSeconds = totalSeconds;
    }

    @Override
    public void run() {
        System.out.println("--- Clock Simulation Started (" + totalSeconds + " seconds) ---\n");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (int sec = 1; sec <= totalSeconds; sec++) {
            String currentTime = LocalTime.now().format(timeFormatter);
            String suffix = (sec == 1) ? "second" : "seconds";
            System.out.printf("  ⏰ [%s] %d %s%n", currentTime, sec, suffix);

            try {
                // Sleep for 1 second (1000ms)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Clock was interrupted: " + e.getMessage());
                return;
            }
        }

        System.out.println("\n--- Clock Simulation Ended ---");
    }
}

public class practical_295 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 295: Clock Simulation                       ===");
        System.out.println("=============================================================\n");

        ClockThread clock = new ClockThread(5);
        clock.start();

        try {
            clock.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 295 executed successfully!");
        System.out.println("=============================================================");
    }
}
