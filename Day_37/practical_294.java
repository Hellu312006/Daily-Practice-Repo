package Day_37;

// ============================================================================
// Practical 294 / Day 37: Download Simulation
// Task: Simulate a file download using a background thread with percentage progress.
// ============================================================================

class FileDownloadThread extends Thread {
    private final String fileName;
    private final int delayMs;

    public FileDownloadThread(String fileName, int delayMs) {
        super("Download-Thread");
        this.fileName = fileName;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {
        System.out.println("Downloading " + fileName + "...\n");

        for (int progress = 10; progress <= 100; progress += 10) {
            // Build visual progress bar
            int filled = progress / 10;
            StringBuilder bar = new StringBuilder("[");
            for (int i = 0; i < 10; i++) {
                if (i < filled) {
                    bar.append("=");
                } else {
                    bar.append(" ");
                }
            }
            bar.append("]");

            System.out.printf("  %s %3d%%%n", bar, progress);

            try {
                Thread.sleep(delayMs); // Simulate network transfer time
            } catch (InterruptedException e) {
                System.err.println("\n[ERROR] Download interrupted: " + e.getMessage());
                return;
            }
        }

        System.out.println("\nDownload Complete");
    }
}

public class practical_294 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 294: Download Simulation                    ===");
        System.out.println("=============================================================\n");

        FileDownloadThread downloader = new FileDownloadThread("JDK_21_Installer.zip", 250);
        downloader.start();

        try {
            downloader.join(); // Wait for download to finish
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\n=============================================================");
        System.out.println("Practical 294 executed successfully!");
        System.out.println("=============================================================");
    }
}
