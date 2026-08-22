package Day_08;

class Account {
    String accountNumber;
    String accountHolderName;
    double balance;

    
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        System.out.println("Parameterized Constructor invoked for Account: " + accountNumber);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name:    " + accountHolderName);
        System.out.println("Balance:        $" + balance);
        System.out.println("----------------------------------------");
    }
}

public class practical_805 {
    public static void main(String[] args) {
        System.out.println("=== Creating Account using Parameterized Constructor ===");
        
        Account acc = new Account("100200300", "Robert Downey", 50000.0);
        
        System.out.println("\n--- Initial Details ---");
        acc.displayDetails();

        System.out.println("--- Transactions ---");
        acc.deposit(1500.0);
        acc.withdraw(200.0);
        
        System.out.println("\n--- Final Details ---");
        acc.displayDetails();
    }
}
