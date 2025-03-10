package _20241118Wiederholung;

/**
 * Schreibe eine Methode, die einen Boolean übergeben bekommt und folgendes kann:
 *  true:
 * Berechnung der Summe aller natürlichen Zahlen bis 50
 * Ausgabe des Ergebnisses in der Konsole
 *  false:
 * Berechnung des Produkts aller natürlichen Zahlen bis 20 (also 20!)
 * Wenn das Ergebnis gerade durch 2 teilbar ist und größer als 50, dann soll eine Ausgabe des Ergebnisses erfolgen.
 * Falls das Ergebnis durch 3 teilbar ist, dann soll keine Ausgabe erfolgen.
 * Falls das Ergebnis durch 5 teilbar ist, dann soll eine andere Ausgabe erfolgen.
 */
public class NumberCalculation {

        public static void main(String[] args) {
            performOperation(true);
            performOperation(false);
        }

    /**
     *
     * Method for calculation the differen cases of the task.
     * If true:
     * Calculate the sum of all natural numbers up to 50.
     * Print the result to the console.
     * If false:
     * Calculate the product of all natural numbers up to 20 (i.e., 20!).
     * If the result is even and greater than 50, print the result.
     * If the result is divisible by 3, do not print anything.
     * If the result is divisible by 5, print a different message.
     *
     *
     * @param flag boolean for decision which task will perform
     */
    public static void performOperation(boolean flag) {
            if (flag) {
                // Berechnung der Summe aller natürlichen Zahlen bis 50
                int sum = 0;
                for (int i = 1; i <= 50; i++) {
                    sum += i;
                }
                // Ausgabe des Ergebnisses in der Konsole
                System.out.println("Die Summe aller natürlichen Zahlen bis 50 ist: " + sum);
            } else {
                // Berechnung des Produkts aller natürlichen Zahlen bis 20 (also 20!)
                long product = 1;
                for (int i = 1; i <= 20; i++) {
                    product *= i;
                }

                // Überprüfung der Bedingungen und Ausgabe
                if (product % 2 == 0 && product > 50) {
                    System.out.println("Das Produkt ist: " + product);
                }

                if (product % 3 == 0) {
                    // Keine Ausgabe, wenn durch 3 teilbar
                    return;
                }

                if (product % 5 == 0) {
                    System.out.println("Das Produkt ist durch 5 teilbar.");
                }
            }
        }
    }


