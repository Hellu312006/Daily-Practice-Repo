package Day_21;

// Custom Checked Exception Class
@SuppressWarnings("serial")
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Q5: Custom / User-Defined Exception Example
public class practical_225 {

    static double currentBalance = 5000.0;

    static void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > currentBalance) {
            throw new InsufficientBalanceException("Transaction Failed! Balance: Rs." + currentBalance + ", Request: Rs." + amount);
        }
        currentBalance -= amount;
        System.out.println("Withdrawal successful! Rs." + amount + " debited. Current Balance: Rs." + currentBalance);
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Exception (User-Defined) Demo ===");

        // Test Case 1: Valid Withdrawal
        try {
            System.out.println("\nAttempt 1: Withdrawing Rs. 2000...");
            withdraw(2000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Test Case 2: Invalid Withdrawal exceeding balance
        try {
            System.out.println("\nAttempt 2: Withdrawing Rs. 4000...");
            withdraw(4000); // Remaining balance is 3000, so this fails
        } catch (InsufficientBalanceException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }

        System.out.println("\nTransaction process finished.");
    }
}
