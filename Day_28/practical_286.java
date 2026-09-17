package Day_28;

// ============================================================================
// Practical 286: Demonstrate Polymorphism (Method Overloading and Method Overriding) in Java
// ============================================================================

// ----------------------------------------------------------------------------
// Part 1: Method Overloading (Compile-Time Polymorphism / Static Binding)
// Same method name, different parameter list (count, types, or order)
// ----------------------------------------------------------------------------
class MathOperations {

    // 1. Overloaded method: 2 integer parameters
    public int multiply(int a, int b) {
        System.out.println("-> multiply(int, int) called");
        return a * b;
    }

    // 2. Overloaded method: 3 integer parameters (different count)
    public int multiply(int a, int b, int c) {
        System.out.println("-> multiply(int, int, int) called");
        return a * b * c;
    }

    // 3. Overloaded method: 2 double parameters (different type)
    public double multiply(double a, double b) {
        System.out.println("-> multiply(double, double) called");
        return a * b;
    }

    // 4. Overloaded method: String and int (different type/purpose)
    public String multiply(String text, int times) {
        System.out.println("-> multiply(String, int) called");
        return text.repeat(times);
    }
}

// ----------------------------------------------------------------------------
// Part 2: Method Overriding (Run-Time Polymorphism / Dynamic Method Dispatch)
// Subclass provides a specific implementation of a method in parent class
// ----------------------------------------------------------------------------
class Payment {
    public void processPayment(double amount) {
        System.out.println("Processing generic payment of $" + amount);
    }
}

class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount + " using Card: ****" 
                + cardNumber.substring(cardNumber.length() - 4));
    }
}

class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount + " via UPI ID: " + upiId);
    }
}

// ----------------------------------------------------------------------------
// Main Class for Practical 286
// ----------------------------------------------------------------------------
public class practical_286 {
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("=== Practical 286: Polymorphism (Overloading & Overriding)  ===");
        System.out.println("===============================================================\n");

        // --- SECTION 1: Method Overloading ---
        System.out.println("--- Section 1: Method Overloading (Compile-time Polymorphism) ---");
        MathOperations math = new MathOperations();

        System.out.println("Result 1: " + math.multiply(5, 4));
        System.out.println("Result 2: " + math.multiply(2, 3, 4));
        System.out.println("Result 3: " + math.multiply(2.5, 4.0));
        System.out.println("Result 4: " + math.multiply("Java ", 3));

        System.out.println("\n---------------------------------------------------------------");

        // --- SECTION 2: Method Overriding (Dynamic Method Dispatch) ---
        System.out.println("--- Section 2: Method Overriding (Run-time Polymorphism) ---");
        
        // Parent reference pointing to different child objects
        Payment payment1 = new Payment();
        Payment payment2 = new CreditCardPayment("1234567890123456");
        Payment payment3 = new UPIPayment("user@oksbi");

        // Same method call, different behaviors resolved at runtime
        payment1.processPayment(150.00);
        payment2.processPayment(499.99);
        payment3.processPayment(89.50);

        System.out.println("\n===============================================================");
        System.out.println("Program executed successfully!");
    }
}
