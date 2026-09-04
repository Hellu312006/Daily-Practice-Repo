package Day_16;

class ShapeArea {
    // Area of Circle: π * r^2
    double area(double radius) {
        return Math.PI * radius * radius;
    }

    // Area of Rectangle: length * breadth
    double area(double length, double breadth) {
        return length * breadth;
    }

    // Area of Square: side * side
    int area(int side) {
        return side * side;
    }

    // Area of Triangle: 0.5 * base * height
    float area(float base, float height) {
        return 0.5f * base * height;
    }
}

public class practical_162 {
    public static void main(String[] args) {
        ShapeArea shape = new ShapeArea();

        System.out.println("Area of Circle: " + shape.area(7.0));
        System.out.println("Area of Rectangle: " + shape.area(10.0, 5.0));
        System.out.println("Area of Square: " + shape.area(4));
        System.out.println("Area of Triangle: " + shape.area(6.0f, 4.0f));
    }
}
