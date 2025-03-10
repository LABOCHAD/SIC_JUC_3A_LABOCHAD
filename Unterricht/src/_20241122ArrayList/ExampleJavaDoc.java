package _20241122ArrayList;

public class ExampleJavaDoc {
    //Einzeilige Kommentare: Gezielt verwenden
    private double number;
    /* Mehrzeilige Kommentare: Besonders interessant zum Code auskommentieren
    private String word;
    */

    /**
     * Später bitte in Englisch.
     * Platz zum beschreiben der Methode: Alles was die Methode machen soll
     * @param x Irgendeine Zahl zB
     * @param y Beschreibung der zweiten Eingabe
     * @author Heinzelmännchen
     * @since 22.11.2024
     * @return Die Summe von zwei Zahlen.
     */
    public int addNumbers(int x, int y) {
        int sum = x + y;
        return sum;
    }

    /**
     * Beschreibung der Methode
     * @param x Beschreibung des ersten Parameters
     * @param y Beschreibung des zweiten Parameters
     * @return Beschreibung des Return-Werts
     */
    public double subNumbers(double x, double y) {
        double diff = x - y;
        return diff;
    }

    /**
     * Beschreibung der Methode
     * @param x Beschreibung des ersten Parameters
     * @param y Beschreibung des zweiten Parameters
     */
    private void createANewNumber(double x, double y) {
        number = x + y * 2 % 3;
    }

    /**
     * Beschreibung der Methode
     * @param x Beschreibung des ersten Parameters
     * @param y Beschreibung des zweiten Parameters
     */
    public double calculation(double x, double y) {
        createANewNumber(x, y);
        addNumbers(3,4);
        return subNumbers(x, y) + number;
    }

    /**
     * Beschreibung der Methode
     */
    private void illDoNothing(){}
}
