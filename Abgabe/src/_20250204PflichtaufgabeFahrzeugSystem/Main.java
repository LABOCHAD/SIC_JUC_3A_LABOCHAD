package _20250204PflichtaufgabeFahrzeugSystem;

public class Main {
    public static void main(String[] args) {
        //1. Erstelle eine Flotte.
        Flotte flotte = new Flotte();

        //2. Erzeuge mindestens zwei Autos und zwei Motorräder mit unterschiedlichen Werten.
        Auto corsa = new Auto("Corsa","EL XX XXX",180,3);
        Auto meriva = new Auto("Meriva","EL XX YYY",200,5);

        Motorrad harley = new Motorrad("Harley Davidson", "AB CD XYZ", 250, true);
        Motorrad eierfeile = new Motorrad("Alte Möhre", "AB YZ", 25, false);

        //3. Füge die Fahrzeuge zur Flotte hinzu.
        flotte.fahrzeugHinzufuegen(corsa);
        flotte.fahrzeugHinzufuegen(meriva);
        flotte.fahrzeugHinzufuegen(harley);
        flotte.fahrzeugHinzufuegen(eierfeile);

        //4. Zeige alle Fahrzeuge an.
        flotte.alleFahrzeugeAnzeigen();

        //5. Beschleunige einige Fahrzeuge mit unterschiedlichen Methodenüberladungen.
        corsa.beschleunigen(100);
        meriva.beschleunigen(200, 20);
        harley.beschleunigen(200, 6);
        eierfeile.beschleunigen(250);

        //6. Teste die statusAnzeigen()-Methode der Fahrzeuge.
        for (Fahrzeug f : flotte.getFahrzeuge()){
            f.statusAnzeigen();
        }

        //7. Rufe die allgemeineInfo()-Methode des Interfaces auf.
        Fahrzeug.allgemeineInfo();

        //8. Gib die Anzahl der gespeicherten Fahrzeuge aus.
        flotte.gesamtAnzahlFahrzeuge();




    }
}
