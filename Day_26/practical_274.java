package Day_26;

import java.util.Scanner;

// ============================================================================
// Practical 274: REVISION CODE 2 - Comprehensive Exception Handling System
// Concepts Covered:
// 1. Custom Checked Exception (InsufficientFundsException)
// 2. Custom Unchecked Exception (InvalidTransactionAmountException)
// 3. 'throw' and 'throws' keywords
// 4. Try - Catch - Finally and Nested Try-Catch blocks
// 5. Java 7+ Multi-catch blocks (e.g., NumberFormatException | NullPointerException)
// 6. Robust input validation with Scanner
// ============================================================================

// 1. Custom Checked Exception (Inherits Exception -> must be declared or handled)
class InsufficientFundsException extends Exception {
    private double availableBalance;
    private double requestedAmount;

    public InsufficientFundsException(String message, double availableBalance, double requestedAmount) {
        super(message);
        this.availableBalance = availableBalance;
        this.requestedAmount = requestedAmount;
    }

    public double getDeficit() {
        return requestedAmount - availableBalance;
    }
}

// 2. Custom Unchecked Exception (Inherits RuntimeException)
class InvalidTransactionAmountException extends RuntimeException {
    public InvalidTransactionAmountException(String message) {
        super(message);
    }
}

// ATM/Account Service with exception validation rules
class ATMService {
    private double currentBalance;
    private final String accountPin = "4321";

    public ATMService(double initialBalance) {
        this.currentBalance = initialBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    // PIN Authentication with throw
    public void authenticate(String enteredPin) throws SecurityException {
        if (enteredPin == null || enteredPin.trim().isEmpty()) {
            throw new NullPointerException("PIN cannot be null or empty!");
        }
        if (!enteredPin.equals(accountPin)) {
            throw new SecurityException("Authentication Failed: Incorrect PIN entered.");
        }
        System.out.println("[Auth]: PIN Verified successfully.");
    }

    // Method declaring custom checked and throwing unchecked exceptions
    public void withdraw(double amount) throws InsufficientFundsException {
        // Validate amount (Unchecked exception)
        if (amount <= 0) {
            throw new InvalidTransactionAmountException("Transaction amount must be greater than 0! (Provided: " + amount + ")");
        }

        // Validate sufficient funds (Checked exception)
        if (amount > currentBalance) {
            throw new InsufficientFundsException(
                "Insufficient account balance for withdrawal!", 
                currentBalance, 
                amount
            );
        }

        // Process withdrawal
        currentBalance -= amount;
        System.out.println("[Success]: Withdrew Rs. " + amount + " | Remaining Balance: Rs. " + currentBalance);
    }

    // Transfer money simulation demonstrating nested try and multi-catch
    public void transferMoney(String recipientAccount, String amountStr) {
        System.out.println("\n--- Initiating Transfer to Account: " + recipientAccount + " ---");
        try {
            // Nested Try for Number Parsing
            double amount;
            try {
                amount = Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                System.out.println("[Nested Catch - Format Error]: Invalid numerical string '" + amountStr + "'.");
                throw new IllegalArgumentException("Transfer amount format is invalid", e);
            }

            // Perform withdrawal from current account
            withdraw(amount);
            System.out.println("[Transfer]: Rs. " + amount + " transferred to " + recipientAccount + " successfully.");

        } catch (InsufficientFundsException e) {
            System.out.println("[Checked Exception Caught]: " + e.getMessage());
            System.out.println("-> Deficit amount needed: Rs. " + e.getDeficit());
        } catch (InvalidTransactionAmountException | IllegalArgumentException e) {
            // Multi-catch handling unchecked runtime issues
            System.out.println("[Multi-Catch Caught]: " + e.getClass().getSimpleName() + " -> " + e.getMessage());
        } finally {
            System.out.println("[Finally Block]: Transfer operation log completed. Balance: Rs. " + currentBalance);
        }
    }
}

// Main class to execute and demonstrate all exception scenarios
public class practical_274 {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" Practical 274: REVISION 2 - Exception Handling & Custom Classes  ");
        System.out.println("==================================================================\n");

        ATMService atm = new ATMService(10000.0);
        Scanner scanner = new Scanner(System.in);

        // Scenario 1: Authentication Testing (try-catch with SecurityException & NullPointerException)
        try {
            System.out.println("[Test 1]: Testing Correct PIN Authentication:");
            atm.authenticate("4321");

            System.out.println("\n[Test 2]: Testing Wrong PIN Authentication:");
            atm.authenticate("9999");
        } catch (SecurityException | NullPointerException e) {
            System.out.println("[Security Catch]: " + e.getMessage());
        }

        // Scenario 2: Normal Successful Withdrawal
        System.out.println("\n[Test 3]: Normal Valid Withdrawal:");
        try {
            atm.withdraw(2500.0);
        } catch (InsufficientFundsException | InvalidTransactionAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Scenario 3: Negative Amount (Custom Unchecked Exception)
        System.out.println("\n[Test 4]: Invalid (Negative) Amount Withdrawal:");
        try {
            atm.withdraw(-500.0);
        } catch (InvalidTransactionAmountException e) {
            System.out.println("[Custom Unchecked Catch]: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("[Custom Checked Catch]: " + e.getMessage());
        }

        // Scenario 4: Overdraft / Insufficient Funds (Custom Checked Exception)
        System.out.println("\n[Test 5]: Overdraw Exceeding Balance:");
        try {
            atm.withdraw(20000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("[Custom Checked Catch]: " + e.getMessage());
            System.out.println("-> Shortage by: Rs. " + e.getDeficit());
        }

        // Scenario 5: Transfer with Multi-Catch and Nested Try-Catch
        System.out.println("\n[Test 6]: Transfer with invalid number string:");
        atm.transferMoney("ACC-987654", "five_thousand");

        System.out.println("\n[Test 7]: Valid Transfer:");
        atm.transferMoney("ACC-987654", "3000");

        System.out.println("\n==================================================================");
        System.out.println("[Revision 2 Complete]: All Exception handling concepts verified!");
        System.out.println("==================================================================");

        scanner.close();
    }
}
