package Day_17;

// Q2: Create abstract class Vehicle with start() method and implement it in Car.

abstract class Vehicle {
    // Abstract method (does not have a body)
    abstract void start();
}

class Car extends Vehicle {
    // Providing implementation for the abstract method
    @Override
    void start() {
        System.out.println("Car starts with key ignition or push button.");
    }
}

public class practical_172 {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
    }
}
