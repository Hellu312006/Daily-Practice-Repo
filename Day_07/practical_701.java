package Day_07;


class Car {
    
    String brand;
    String model;
    int year;
    double price;

    
    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }


    public void startEngine() {
        System.out.println(brand + " " + model + " has started! Vroom vroom...");
    }

    
    public void displayDetails() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Car Model: " + model);
        System.out.println("Year of Manufacture: " + year);
        System.out.println("Price: $" + price);
        System.out.println("---------------------------------");
    }
}

public class practical_701 {
    public static void main(String[] args) {
        
        Car myCar1 = new Car("Toyota", "Fortuner", 2023, 45000.00);
        Car myCar2 = new Car("Tata", "Nexon EV", 2024, 20000.00);

        
        System.out.println("--- Displaying Car 1 Details ---");
        myCar1.displayDetails();
        myCar1.startEngine();

        System.out.println("\n--- Displaying Car 2 Details ---");
        myCar2.displayDetails();
        myCar2.startEngine();
    }
}
