package _20241205WdhExceptions.TaskExceptionSolution;

import _20241205WdhExceptions.TaskExceptionSolution.ProductException.InvalidPreisException;
import _20241205WdhExceptions.TaskExceptionSolution.ProductException.NichtGenugLagerbestandException;

public abstract class Produkt {
    private String name;
    private double preis;
    private int lagerbestand;

    public Produkt(String name, double preis, int lagerbestand) throws InvalidPreisException {
        this.name = name;
        if (preis < 0) {
            throw new InvalidPreisException("Der Preis kann nicht negativ sein.");
        }
        this.preis = preis;
        this.lagerbestand = lagerbestand;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public int getLagerbestand() {
        return lagerbestand;
    }

    public void verkaufen(int menge) throws NichtGenugLagerbestandException {
        if (lagerbestand < menge) {
            throw new NichtGenugLagerbestandException("Nicht genug Lagerbestand für das Produkt.");
        }
        lagerbestand -= menge;
    }
}
