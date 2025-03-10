package _20241206PflichtaufgabeExceptions;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Restaurant {
    private final ArrayList<Gericht> bestellung;

    Restaurant() {
        bestellung = new ArrayList<>();
    }

    /**
     * Fügt Gericht der Bestellung hinzu, wenn
     * der Preis gültig ist und das Gericht
     * nicht schon bestellt wurde. Andernfalls
     * wird stattdessen ein Fehler ausgeworfen.
     *
     * @param gericht das bestellt werden soll.
     * @throws IllegalArgumentException wenn Preis ungültig oder Gericht bereits bestellt.
     */
    public void gerichtBestellen(Gericht gericht) throws IllegalArgumentException {
        if (bestellung.contains(gericht)) //nur selbiges Gericht. Abweichungen möglich.
            throw new IllegalArgumentException("Gericht wurde bereits bestellt");
        if (gericht.getPreis() <= 0)
            //Macht theoretisch auch wenig Sinn, wenn schon der Konstruktor verhindert,
            //dass für Gerichte negative Preise angegeben werden können.
            throw new IllegalArgumentException("Der Preis eines Gerichts muss positiv sein.");
        bestellung.add(gericht);
    }

    /**
     * Frage: Sollten nur gleiche oder auch
     * selbige Gerichte entfernt werden können?
     * Entfernt Gericht aus der Bestellung,
     * wenn es schon bestellt wurde. Andernfalls
     * wird stattdessen ein Fehler ausgeworfen.
     *
     * @param gericht das storniert werden soll.
     * @throws NoSuchElementException wenn Gericht nicht in Bestellung enthalten.
     */
    public void gerichtEntfernen(Gericht gericht) throws NoSuchElementException {

        //sucht nur selbiges Gericht (Bezeichner muss derselbe sein) (Storniere meine Cola, lass seine drin)
        if (!bestellung.contains(gericht)) { //vergleicht inhalt, aber nicht die Referenz (selbiges Gericht)
            throw new NoSuchElementException("Gericht nicht in der Bestellung gefunden");
        }

        //sucht auch gleiche (egal ob Bezeichner anders ist)
        /*
        for (Gericht g : bestellung) {
            if (g == gericht) {
                throw new NoSuchElementException("Gericht nicht in der Bestellung gefunden");
            }
        }*/
        bestellung.remove(gericht);
    }

    /**
     * Gibt die bisherige Bestellung aus,
     * indem pro Gericht die Informationen
     * als Listenstring abgerufen werden.
     * Wurde noch nichts bestellt, wird
     * dies stattdessen rückgemeldet.
     * (Exception wäre sonst auch möglich.)
     */
    public void getBestellungInfo() {
        if (bestellung.isEmpty())
            System.err.println("Keine Gerichte bislang bestellt!");
        else {
            System.out.println("Bisher bestellte Gerichte:");
            for (Gericht gericht : bestellung) {
                System.out.println(gericht.getInfo());
            }
        }
    }

    /**
     * Summiert die Preise aller Gerichte auf.
     *
     * @return Summe aller Preise als Kommazahl.
     * @throws ArithmeticException wenn Bestellsumme gleich 0 oder negativ.
     */
    public double berechneBestellung() throws ArithmeticException {
        double sum = 0.00;

        for (Gericht gericht : bestellung) {
            sum += gericht.getPreis();
        }

        if (sum <= 0)
            //Macht theoretisch auch wenig Sinn, wenn schon der Konstruktor verhindert,
            //dass für Gerichte negative Preise angegeben werden können.
            throw new ArithmeticException("Der Betrag muss positiv sein.");

        return sum;
    }

}
