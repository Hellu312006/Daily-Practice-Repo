package Day_17;

// Q4: Create abstract class Shape and implement area() in Rectangle.

abstract class Shape {
    // Abstract method
    abstract void area();
}

class Rectangle extends Shape {
    double length;
    double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Implementing the abstract area() method from Shape
    @Override
    void area() {
        double result = length * breadth;
        System.out.println("Area of Rectangle (length = " + length + ", breadth = " + breadth + "): " + result);
    }
}

public class practical_174 {
    public static void main(String[] args) {
        Shape rect = new Rectangle(6.0, 4.0);
        rect.area();
    }
}

