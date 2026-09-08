package Day_19;

// Q7: 'throw' keyword example (Explicitly throwing an exception)
public class practical_197 {

    static void checkBalance(int balance, int withdrawAmount) {
        if (withdrawAmount > balance) {
            throw new ArithmeticException("Insufficient balance! Withdraw amount balance se zyada hai.");
        } else {
            System.out.println("Withdrawal successful! Remaining balance: " + (balance - withdrawAmount));
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Attempting withdrawal...");
            checkBalance(5000, 7000);
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("Banking operation finished.");
    }
}
