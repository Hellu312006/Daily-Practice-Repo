package Day_08;

import java.util.Scanner;

class Rectangle {
    double length;
    double width;

    
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
        System.out.println("Default Constructor invoked. Unit rectangle initialized (1.0 x 1.0).");
    }

    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        System.out.println("Parameterized Constructor invoked with length = " + length + ", width = " + width);
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public void displayDetails() {
        System.out.println("Length:     " + length);
        System.out.println("Width:      " + width);
        System.out.println("Area:       " + calculateArea());
        System.out.println("Perimeter:  " + calculatePerimeter());
        System.out.println("----------------------------------------");
    }
}

public class practical_802 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Creating Rectangle using User Input ===");
        System.out.print("Enter the length of the rectangle: ");
        double len = scanner.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double wid = scanner.nextDouble();

        
        Rectangle rect = new Rectangle(len, wid);
        
        System.out.println("\n--- Displaying Rectangle Details ---");
        rect.displayDetails();

        scanner.close();
    }
}
