package _20250205ZooAufgabe;

import java.time.Year;
import java.util.List;
import java.util.Random;


// Hauptklasse mit Test
public class Zoo {
    public static void main(String[] args) {
        System.out.println("🐾 Zoo wird gestartet...");

        // Erstellen von Tieren
        Löwe simba = new Löwe("Simba", 5, "goldgelb", "in der Sonne liegen");
        Schlange kaa = new Schlange("Kaa", 2, true);

        System.out.println("\n🐾 Tiere im Zoo:");
        System.out.println(simba);
        System.out.println(kaa);

        // Methodenaufrufe
        System.out.println("\n🎵 Tiergeräusche:");
        simba.macheGeräusch(); // Überschriebene Methode von Löwe
        kaa.macheGeräusch();    // Überschriebene Methode von Reptil

        // Spezielle Methoden der Unterklassen - Soll hier noch was anderes hin?
        System.out.println("\n🔊 Spezielle Aktionen:");
        simba.macheGeräusch();
        kaa.macheGeräusch();

        //Aufgabe 3.1.3
        //https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java
        int thisYear = Year.now().getValue();
        Tier tier = new Tier("Beispiel");
        Säugetier affe = new Säugetier("Donkey Kong", thisYear-1981,"braun"); //erstes release 1981
        Reptil schildkröte = new Reptil("Schildegard", 900, false);
        Löwe mufasa = new Löwe("Mufasa", thisYear-1994, "goldgelb","mit Simba spielen");
        Schlange medusa = new Schlange("Ein Haar der Medusa", 3000, true);

        System.out.println("\nAufgabe 3");
        tier.füttern("irgendwas");
        affe.füttern("Pflanzen"); //Banane passt leider nicht in die Anforderung
        affe.füttern("Snickers"); //wird nicht passen
        schildkröte.füttern("Eier"); //geht
        schildkröte.füttern("Bounty"); //geht nicht
        mufasa.füttern("Fleisch"); //geht
        mufasa.füttern("Twix"); //geht nicht
        medusa.füttern("Kleine Tiere"); //geht
        medusa.füttern("Mars"); //Lustig, weil römisches Pendant zu Ares, gleiche Mythologie

        //Aufgabe 4 - Erweiterungsaufgabe: Schwimmende Tiere im Zoo (nur das Nötigste, ohne Overrides, usw.)
        System.out.println("\nAufgabe 4");
        Otter otter = new Otter("Otter", 10, "grau");
        otter.schwimme();

        Krokodil krokodil = new Krokodil("Krokodil", 20, false);
        krokodil.schwimme();


    }

    //Aufgabe 5
    public static void füttereAlle(List<Tier> tiere, String futter){
        for (Tier t : tiere){
            if (new Random().nextBoolean())
                t.füttern(futter);
            else
                System.out.println(t.getName() + " ist schon satt und frisst nicht.");
        }
    }
}