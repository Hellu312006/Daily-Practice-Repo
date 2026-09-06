package Day_18;

// Q2: Vehicle interface -> Car implements -> start() and stop()

interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting with ignition key...");
    }

    @Override
    public void stop() {
        System.out.println("Car has stopped. Applying brakes.");
    }
}

public class practical_182 {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
        myCar.stop();
    }
}
