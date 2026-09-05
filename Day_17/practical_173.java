package Day_17;

// Q3: Create abstract class Shape with abstract area() method. Implement it in Circle.

abstract class Shape {
    // Abstract method (does not have a body)
    abstract void area();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    // Providing implementation for the abstract method
    @Override
    void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Area of Circle (radius = " + radius + "): " + result);
    }
}

public class practical_173 {
    public static void main(String[] args) {
        Shape shape = new Circle(5.0);
        shape.area();
    }
}
