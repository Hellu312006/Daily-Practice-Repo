package Day_30;

// ==========================================
// 1. Creating Thread by Extending Thread Class
// ==========================================
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " (Extending Thread) is running - Step: " + i);
            try {
                Thread.sleep(400); // Sleep for 400 milliseconds
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
    }
}

// ==========================================
// 2. Creating Thread by Implementing Runnable Interface
// ==========================================
class MyRunnable implements Runnable {
    private String taskName;

    public MyRunnable(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " (Implementing Runnable) is running - Step: " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(taskName + " was interrupted.");
            }
        }
    }
}

// ==========================================
// 3. Thread Synchronization Example
// ==========================================
class Counter {
    private int count = 0;

    // Synchronized method to prevent race conditions
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

// ==========================================
// Main Class
// ==========================================
public class practical_296 {
    public static void main(String[] args) {
        System.out.println("=== 1. Basic Thread Creation & Execution ===");

        // Method 1: Using Thread class
        MyThread t1 = new MyThread("Worker-Thread-1");

        // Method 2: Using Runnable interface
        Thread t2 = new Thread(new MyRunnable("Worker-Thread-2"));

        // Setting Thread priorities
        t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        t2.setPriority(Thread.MAX_PRIORITY); // Priority 10

        System.out.println(t1.getName() + " Priority: " + t1.getPriority());
        System.out.println(t2.getName() + " Priority: " + t2.getPriority());

        // Start threads
        t1.start();
        t2.start();

        // Wait for threads to finish using join()
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== 2. Thread Synchronization Demonstration ===");
        Counter counter = new Counter();

        // Two threads sharing the same Counter object
        Thread syncThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread syncThread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        syncThread1.start();
        syncThread2.start();

        try {
            syncThread1.join();
            syncThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value (Expected 2000): " + counter.getCount());
        System.out.println("All threads finished execution successfully.");
    }
}
