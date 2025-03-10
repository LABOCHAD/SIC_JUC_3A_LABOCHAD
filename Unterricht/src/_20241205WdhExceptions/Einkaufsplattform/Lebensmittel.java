package _20241205WdhExceptions.Einkaufsplattform;

public class Lebensmittel extends Produkt{
    String haltbarkeit;

    Lebensmittel(String name, double preis, int lagerbestand, String haltbarkeit) {
        super(name, preis, lagerbestand);
        this.haltbarkeit = haltbarkeit;
    }

    public void pruefeMHD(String datum) throws InvalidHaltbarkeitsdatumException{
        if (!datum.equals(haltbarkeit)){ //besser mit Regex und numerischer Auswertung, Datumsformat, etc.
            throw new InvalidHaltbarkeitsdatumException();
        }
        System.out.println("MHD ist gültig. (Momentan nur gleich)");
    }

    @Override
    public double anwendenRabatt(double prozent) throws InvalidPreisException {
        double rabatt = preis*(prozent/100);
        if (rabatt < 0)
            throw new InvalidPreisException();
        return preis-rabatt;
    }
}
