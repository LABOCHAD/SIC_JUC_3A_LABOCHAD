package _20241205WdhExceptions.Einkaufsplattform;

public class Elektronik extends Produkt{
    int garantieJahre;

    Elektronik(String name, double preis, int lagerbestand, int garantieJahre) {
        super(name, preis, lagerbestand);
        this.garantieJahre = garantieJahre;
    }

    public void zeigeGarantieJahre(){
        System.out.printf("%nDie Garantie beträgt %d Jahre für dieses Produkt.%n",garantieJahre);
    }

    @Override
    public double anwendenRabatt(double prozent) throws InvalidPreisException {
        if (prozent != 5) prozent = 5; //nur bei Elektronik, Parameter kann nicht raus, weil Override.
        double rabatt = preis*(prozent/100); //erwäge InvalidPercentageException, wenn über 100
        if (rabatt < 0)
            throw new InvalidPreisException();
        return preis-rabatt;
    }
}
