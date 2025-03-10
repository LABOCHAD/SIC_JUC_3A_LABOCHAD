package _20250228Pflichtaufgabe_UpAndDownCasting;

// Parent class
abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract void processPayment();
}