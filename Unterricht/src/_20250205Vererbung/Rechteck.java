package _20250205Vererbung;

public class Rechteck {
    private double breite;
    private double hoehe;

    Rechteck(double breite, double hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public double berechneFlaeche() {
        return hoehe * breite;
    }

    public double getBreite() {
        return breite;
    }
}
