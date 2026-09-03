package Day_15;

// Q2: Vehicle -> Car and access parent method

class Vehicle {
    void display() {
        System.out.println("This is a Vehicle.");
    }
}

class Car extends Vehicle {
    void show() {
        // Accessing parent method using super keyword
        super.display();
        System.out.println("This is a Car.");
    }
}

public class practical_152 {
    public static void main(String[] args) {
        Car c = new Car();
        c.show();
    }
}
