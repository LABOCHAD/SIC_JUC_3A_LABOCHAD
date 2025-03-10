//TODO: Lange Kommentare in den Methoden kürzen, um die Lesbarkeit des Codes zu verbessern.
//TODO optional: Getter und Setter für die Attribute in den Klassen hinzufügen.
//TODO optional: Überprüfen, ob alle Exceptions sinnvoll implementiert sind (z. B. `InputMismatchException` im Konstruktor scheint unnötig, da der Compiler ungültige Typen verhindert).
//TODO optional: Prüfen, ob `IllegalArgumentException` und `ArithmeticException` in der aktuellen Logik überhaupt ausgelöst werden können, da der Konstruktor bereits negative Preise verhindert.
//TODO optional: Die Methode `getBestellungInfo` könnte einen `String` zurückgeben anstelle von direkter Konsolenausgabe, um flexibler für andere Anwendungen zu sein.
//TODO optional: Die Methode `berechneRechnung`: `ArithmeticException` ist schon durch den Konstruktor bereits ausgeschlossen. Alternativ: eine präzisere Fehlermeldung implementieren, falls eine Bestellung leer ist.
//TODO optional: String-Formatierung für Preise: Einheitliche Ausgabe von Preisen (z. B. zwei Dezimalstellen) implementieren.


package _20241206PflichtaufgabeExceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Testklasse für Restaurant und Gerichte.
 * Um den Lernfortschritt und Prozess sichtbar
 * zu belassen, habe ich als von mir unnötig
 * erachtete Komponenten vorerst belassen,
 * sodass man meinem Gedankengang folgen kann.
 * Immerhin hab ich mir die Arbeit gemacht.
 * Zum selber Testen Kommentar entfernen.
 */
public class Main {
    static Restaurant restaurant = new Restaurant();

    public static void main(String[] args) {

        Pizza pizza = new Pizza();
        Pasta pasta = new Pasta();
        Getränk getränk = new Getränk();

        //provoziere NullPointerException, (InputMismatchException klappt so nicht)
        //testeFehlerGerichteKonstruktion();

        versucheZuBestellen(pizza);
        versucheZuBestellen(pasta);
        versucheZuBestellen(getränk);

        //gegenprobe mit gleicher und mit selbiger Pizza
        Pizza anderePizza = new Pizza("Andere Pizza", 5, "egal");
        versucheZuBestellen(anderePizza); //egal ob mit Bezeichner oder als new übergeben
        //versucheZuBestellen(pizza); //hier tritt der Fehler auf, weil selbige Pizza

        //provoziere IllegalArgumentException, Bestelle Pizza nochmal.
        //versucheZuBestellen(pizza);

        //Positivbeispiel, entferne Cola (Standardgetränk)
        versucheGerichtZuStornieren(getränk);

        //provoziere NoSuchElementException. Passt, weil beide meinen Standardkonstruktor nutzen (Cola)
        Getränk gibtsNicht = new Getränk();
        //Ergebnis mit .contains: Auch wenn eine andere Cola existiert, kann nur selbige entfernt werden.
        //Ergebnis mit == im nested loop: Auch gleiche, nicht nur selbe, werden entfernt. (Referenz auf gleichen Inhalt?)
        //versucheGerichtZuStornieren(gibtsNicht); //aktuelle Prüfung auf selbst statt gleich (mehrere Colas möglich)

        //ArithmeticException nicht möglich, weil Konstruktor schon negative Werte verhindert.
        restaurant.getBestellungInfo();
        System.out.println("Gesamtwert der Bestellung: " + restaurant.berechneBestellung());


    }

    /**
     * Versucht Gericht aus Bestellung zu entfernen.
     * Meldet entsprechend zurück.
     * (Hierbei selbiges, nicht gleiches.
     * Aufgabenstellung war dahin gehend
     * (meines Erachtens) nicht eindeutig.
     * Bitte dieses Konzept nochmal aufgreifen.
     * Das hat mich richtig Zeit gekostet -.-)
     *
     * @param gericht das storniert werden soll.
     */
    static void versucheGerichtZuStornieren(Gericht gericht) {
        try {
            restaurant.gerichtEntfernen(gericht);
            System.out.println(gericht.getName() + " " + gericht.getBeschreibung() + " wurde storniert.");
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage() + ": " + gericht.getName() + " " + gericht.getBeschreibung());
        }
    }

    /**
     * Versuche zu bestellen und fange Exception.
     * In diesem Falle IllegalArgument, falls
     * Gericht bereits vorhanden oder, (was nicht
     * passieren kann), der Preis negativ ist.
     *
     * @param gericht das zu bestellen ist.
     */
    static public void versucheZuBestellen(Gericht gericht) {
        try {
            restaurant.gerichtBestellen(gericht);
            System.out.println("Erfolgreich bestellt: " + gericht.getName());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() + ": " + gericht.getName());
        }
    }

    /**
     * Teste zur Laufzeit mögliche Fehler
     * bei der Konstruktion von Gerichten.
     * Nicht alle Exceptions lassen sich
     * explizit provozieren, ohne dass der
     * Compiler sie vorher schon verhindert.
     * Fehlertest ist hier etwas zusammen
     * geschummelt, um die Fehler besser
     * auseinander halten zu können.
     */
    public static void testeFehlerGerichteKonstruktion() {
        try {
            Pizza dönerpizza = new Pizza(null, 0, "schweiß-frei dank der Gerät.");
        } catch (NullPointerException | InputMismatchException e) {
            System.err.printf("%nTeste Pizza, mit Name null, Preis 0: %n%s%n", e.getMessage());
        }

        try {
            Pasta guteNudel = new Pasta(null, 10.99, "Spongebob Referenz");
        } catch (NullPointerException | InputMismatchException e) {
            System.err.printf("%nTeste Pasta, mit Name null: %n%s%n", e.getMessage());
        }

        try {
            Getränk arschwasser = new Getränk("Ganz sicher kein Getränk", -69, "nich so leggah");
        } catch (NullPointerException | InputMismatchException e) {
            System.err.printf("%nTeste Getränk, mit Preis negativ: %n%s%n", e.getMessage());
        }
    }
}
