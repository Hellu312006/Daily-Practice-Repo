package Day_15;

// Q6: Animal -> Dog using 'super' to access parent variable

class Animal6 {
    String color = "White"; // Parent variable
}

class Dog6 extends Animal6 {
    String color = "Black"; // Child variable

    void displayColor() {
        System.out.println("Child (Dog) Color: " + color);
        System.out.println("Parent (Animal) Color: " + super.color); // Accessing parent variable using super
    }
}

public class practical_156 {
    public static void main(String[] args) {
        Dog6 d = new Dog6();
        d.displayColor();
    }
}
