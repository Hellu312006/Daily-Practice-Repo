package Day_17;

// Q6: Create abstract class Bank with getRateOfInterest() and implement it in different banks.

abstract class Bank {
    // Abstract method returning interest rate
    abstract double getRateOfInterest();
}

class SBI extends Bank {
    @Override
    double getRateOfInterest() {
        return 7.0;
    }
}

class HDFC extends Bank {
    @Override
    double getRateOfInterest() {
        return 7.5;
    }
}

class ICICI extends Bank {
    @Override
    double getRateOfInterest() {
        return 8.0;
    }
}

public class practical_176 {
    public static void main(String[] args) {
        Bank b1 = new SBI();
        Bank b2 = new HDFC();
        Bank b3 = new ICICI();

        System.out.println("SBI Rate of Interest: " + b1.getRateOfInterest() + "%");
        System.out.println("HDFC Rate of Interest: " + b2.getRateOfInterest() + "%");
        System.out.println("ICICI Rate of Interest: " + b3.getRateOfInterest() + "%");
    }
}
