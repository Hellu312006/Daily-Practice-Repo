package Day_15;

// Q5: Grandparent -> Parent -> Child (Multilevel Inheritance)

class Grandparent {
    void showGrandparent() {
        System.out.println("Grandparent method called.");
    }
}

class Parent extends Grandparent {
    void showParent() {
        System.out.println("Parent method called.");
    }
}

class Child extends Parent {
    void showChild() {
        System.out.println("Child method called.");
    }
}

public class practical_155 {
    public static void main(String[] args) {
        Child c = new Child();
        c.showGrandparent(); // Method from Grandparent class
        c.showParent();      // Method from Parent class
        c.showChild();       // Method from Child class
    }
}
