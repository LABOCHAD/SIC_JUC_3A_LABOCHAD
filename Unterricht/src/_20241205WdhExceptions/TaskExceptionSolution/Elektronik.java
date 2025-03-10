package _20241205WdhExceptions.TaskExceptionSolution;

import _20241205WdhExceptions.TaskExceptionSolution.ProductException.InvalidPreisException;

public class Elektronik extends Produkt {
    private int garantieJahre;

    public Elektronik(String name, double preis, int lagerbestand, int garantieJahre) throws InvalidPreisException {
        super(name, preis, lagerbestand);
        this.garantieJahre = garantieJahre;
    }

    public void garantieInfo() {
        System.out.println("Garantie: " + garantieJahre + " Jahre");
    }
}
