package _20241206PflichtaufgabeExceptions;

public class Pasta extends Gericht {
    public Pasta(String name, double preis, String beschreibung){
        super(name, preis, beschreibung);
    }

    public Pasta(){
        super("Pasta", 4.50, "Spaghetti Bolognese");
    }

    @Override
    public double berechnePreis() {
        return this.getPreis();
    }
}
