package Day_15;

// Q7: Animal -> Dog using super.method() to call parent method

class Animal7 {
    void eat() {
        System.out.println("Animal is eating.");
    }
}

class Dog7 extends Animal7 {
    // Child class method
    void eat() {
        super.eat(); // Calling parent method using super.eat()
        System.out.println("Dog is eating bread.");
    }
}

public class practical_157 {
    public static void main(String[] args) {
        Dog7 d = new Dog7();
        d.eat(); // Calls child's eat() which internally calls super.eat() first
    }
}
