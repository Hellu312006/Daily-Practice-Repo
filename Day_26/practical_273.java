package Day_26;

// ============================================================================
// Practical 273: REVISION CODE 1 - OOP, Abstraction, Inheritance & Polymorphism
// Concepts Covered:
// 1. Abstract Class with constructor and abstract + concrete methods
// 2. Interface implementation (Multiple inheritance through interfaces)
// 3. Inheritance and method overriding (@Override)
// 4. Encapsulation with private fields and validation
// 5. Polymorphism (Dynamic Method Dispatch)
// ============================================================================

// Interface 1: Payment processing capability
interface Payable {
    void processPayment(double amount);
    String getPaymentMethod();
}

// Interface 2: Receipt generation capability
interface ReceiptGenerator {
    void generateReceipt(String transactionId, double amount);
}

// Abstract Class representing a generic Bank Account
abstract class BankAccount {
    private String accountNumber;
    private String accountHolder;
    protected double balance;

    // Constructor of abstract class (Invoked via super() in subclasses)
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        System.out.println("[BankAccount Constructor]: Account created for " + accountHolder + " (Acc: " + accountNumber + ")");
    }

    // Encapsulation: Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete method: Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs. " + amount + " | Updated Balance: Rs. " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Abstract method: To be implemented by specific account types
    public abstract boolean withdraw(double amount);

    // Abstract method: Display account details
    public abstract void displayAccountType();
}

// Subclass 1: SavingsAccount inherits BankAccount and implements Payable, ReceiptGenerator
class SavingsAccount extends BankAccount implements Payable, ReceiptGenerator {
    private double interestRate;
    private static final double MIN_BALANCE = 1000.0;

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("--- Account Type: SAVINGS ACCOUNT (Interest Rate: " + interestRate + "%, Min Bal: Rs. " + MIN_BALANCE + ") ---");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance - amount < MIN_BALANCE) {
            System.out.println("[Withdrawal Denied]: Minimum balance of Rs. " + MIN_BALANCE + " must be maintained. Current: Rs. " + balance);
            return false;
        }
        balance -= amount;
        System.out.println("Successfully withdrew Rs. " + amount + " | Remaining Balance: Rs. " + balance);
        return true;
    }

    // Implementing Payable Interface
    @Override
    public void processPayment(double amount) {
        System.out.println("\n[Processing Payment via Savings Account Online Banking...]");
        if (withdraw(amount)) {
            generateReceipt("TXN-SAV-" + System.currentTimeMillis() % 100000, amount);
        } else {
            System.out.println("Payment failed due to insufficient funds/minimum balance restriction.");
        }
    }

    @Override
    public String getPaymentMethod() {
        return "Savings Account Direct Debit";
    }

    // Implementing ReceiptGenerator Interface
    @Override
    public void generateReceipt(String transactionId, double amount) {
        System.out.println("------------------------------------------");
        System.out.println("            TRANSACTION RECEIPT            ");
        System.out.println(" Transaction ID : " + transactionId);
        System.out.println(" Account Holder : " + getAccountHolder());
        System.out.println(" Payment Method : " + getPaymentMethod());
        System.out.println(" Amount Paid    : Rs. " + amount);
        System.out.println(" Status         : SUCCESSFUL");
        System.out.println("------------------------------------------");
    }
}

// Subclass 2: CurrentAccount with Overdraft facility
class CurrentAccount extends BankAccount implements Payable, ReceiptGenerator {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolder, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("--- Account Type: CURRENT / BUSINESS ACCOUNT (Overdraft Limit: Rs. " + overdraftLimit + ") ---");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance + overdraftLimit < amount) {
            System.out.println("[Withdrawal Denied]: Amount exceeds balance + overdraft limit (Max allowable: Rs. " + (balance + overdraftLimit) + ")");
            return false;
        }
        balance -= amount;
        System.out.println("Successfully withdrew Rs. " + amount + " | Balance (may include overdraft): Rs. " + balance);
        return true;
    }

    // Implementing Payable Interface
    @Override
    public void processPayment(double amount) {
        System.out.println("\n[Processing Commercial Payment via Current Account...]");
        if (withdraw(amount)) {
            generateReceipt("TXN-CUR-" + System.currentTimeMillis() % 100000, amount);
        } else {
            System.out.println("Commercial payment failed.");
        }
    }

    @Override
    public String getPaymentMethod() {
        return "Current Account Overdraft / Corporate Gateway";
    }

    // Implementing ReceiptGenerator Interface
    @Override
    public void generateReceipt(String transactionId, double amount) {
        System.out.println("==========================================");
        System.out.println("        COMMERCIAL PAYMENT INVOICE        ");
        System.out.println(" Reference No   : " + transactionId);
        System.out.println(" Business Name  : " + getAccountHolder());
        System.out.println(" Method         : " + getPaymentMethod());
        System.out.println(" Invoiced Amount: Rs. " + amount);
        System.out.println(" Balance Post-Tx: Rs. " + balance);
        System.out.println("==========================================");
    }
}

// Main Class demonstrating OOP concepts & Polymorphism
public class practical_273 {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("   Practical 273: REVISION 1 - OOP, Abstraction & Polymorphism    ");
        System.out.println("==================================================================\n");

        // 1. Polymorphism using Parent Reference for Child Objects (Dynamic Dispatch)
        BankAccount acc1 = new SavingsAccount("SB-1001", "Kunal Patel", 15000.0, 4.5);
        BankAccount acc2 = new CurrentAccount("CA-9002", "Tech Innovations Ltd.", 50000.0, 20000.0);

        System.out.println();
        acc1.displayAccountType();
        acc1.deposit(3000);
        acc1.withdraw(5000);

        System.out.println();
        acc2.displayAccountType();
        acc2.withdraw(60000); // Uses overdraft

        // 2. Polymorphism using Interface References
        System.out.println("\n--- Polymorphic Interface Execution ---");
        Payable paymentChannel1 = (Payable) acc1;
        Payable paymentChannel2 = (Payable) acc2;

        paymentChannel1.processPayment(2000);
        paymentChannel2.processPayment(8000);

        System.out.println("\n[Revision 1 Complete]: Abstract classes, Interfaces, and Polymorphism verified successfully!");
    }
}
