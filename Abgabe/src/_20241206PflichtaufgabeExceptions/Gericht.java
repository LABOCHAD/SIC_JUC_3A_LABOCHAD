package _20241206PflichtaufgabeExceptions;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Allgemeine Klasse für Gerichte.
 * Beschreibung und Ausgabe der Infos.
 * bereits hier, weil sonst redundant.
 * Konstruktor entsprechend erweitert.
 * Enthält also Name, Preis und eine
 * Beschreibung des Gerichtes anbei.
 * Berechnet Preis und zeigt Infos an.
 * Setter erstmal weggelassen, weil
 * noch nicht benötigt. Würde sonst
 * nur unnötig Datenkapselung umgehen.
 */
public abstract class Gericht {
    private final String name;
    private final double preis; //kann auch final, weil Rabatt wäre Return auf Grundlage des Grundpreises
    private final String beschreibung;

    /**
     * Superkonstruktor für Gerichte.
     *
     * @param name         Bezeichnung
     * @param preis        Preis
     * @param beschreibung Beschreibung
     * @throws NullPointerException   wenn kein Name übergeben oder
     *                                Preis nicht positiv ist.
     * @throws InputMismatchException wenn Preis keine Zahl ist.
     */
    public Gericht(String name, double preis, String beschreibung)
            throws NullPointerException, InputMismatchException {
        //name == null, not equals, because null isn't a content but referred, don't think of primitives.
        if (preis <= 0 || name == null)
            //Preis kann nicht hardcoded auf null (!= 0) getestet werden; Computer sagt nein.
            //java: Inkompatible Typen: <nulltype> kann nicht in double konvertiert werden
            //Cannot invoke "java.lang.Double.doubleValue()" because "nullTest" is null
            throw new NullPointerException("Gericht muss einen Namen und einen positiven Preis haben.");
        try {
            this.preis = preis;
        } catch (InputMismatchException e) {
            //Ich weiß nicht, wie ich dem Konstruktor einen Wert für Preis unterschieben soll,
            //der kein Double ist. Alles, was das provozieren könnte, verhindert der Compiler.
            //Ich bezweifle also die Sinnhaftigkeit dieser Exception.
            throw new InputMismatchException("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
        }

        this.name = name;
        this.beschreibung = beschreibung;
    }

    /**
     * Gibt bislang nur den Preis des Gerichtes zurück.
     * Dies ist optional erweiterbar um ein Rabattsystem.
     * Rabatt dürfte dann wohl je gericht-spezifisch sein.
     * Ohne Rabatt würde eine konkrete Methode
     * hier aber direkt mehr Sinn machen, bzw.
     * einfach nur der getter für den Preis.
     * Ich lasse das jetzt mal bewusst offen.
     */
    public abstract double berechnePreis();

    /**
     * Sammelt Attribute des Gerichtes und
     * gibt diese gebündelt als String aus.
     * Nutze hier eine ArrayList für bessere
     * Flexibilität im Falle von Umbauten.
     *
     * @return Informationen als String [a,b,c]
     */
    public String getInfo() {
        ArrayList<String> infos = new ArrayList<>();
        infos.add("Name: " + name);
        infos.add("Preis: " + preis); //formater wenn nicht 2-stellig?
        infos.add("Beschreibung: " + beschreibung);
        return infos.toString();
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

}
