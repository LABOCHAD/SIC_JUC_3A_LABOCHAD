package _20241206PflichtaufgabeExceptions;

public class Getränk extends Gericht {

    public Getränk(String name, double preis, String beschreibung){
        super(name, preis, beschreibung);
    }

    public Getränk(){
        super("Getränk", 2.99, "Coca Cola");
    }

    @Override
    public double berechnePreis() {
        return this.getPreis();
    }
}
