package Day_18;

// Q7: Runtime Polymorphism using Interface Reference (Animal a = new Dog();)

interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog says: Woof Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat says: Meow Meow!");
    }
}

class Cow implements Animal {
    @Override
    public void sound() {
        System.out.println("Cow says: Moo Moo!");
    }
}

public class practical_187 {
    public static void main(String[] args) {
        // Interface reference pointing to Dog object
        Animal a = new Dog();
        System.out.print("Animal reference -> Dog: ");
        a.sound(); // Calls Dog's sound method at runtime

        // Reassigning interface reference to Cat object
        a = new Cat();
        System.out.print("Animal reference -> Cat: ");
        a.sound(); // Calls Cat's sound method at runtime

        // Reassigning interface reference to Cow object
        a = new Cow();
        System.out.print("Animal reference -> Cow: ");
        a.sound(); // Calls Cow's sound method at runtime
    }
}
