package Day_15;

// Q1: Animal -> Dog using Single Inheritance

class Animal {
    void eat() {
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking.");
    }
}

public class practical_151 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // Calling parent method
        d.bark();  // Calling child method
    }
}
