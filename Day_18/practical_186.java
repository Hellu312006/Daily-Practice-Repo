package Day_18;

// Q6: Multiple Interfaces -> Camera & MusicPlayer -> Smartphone implements both

interface Camera {
    void takePhoto();
    void recordVideo();
}

interface MusicPlayer {
    void playMusic(String song);
    void stopMusic();
}

class Smartphone implements Camera, MusicPlayer {
    private String model;

    Smartphone(String model) {
        this.model = model;
    }

    @Override
    public void takePhoto() {
        System.out.println(model + ": Photo captured with 50MP camera.");
    }

    @Override
    public void recordVideo() {
        System.out.println(model + ": Recording 4K video at 60fps.");
    }

    @Override
    public void playMusic(String song) {
        System.out.println(model + ": Playing song '" + song + "'...");
    }

    @Override
    public void stopMusic() {
        System.out.println(model + ": Music stopped.");
    }
}

public class practical_186 {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Google Pixel");

        System.out.println("--- Camera Functions ---");
        phone.takePhoto();
        phone.recordVideo();

        System.out.println("\n--- Music Player Functions ---");
        phone.playMusic("Believer");
        phone.stopMusic();
    }
}
