package Day_18;

// Q1: Animal interface -> Dog implements -> sound()

interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

public class practical_181 {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.sound();
    }
}
