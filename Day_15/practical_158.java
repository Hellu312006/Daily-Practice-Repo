package Day_15;

// Q8: Hierarchical Inheritance (Vehicle -> Car & Bike)

class Vehicle8 {
    void start() {
        System.out.println("Vehicle is starting.");
    }
}

// Child class 1 inheriting from Vehicle
class Car8 extends Vehicle8 {
    void driveCar() {
        System.out.println("Car is driving on 4 wheels.");
    }
}

// Child class 2 inheriting from Vehicle
class Bike8 extends Vehicle8 {
    void rideBike() {
        System.out.println("Bike is riding on 2 wheels.");
    }
}

public class practical_158 {
    public static void main(String[] args) {
        System.out.println("=== Hierarchical Inheritance: Vehicle -> Car & Bike ===");

        // Creating Car object
        Car8 car = new Car8();
        car.start();     // Inherited from Vehicle8
        car.driveCar();  // Car8 own method

        System.out.println("-----------------------------------");

        // Creating Bike object
        Bike8 bike = new Bike8();
        bike.start();    // Inherited from Vehicle8
        bike.rideBike(); // Bike8 own method
    }
}
