package _20250204InterfacesUndAbstrakteKlassen;

import _20250204InterfacesUndAbstrakteKlassen.klanggeber.Gitarre;
import _20250204InterfacesUndAbstrakteKlassen.klanggeber.Klanggeber;
import _20250204InterfacesUndAbstrakteKlassen.klanggeber.Lautsprecher;
import _20250204InterfacesUndAbstrakteKlassen.tiere.Löwe;
import _20250204InterfacesUndAbstrakteKlassen.tiere.Papagei;


public class Main {
    public static void main(String[] args) {
        testeKlanggeber();
        testeTiere();
    }

    public static void testeTiere(){
        Löwe löwe = new Löwe("Mufasa");
        löwe.geraeuschMachen();
        löwe.laufen(); //geht nicht, wenn Löwe als Tier erstellt wird.

        Papagei papagei = new Papagei("Potty");
        papagei.geraeuschMachen();
    }

    public static void testeKlanggeber(){
        Klanggeber guitar = new Gitarre();
        Klanggeber speaker = new Lautsprecher();

        //statische konkrete Methode (dem Interface gehörend)
        Klanggeber.info();

        //default konkrete Methode (den objekten gehörend)
        guitar.spieleTon();
        speaker.spieleTon();

        //abstrakte Methoden (auch den Objekten gehörend)
        guitar.erzeugeKlang();
        speaker.erzeugeKlang();
    }
}
