package _20241209WdhKonzepte;

import java.util.ArrayList;
import java.util.List;

/**
 * Ich habe hier jeweils das Auto-Boxing/Unboxing verwendet.
 * Die anderen Möglichkeiten sind auskommentiert, damit man
 * sieht, dass ich mich gedanklich damit auseinandergesetzt habe.
 * Wenn das so einfach ist, wofür überhaupt die anderen Methoden?
 * Laufen die im Hintergrund bei Auto und sind deshalb notwendig?
 * Zeitlicher Rahmen bisher gut, aber ich musste mehrmals wieder
 * lesen, weil erst dann die Unterschiede deutlich wurden.
 * Auch fällt meist erst bei der Umsetzung auf, was falsch
 * bedacht wurde und wird dann on the fly korrigiert im Plan.
 * Am längsten dauert die Richtigstellung, wenn man merkt,
 * man hat sich vertan, verlesen oder etwas nicht bedacht.
 */
public class AufgabeWrapperUndCasten_Produktpreise {
    static final double MWST_SATZ = (double) 19 / 100;
    static List<Double> produktPreise = new ArrayList<>();

    //Versuche Methoden zu testen, weil noch Zeit ist.
    public static void main(String[] args) {

        Double testArtikel1 = 100.00;
        Double testArtikel2 = 333.33;
        produktPreise.add(testArtikel1);
        produktPreise.add(testArtikel2);

        //Test-Variablen
        double netto, steuer, brutto;
        int bruttoInCent;

        //netto = produktPreise.get(produktPreise.indexOf(testArtikel1)); //simuliere Datenbankzugriff, .get(0) ginge auch.

        for (Double d : produktPreise) {

            netto = d;
            System.out.printf("%nNettopreis in Euro     : %.2f", netto);

            steuer = getSteuerbetrag(netto);
            System.out.printf("%nMehrwertsteuer in Euro : %.2f",steuer);

            brutto = getBruttopreis(steuer, netto);
            System.out.printf("%nBruttopreis in Euro    : %.2f",brutto);

            bruttoInCent = getPreisInCent(brutto);
            System.out.printf("%nBruttopreis in Cent    : %d%n",bruttoInCent);
        }


    }


    /**
     * Erstelle eine Methode,
     * die einen Produktpreis als double empfängt,
     * diesen in ein Double (Wrapper-Klasse) umwandelt
     * und die Mehrwertsteuer, (z.B. 19 %) darauf berechnet.
     *
     * @param nettopreis Preis als primitiver double.
     * @return Steuerwert als Double (wrapped).
     */
    public static Double getSteuerbetrag(double nettopreis) {
        //3 Möglichkeiten von double zu Double:

        //1. Double D = Double.valueOf(doublePrimVal)
        //2. Double D = new Double(doublePrimVal) --> VERALTET seit Version 9!!!
        //3. Auto-Boxing (Double D = double d)

        //return Double.valueOf(nettopreis *MWST_SATZ); //unnötig
        return nettopreis * MWST_SATZ; //3.
    }

    /**
     * Erstelle eine Methode, die den Mehrwertsteuerbetrag als Double empfängt,
     * diesen in den primitiven Datentyp double umwandelt und
     * den Endpreis des Produkts berechnet (Preis inkl. MwSt.).
     * (Ich gehe mal davon aus, Rückgabe soll noch erfolgen?)
     *
     * @param steuerbetrag Prozentwert der Steuer vom Nettopreis.
     * @return Bruttopreis als double (unwrapped).
     */
    public static Double getBruttopreis(Double steuerbetrag, Double nettopreis) {
        //2 Möglichkeiten von Double zu double:

        //1. double d = D.doubleValue(doublePrimVal)
        //2. Auto-Unboxing (double d = Double D)

        //return nettopreis.doubleValue() + steuerbetrag.doubleValue(); //unnötig
        return nettopreis + steuerbetrag; //2.
    }

    /**
     * Empfange Bruttopreis,
     * wandle in double um
     * nehme mal 100 und
     * caste als integer.
     *
     * @param bruttopreis Bruttopreis
     * @return Betrag in Cent
     */
    public static int getPreisInCent(Double bruttopreis) {
        return (int) (bruttopreis * 100); //wieder auto-unboxing
    }

}
