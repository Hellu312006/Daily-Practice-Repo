package Day_18;

// Q9: Default Method in Interface (Java 8+)

interface Greeter {
    // Abstract method (must be implemented by class)
    void greetUser(String name);

    // Default method (has a default implementation in the interface)
    default void sayWelcome() {
        System.out.println("Welcome to the Java Learning Portal!");
    }

    // Another default method that can optionally be overridden
    default void sayGoodbye() {
        System.out.println("Thank you for visiting. Goodbye!");
    }
}

class MemberService implements Greeter {
    @Override
    public void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Optionally overriding sayGoodbye() default method
    @Override
    public void sayGoodbye() {
        System.out.println("Member session ended. See you soon!");
    }
}

public class practical_189 {
    public static void main(String[] args) {
        MemberService service = new MemberService();

        // 1. Calling implemented abstract method
        service.greetUser("Aman");

        // 2. Calling default method inherited directly from interface
        service.sayWelcome();

        // 3. Calling overridden default method
        service.sayGoodbye();
    }
}
