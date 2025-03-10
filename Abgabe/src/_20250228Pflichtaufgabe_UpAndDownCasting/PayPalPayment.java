package _20250228Pflichtaufgabe_UpAndDownCasting;

// Child class 2: PayPal Payment
class PayPalPayment extends Payment {
    String email;

    PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    void processPayment() {
        System.out.println("Processing PayPal Payment of $" + amount);
    }

    void checkPayPalAccount() {
        System.out.println("Checking PayPal account: " + email);
    }
}
