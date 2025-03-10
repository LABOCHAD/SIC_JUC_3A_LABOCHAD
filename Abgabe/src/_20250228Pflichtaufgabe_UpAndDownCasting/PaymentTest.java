package _20250228Pflichtaufgabe_UpAndDownCasting;

import java.util.ArrayList;

// Main class to test casting
public class PaymentTest {
    public static void main(String[] args) {
        // DONE: Upcasting: Storing different payment types in a Payment Array or ArrayList
        // Sample payment types:
        // new CreditCardPayment(100, "1234-5678-9012-3456")
        // new PayPalPayment(200, "user@example.com")
        // new CryptoPayment(300, "0xAbC123456789")
        ArrayList<Payment> payments = new ArrayList<Payment>();
        payments.add(new CreditCardPayment(100, "1234-5678-9012-3456"));
        payments.add(new PayPalPayment(200, "user@example.com"));
        payments.add(new CryptoPayment(300, "0xAbC123456789"));
        payments.add(null);


        // DOME: Processing payments using upcasting
        // use an advanced for loop
        for (Payment payment : payments) {
            // Call overridden method from child class processPayment()
            if (payment != null)
                payment.processPayment();
            // Downcasting: Checking type (with instanceof()) and calling specific methods
            if (payment instanceof CreditCardPayment creditCardPayment) {
                //if not using pattern variable, same with those below
                //CreditCardPayment creditCardPayment = (CreditCardPayment) payment;
                creditCardPayment.validateCard();
            } else if (payment instanceof PayPalPayment payPalPayment) {
                payPalPayment.checkPayPalAccount();
            } else if (payment instanceof CryptoPayment cryptoPayment) {
                cryptoPayment.verifyWallet();
            } else {
                System.out.println("There is nothing specific to do here.");
            }
            System.out.println("------"); // divider -> end of for loop
        }


    }
}
