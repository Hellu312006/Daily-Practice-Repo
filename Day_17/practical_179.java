package Day_17;

// Q9: Create abstract class with constructor + abstract method.

abstract class Mobile {
    String modelName;

    // Abstract class Constructor
    Mobile(String modelName) {
        this.modelName = modelName;
        System.out.println("Abstract Mobile constructor called for: " + modelName);
    }

    // Abstract method
    abstract void unlock();
}

class SmartPhone extends Mobile {
    SmartPhone(String modelName) {
        super(modelName); // Invoking constructor of abstract class
    }

    // Implementing the abstract method
    @Override
    void unlock() {
        System.out.println(modelName + " unlocked successfully via Fingerprint/Face ID.");
    }
}

public class practical_179 {
    public static void main(String[] args) {
        Mobile phone = new SmartPhone("Google Pixel 9");
        phone.unlock();
    }
}
