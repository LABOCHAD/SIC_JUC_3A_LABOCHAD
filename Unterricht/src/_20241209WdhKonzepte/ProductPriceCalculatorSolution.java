package _20241209WdhKonzepte;

public class ProductPriceCalculatorSolution {

    public static void main(String[] args) {
        // Product price as a primitive double
        double productPrice = 100.0;

        // Calculate the tax amount and final price using wrapper classes
        Double taxAmount = calculateTax(productPrice);  // Tax as a Double value
        System.out.println("Tax Amount (19%): " + taxAmount);

        // Calculate the final price (product price + tax)
        double finalPrice = calculateFinalPrice(taxAmount);  // Unboxing to primitive double
        System.out.println("Final Price with Tax: " + finalPrice);

        // Convert the final price to cents (int value)
        int priceInCents = convertToCents(finalPrice);  // Convert to int
        System.out.println("Final Price in Cents: " + priceInCents);
    }

    // Method to calculate the tax amount (19% VAT) and return it as a Wrapper (Double)
    public static Double calculateTax(double price) {
        double tax = price * 0.19;  // 19% VAT
        return Double.valueOf(tax);  // Return tax as a Double object (Autoboxing)
    }

    // Method to calculate the final price including tax (price + tax), converting from Double to primitive double
    public static double calculateFinalPrice(Double taxAmount) {
        double tax = taxAmount.doubleValue();  // Unboxing from Double to primitive double
        double productPrice = 100.0;  // Example product price
        return productPrice + tax;  // Final price including tax
    }

    // Method to convert the final price to cents (int)
    public static int convertToCents(double finalPrice) {
        return (int) (finalPrice * 100);  // Convert to cents (rounding to int)
    }
}
