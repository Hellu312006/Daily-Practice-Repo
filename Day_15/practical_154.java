package Day_15;

// Q4: Animal -> Dog -> Puppy using Multilevel Inheritance

class Animal1 {
    void eat() {
        System.out.println("Animal eats food.");
    }
}

class Dog1 extends Animal1 {
    void bark() {
        System.out.println("Dog barks.");
    }
}

class Puppy extends Dog1 {
    void weep() {
        System.out.println("Puppy weeps.");
    }
}

public class practical_154 {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();   // Calling Grandparent class method
        p.bark();  // Calling Parent class method
        p.weep();  // Calling Child class method
    }
}
