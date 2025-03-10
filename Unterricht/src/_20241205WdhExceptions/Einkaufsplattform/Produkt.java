package _20241205WdhExceptions.Einkaufsplattform;

public abstract class Produkt {
    String name;
    double preis;
    int lagerbestand;

    Produkt(String name, double preis, int lagerbestand) throws InvalidPreisException{
        this.name = name;
        if (preis < 0)
            throw new InvalidPreisException();
        this.preis = preis;
        this.lagerbestand = lagerbestand;
    }

    //Zusatzaufgabe1
    public abstract double anwendenRabatt(double prozent) throws InvalidPreisException;

    public void verkaufen(int menge) throws NichtGenugLagerbestandException{
        if (menge > lagerbestand){
            throw new NichtGenugLagerbestandException();
        } else {
            lagerbestand -= menge;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getLagerbestand() {
        return lagerbestand;
    }

    public void setLagerbestand(int lagerbestand) {
        this.lagerbestand = lagerbestand;
    }
}
