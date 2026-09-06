package Day_18;

// Q4: Shape interface -> Circle implements -> area()

interface Shape {
    void area();
}

class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        double result = Math.PI * radius * radius;
        System.out.printf("Area of Circle (radius = %.2f): %.2f%n", radius, result);
    }
}

public class practical_184 {
    public static void main(String[] args) {
        Shape circle = new Circle(7.0);
        circle.area();
    }
}
