package Day_16;

class Animal {
    void sound() {
        System.out.println("Animal makes a generic sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

public class practical_164 {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.sound();

        Dog myDog = new Dog();
        myDog.sound();

        Animal polyDog = new Dog();
        polyDog.sound();
    }
}
