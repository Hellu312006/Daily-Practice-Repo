package Day_7;


class Rectangle {
    
    double length;
    double width;

    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    
    public void displayDetails() {
        System.out.println("Rectangle Length: " + length);
        System.out.println("Rectangle Width:  " + width);
        System.out.println("Calculated Area:  " + calculateArea());
        System.out.println("---------------------------------");
    }
}

public class practical_702 {
    public static void main(String[] args) {
        
        Rectangle rect1 = new Rectangle(15.0, 6.0);
        Rectangle rect2 = new Rectangle(8.5, 4.0);

        
        System.out.println("--- Rectangle 1 ---");
        rect1.displayDetails();

        System.out.println("--- Rectangle 2 ---");
        rect2.displayDetails();
    }
}
