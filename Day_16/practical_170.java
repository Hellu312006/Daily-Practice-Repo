package Day_16;

class Shape {
    void area() {
        System.out.println("Calculating area...");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Area of Circle (radius = " + radius + "): " + result);
    }
}

class Rectangle extends Shape {
    double length;
    double breadth;

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

public class practical_170 {
    public static void main(String[] args) {
        // Runtime Polymorphism: Parent reference pointing to Child objects
        Shape s1 = new Circle(5.0);
        Shape s2 = new Rectangle(4.0, 6.0);

        s1.area(); // Calls Circle's area() method at runtime
        s2.area(); // Calls Rectangle's area() method at runtime
    }
}
