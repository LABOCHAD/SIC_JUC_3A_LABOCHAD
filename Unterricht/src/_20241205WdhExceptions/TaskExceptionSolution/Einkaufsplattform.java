package _20241205WdhExceptions.TaskExceptionSolution;

import _20241205WdhExceptions.TaskExceptionSolution.ProductException.InvalidHaltbarkeitsdatumException;
import _20241205WdhExceptions.TaskExceptionSolution.ProductException.InvalidPreisException;
import _20241205WdhExceptions.TaskExceptionSolution.ProductException.NichtGenugLagerbestandException;

public class Einkaufsplattform {
    public static void main(String[] args) {
        try {
            Elektronik laptop = new Elektronik("Laptop", 999.99, 10, 2);
            Lebensmittel apfel = new Lebensmittel("Apfel", 1.99, 50, "2025-12-31");

            System.out.println("Produkt: " + laptop.getName() + ", Preis: " + laptop.getPreis());
            laptop.garantieInfo();

            System.out.println("Produkt: " + apfel.getName() + ", Preis: " + apfel.getPreis());
            apfel.haltbarkeitsInfo();

            // Versuch, Produkte zu verkaufen
            laptop.verkaufen(5);
            apfel.verkaufen(60);  // Diese Zeile wird eine Ausnahme auslösen!

        } catch (NichtGenugLagerbestandException | InvalidPreisException | InvalidHaltbarkeitsdatumException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}
