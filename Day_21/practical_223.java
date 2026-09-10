package Day_21;

// Q3: Difference between 'throw' and 'throws' keywords
public class practical_223 {

    // 'throws' is used in method signature to declare potential exceptions to the caller
    static void validateWithdrawal(int balance, int amount) throws ArithmeticException {
        if (amount > balance) {
            // 'throw' explicitly throws an exception object inside the method body
            throw new ArithmeticException("Insufficient Balance! Balance: Rs." + balance + ", Requested: Rs." + amount);
        } else {
            System.out.println("Withdrawal successful! Remaining balance: Rs." + (balance - amount));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== throw vs throws Keyword Demo ===");

        // Test 1: Valid Withdrawal
        try {
            System.out.println("\nAttempt 1: Withdrawing Rs. 2000 from Rs. 5000...");
            validateWithdrawal(5000, 2000);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 2: Invalid Withdrawal
        try {
            System.out.println("\nAttempt 2: Withdrawing Rs. 8000 from Rs. 5000...");
            validateWithdrawal(5000, 8000);
        } catch (ArithmeticException e) {
            System.out.println("Handled in Caller: " + e.getMessage());
        }

        System.out.println("\nBanking operations completed safely.");
    }
}
