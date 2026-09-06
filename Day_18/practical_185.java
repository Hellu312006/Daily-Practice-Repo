package Day_18;

// Q5: Payment interface -> UPI and Card implement pay()

interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    private String upiId;

    UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paid Rs. %.2f successfully using UPI ID: %s%n", amount, upiId);
    }
}

class Card implements Payment {
    private String cardNumber;

    Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        String lastFourDigits = cardNumber.length() > 4 ? cardNumber.substring(cardNumber.length() - 4) : cardNumber;
        System.out.printf("Paid Rs. %.2f successfully using Card ending with: %s%n", amount, lastFourDigits);
    }
}

public class practical_185 {
    public static void main(String[] args) {
        Payment upiPayment = new UPI("user@okaxis");
        upiPayment.pay(1500.00);

        Payment cardPayment = new Card("1234567890123456");
        cardPayment.pay(4999.50);
    }
}
