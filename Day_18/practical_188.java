package Day_18;

// Q8: Interface Variable (public static final constants)

interface VehicleConstants {
    // Interface variables are implicitly public, static, and final
    public static final int MAX_SPEED = 120;
    public static final int MIN_SPEED = 0;
    public static final String SPEED_UNIT = "km/h";
}

class Bike implements VehicleConstants {
    void displayLimits() {
        // Direct access within implementing class
        System.out.println("Bike Limits: " + MIN_SPEED + " to " + MAX_SPEED + " " + SPEED_UNIT);
    }
}

public class practical_188 {
    public static void main(String[] args) {
        // 1. Accessing via Interface Name (Recommended approach)
        System.out.println("--- 1. Accessing via Interface Name ---");
        System.out.println("Max Speed: " + VehicleConstants.MAX_SPEED + " " + VehicleConstants.SPEED_UNIT);
        System.out.println("Min Speed: " + VehicleConstants.MIN_SPEED + " " + VehicleConstants.SPEED_UNIT);

        // 2. Accessing through Implementing Class instance
        System.out.println("\n--- 2. Accessing via Implementing Class ---");
        Bike bike = new Bike();
        bike.displayLimits();

        // 3. Accessing via Class Name
        System.out.println("\n--- 3. Accessing via Class Name ---");
        System.out.println("Speed Unit: " + Bike.SPEED_UNIT);
    }
}
