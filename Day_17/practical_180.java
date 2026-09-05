package Day_17;

// Q10: Demonstrate Abstraction and Runtime Polymorphism

// Abstract Parent Class (Abstraction)
abstract class Shape {
    abstract void area();
}

// Child Class 1
class Circle extends Shape {
    double radius;

    Circle() {
        this.radius = 5.0;
    }

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Area of Circle (radius = " + radius + "): " + result);
    }
}

// Child Class 2
class Rectangle extends Shape {
    double length;
    double breadth;

    Rectangle() {
        this.length = 4.0;
        this.breadth = 6.0;
    }

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void area() {
        double result = length * breadth;
        System.out.println("Area of Rectangle (length = " + length + ", breadth = " + breadth + "): " + result);
    }
}

public class practical_180 {
    public static void main(String[] args) {
        // Abstraction + Runtime Polymorphism (Dynamic Method Dispatch)
        // Parent reference pointing to Child objects
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.area(); // Calls Circle's area() at runtime
        s2.area(); // Calls Rectangle's area() at runtime
    }
}
