package Day_17;

// Q8: Create abstract class containing abstract + normal method.

abstract class Appliance {
    String brand;

    Appliance(String brand) {
        this.brand = brand;
    }

    // 1. Abstract method (No body, must be implemented by child class)
    abstract void turnOn();

    // 2. Normal (Concrete) method (Has a body, shared by all child classes)
    void showBrand() {
        System.out.println("Brand: " + brand);
    }
}

class Fan extends Appliance {
    Fan(String brand) {
        super(brand);
    }

    // Implementing the abstract method
    @Override
    void turnOn() {
        System.out.println("Fan is now spinning and providing cool air.");
    }
}

public class practical_178 {
    public static void main(String[] args) {
        Fan myFan = new Fan("Havells");

        // Calling the normal (concrete) method from abstract class
        myFan.showBrand();

        // Calling the implemented abstract method
        myFan.turnOn();
    }
}
