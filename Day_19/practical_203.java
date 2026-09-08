package Day_19;

// Custom Exception Definition
@SuppressWarnings("serial")
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Q13: Custom Exception Example (Bank Account Withdrawal)
public class practical_203 {

    static double balance = 5000.0;

    static void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Transaction Failed! Balance: Rs." + balance + ", Attempted: Rs." + amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Rs." + amount + " debited. Remaining balance: Rs." + balance);
    }

    public static void main(String[] args) {
        // Case 1: Valid Withdrawal
        try {
            System.out.println("Attempt 1: Withdrawing Rs. 2000...");
            withdraw(2000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // Case 2: Invalid Withdrawal (Triggers Custom Exception)
        try {
            System.out.println("Attempt 2: Withdrawing Rs. 4000...");
            withdraw(4000); // Balance is now 3000, 4000 will fail
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
