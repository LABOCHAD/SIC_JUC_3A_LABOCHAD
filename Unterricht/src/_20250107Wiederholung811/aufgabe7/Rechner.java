package _20250107Wiederholung811.aufgabe7;

class Rechner {
    final static double PI = 3.14;
    double ergebnis;

    static double berechneKreisumfang(double radius) {
        //r = PI *d bzw r = PI * r*2
        return PI * radius * 2;
    }

    //Gewollt Instanz, kein static vergessen
    double addiere(double a, double b) {
        return a + b;
    }

    static class MathUtils {
        static double multiplikation(double a, double b) {
            return a * b;
        }
    }

    public static void main(String[] args) {
        double umfang = Rechner.berechneKreisumfang(3);
        System.out.println("Kreisumfang: " + umfang);

        Rechner test = new Rechner();
        test.ergebnis = test.addiere(1.5, 3.5); //nur test
        System.out.println("Ergebnis der Addition: " + test.ergebnis);

        double produkt = MathUtils.multiplikation(Rechner.PI, 3.5);
        System.out.println("Produkt: " + produkt);
    }
}
