package Day_16;

class Parent {
    void message() {
        System.out.println("Message from Parent class");
    }
}

class Child extends Parent {
    @Override
    void message() {
        super.message(); // Calling Parent method using super
        System.out.println("Message from Child class");
    }
}

public class practical_166 {
    public static void main(String[] args) {
        Child c = new Child();
        c.message();
    }
}
