package _20241206PflichtaufgabeExceptions;


public class Pizza extends Gericht {
    public Pizza(String name, double preis, String beschreibung) {
        super(name, preis, beschreibung);
    }

    public Pizza() {
        super("Pizza", 5.00, "Margaritha klein (mit Tomatensoße und Käse)");
    }

    @Override
    public double berechnePreis() {
        return this.getPreis();
    }
}

