package _20241209WdhKonzepte.AufgabeStatic;

public class Berechnung {

    public static double berechneRechteck(double länge, double breite) {
        return länge * breite;
    }

    public static double berechneKreis(double radius) {
        return Konstanten.PI * (radius * radius);
    }
}
