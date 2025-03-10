package _20241118Wiederholung;

import java.util.ArrayList;

/*
Aufgabe 18.11.2024
Aufgabenstellung: Warenkorbverwaltung mit Methoden und Schleifen
Ziel: Erstelle eine Klasse „Warenkorb“, welche 4 Methoden implementieren soll.
Eine Methode, um ein Produkt hinzuzufügen „produktHinzufuegen“, eine zum
Berechnen des Gesamtpreises „berechneGesamtpreis“, eine die die Anzahl an
Elementen zurückgibt „anzahlProdukte“ und eine Methode, die zurückgibt wie
viele Produkte über einem gewissen Preis liegen „anzahlProdukteUeber“.

Ausführung:
Erstelle die Klasse „Warenkorb“ und definiere eine leere ArrayList, welche den
    Warenkorb widerspiegeln soll. Wichtig: Für unser Beispiel werden nur Preise
    in der ArrayList gespeichert, der Produktname fällt also weg

Erstelle die Methode „produktHinzufuegen“, welche ein Produkt (ein Preis)
    der ArrayList hinzufügt

Erstelle die Methode „berechneGesamtpreis“, welche jedes Element der
ArrayList durchgeht und dann die einzelnen Elemente summiert. Gebe das
Ergebnis zurück (return)

Erstelle die Methode „anzahlProdukte“, welche die Anzahl der Elemente in
der ArrayList zurückgibt

Erstelle die Methode „anzahlProdukteUeber“, welche einen Preis als
Parameter entgegennimmt. Prüfe nun in der Methode, wie viele Produkte über
dem eingegebenen Preis liegen und gebe zum Schluss die Anzahl der
Elemente zurück

Zusatz: Versuche einen Weg zu finden, um zu verhindern, dass der Benutzer
einen negativen Preis angibt. Verwende hierfür nur If-Bedingungen.
 */

public class ShoppingCart {
    private final ArrayList<Double> products = new ArrayList<>();

    /**
     * Adds single price to an ArrayList of Doubles.
     * If number is negative, it will be flipped.
     * Reversal occurs by math absolute method.
     *
     * @param price Given by User as an element to add.
     */
    public void addProduct(double price) {
        if (price < 0) {
            System.out.println("Unzulässige negatives Zahl erkannt! Vorzeichen wird entfernt.");
            price = Math.abs(price);
        }
        this.products.add(price);
    }

    /**
     * Simply sums up all prices in the list.
     *
     * @return Total sum of all prices.
     */
    public double calculateTotal() {
        double sum = 0;
        for (Double d : products) {
            sum += d;
        }
        return sum;
    }

    /**
     * Counts how many prices are in the list.
     *
     * @return size of the list.
     */
    public int countProducts() {
        return products.size();
    }

    /**
     * Compares every list item with a user given price.
     * If price exceeds the value, it will be considered and counted.
     *
     * @param price to look if it's being exceeded.
     * @return count of prices those exceed the user given price.
     */
    public int countWhenPriceIsOver(double price) {
        int count = 0;
        for (Double d : products) {
            if (d > price) {
                count++;
                System.out.printf("%nExceedance found: %.2f (at index: %d)", d, this.products.indexOf(d));
            }
        }
        return count;
    }


}
