package Day_17;

// Q1: Create abstract class Animal with abstract method sound() and implement it in Dog.

abstract class Animal {
    // Abstract method (does not have a body)
    abstract void sound();
}

class Dog extends Animal {
    // Providing implementation for the abstract method
    @Override
    void sound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

public class practical_171 {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.sound();
    }
}