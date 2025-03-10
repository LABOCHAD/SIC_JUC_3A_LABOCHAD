package _20250228Pflichtaufgabe_UpAndDownCasting;

// Child class 3: Crypto Payment
class CryptoPayment extends Payment {
    String walletAddress;

    CryptoPayment(double amount, String walletAddress) {
        super(amount);
        this.walletAddress = walletAddress;
    }

    @Override
    void processPayment() {
        System.out.println("Processing Crypto Payment of $" + amount);
    }

    void verifyWallet() {
        System.out.println("Verifying crypto wallet: " + walletAddress);
    }
}