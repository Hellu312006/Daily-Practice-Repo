package Day_16;

class Animal8 {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog8 extends Animal8 {
    @Override
    void sound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

class Cat8 extends Animal8 {
    @Override
    void sound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}

public class practical_168 {
    public static void main(String[] args) {
        Dog8 dog = new Dog8();
        Cat8 cat = new Cat8();

        dog.sound();
        cat.sound();
    }
}
