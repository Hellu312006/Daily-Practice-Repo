package Day_15;

// Q9: Parent and Child constructors execution order

class Parent9 {
    // Parent class constructor
    Parent9() {
        System.out.println("1. Parent class constructor executed.");
    }
}

class Child9 extends Parent9 {
    // Child class constructor
    Child9() {
        // super(); is called automatically as the first statement
        System.out.println("2. Child class constructor executed.");
    }
}

public class practical_159 {
    public static void main(String[] args) {
        System.out.println("=== Constructor Execution Order Demonstration ===");

        // Creating child class object triggers constructor chain
        Child9 obj = new Child9();
    }
}
