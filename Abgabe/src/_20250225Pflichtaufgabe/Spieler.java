package _20250225Pflichtaufgabe;

import java.util.Objects;

public class Spieler {
    private String name;
    private int rueckennummer;

    // DONE erstelle einen Konstruktor, welcher name und rueckennummer initialisiert
    Spieler(String name, int rueckennummer) {
        this.name = name;
        this.rueckennummer = rueckennummer;
    }

    // DONE erstelle getter für die Attribute

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRueckennummer() {
        return rueckennummer;
    }

    public void setRueckennummer(int rueckennummer) {
        this.rueckennummer = rueckennummer;
    }


    // DONE überschreibe toString() und gebe z.B. "Spieler: Max Nr. 90" aus
    @Override
    public String toString() {
        return String.format("Spieler: %s Nr. %d", name, rueckennummer);
    }

    @Override
    public boolean equals(Object o) { //falls ich doch die Spielernummern mit berücksichtigen will
        if (o == null || getClass() != o.getClass()) return false;
        Spieler spieler = (Spieler) o;
        return rueckennummer == spieler.rueckennummer && Objects.equals(name, spieler.name);
    }

}
