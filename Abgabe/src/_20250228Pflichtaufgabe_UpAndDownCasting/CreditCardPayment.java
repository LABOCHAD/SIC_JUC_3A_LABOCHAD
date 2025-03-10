package _20250228Pflichtaufgabe_UpAndDownCasting;

// Child class 1: Credit Card Payment
class CreditCardPayment extends Payment {
    String cardNumber;

    CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    void processPayment() {
        System.out.println("Processing Credit Card Payment of $" + amount);
    }

    void validateCard() {
        System.out.println("Validating card number: " + cardNumber);
    }
}
