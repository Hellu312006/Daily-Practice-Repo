package Day_16;

class Animal7 {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog7 extends Animal7 {
    @Override
    void sound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

class Cat7 extends Animal7 {
    @Override
    void sound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}

public class practical_167 {
    public static void main(String[] args) {
        // Runtime Polymorphism / Dynamic Method Dispatch
        Animal7 a;

        a = new Dog7();
        a.sound(); // Calls Dog7's sound() at runtime

        a = new Cat7();
        a.sound(); // Calls Cat7's sound() at runtime
    }
}
