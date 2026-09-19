package Day_30;

// ==========================================
// 1. Compile-Time Polymorphism (Method Overloading)
// ==========================================
class Calculator {
    // Overloaded method: 2 integer parameters
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method: 3 integer parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method: 2 double parameters
    double add(double a, double b) {
        return a + b;
    }
}

// ==========================================
// 2. Runtime Polymorphism (Method Overriding)
// ==========================================
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}

// ==========================================
// Main Class to Demonstrate Polymorphism
// ==========================================
public class practical_293 {
    public static void main(String[] args) {
        System.out.println("=== 1. Compile-Time Polymorphism (Method Overloading) ===");
        Calculator calc = new Calculator();
        System.out.println("add(10, 20)        : " + calc.add(10, 20));
        System.out.println("add(10, 20, 30)    : " + calc.add(10, 20, 30));
        System.out.println("add(10.5, 20.5)    : " + calc.add(10.5, 20.5));

        System.out.println("\n=== 2. Runtime Polymorphism (Method Overriding) ===");
        // Parent class reference holding child class objects
        Animal myAnimal;

        myAnimal = new Animal();
        myAnimal.sound(); // Calls Animal's sound()

        myAnimal = new Dog();
        myAnimal.sound(); // Calls Dog's overridden sound()

        myAnimal = new Cat();
        myAnimal.sound(); // Calls Cat's overridden sound()
    }
}
