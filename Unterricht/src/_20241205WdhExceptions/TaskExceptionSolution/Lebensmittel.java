package _20241205WdhExceptions.TaskExceptionSolution;

import _20241205WdhExceptions.TaskExceptionSolution.ProductException.InvalidHaltbarkeitsdatumException;
import _20241205WdhExceptions.TaskExceptionSolution.ProductException.InvalidPreisException;

public class Lebensmittel extends Produkt {
    private String haltbarkeit;

    public Lebensmittel(String name, double preis, int lagerbestand, String haltbarkeit) throws InvalidPreisException, InvalidHaltbarkeitsdatumException {
        super(name, preis, lagerbestand);
        this.haltbarkeit = haltbarkeit;

        // Überprüfe, ob das Haltbarkeitsdatum gültig ist (beispielsweise ein einfaches Datum wie "2024-01-01")
        if (haltbarkeit.compareTo("2024-01-01") < 0) {  // Einfache Prüfung: Datum muss nach dem 01.01.2024 liegen
            throw new InvalidHaltbarkeitsdatumException("Das Haltbarkeitsdatum ist ungültig.");
        }
    }

    public void haltbarkeitsInfo() {
        System.out.println("Haltbarkeit: " + haltbarkeit);
    }
}