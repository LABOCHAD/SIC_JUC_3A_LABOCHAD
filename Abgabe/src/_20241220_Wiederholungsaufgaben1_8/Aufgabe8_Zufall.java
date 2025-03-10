package _20241220_Wiederholungsaufgaben1_8;

import myTools.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aufgabe8_Zufall {
    public static void main(String[] args) {
        ArrayList<String> subjekte = new ArrayList<>();
        ArrayList<String> prädikate = new ArrayList<>();
        ArrayList<String> objekte = new ArrayList<>();
        Random random = new Random();

        //BEISPIELE FÜR DIE LISTEN KI-GENERIERT (GEMINI)!
        //Anfang KI-generierter Teil
        subjekte.addAll(List.of("Der Mann", "Die Frau", "Das Kind", "Der Hund", "Die Katze",
                "Der Vogel", "Die Maus", "Das Pferd", "Die Kuh", "Der Fisch",
                "Der Baum", "Das Haus", "Das Auto", "Der Computer", "Das Buch"));
        prädikate.addAll(List.of("läuft", "springt", "fliegt", "schwimmt", "schläft", "isst", "trinkt",
                "spielt", "arbeitet", "lernt", "ist", "hat", "wird", "kann", "muss",
                "sieht", "hört", "riecht", "schmeckt", "fühlt", "denkt", "weiß", "glaubt",
                "hofft", "fürchtet", "wächst", "schrumpft"));
        objekte.addAll(List.of("den Ball", "das Buch", "den Apfel", "die Birne", "die Blume",
                "das Haus", "das Auto", "den Computer", "das Handy", "das Geschenk",
                "die Wahrheit", "die Lüge", "die Hoffnung", "den Traum", "die Angst"));
        //Ende KI-generierter Teil

        System.out.println("Anzahl Subjekte: " + subjekte.size());
        System.out.println("Anzahl Prädikate: " + prädikate.size());
        System.out.println("Anzahl Objekte: " + objekte.size());

        //TODO Wie könnte man einen vollständig random generierten Satz erzeugen?
        System.out.println("\n" + Color.RED + "Bilde aus jedem Subjekt einen Satz:");
        for (String subjekt : subjekte) {
            String prädikat = prädikate.get(random.nextInt(prädikate.size()));
            String objekt = objekte.get(random.nextInt(objekte.size()));
            System.out.printf("%n%s %s %s.", subjekt, prädikat, objekt);
        }


        System.out.println("\n\n" + Color.YELLOW + "Bilde aus jedem Prädikat einen Satz:");
        for (String prädikat : prädikate) {
            String subjekt = subjekte.get(random.nextInt(subjekte.size()));
            String objekt = objekte.get(random.nextInt(objekte.size()));
            System.out.printf("%n%s %s %s.", subjekt, prädikat, objekt);
        }


        System.out.println("\n\n" + Color.GREEN + "Bilde aus jedem Objekt einen Satz:");
        for (String objekt : objekte) {
            String subjekt = subjekte.get(random.nextInt(subjekte.size()));
            String prädikat = prädikate.get(random.nextInt(prädikate.size()));
            System.out.printf("%n%s %s %s.", subjekt, prädikat, objekt);
        }
        System.out.println(Color.RESET);


    }
}
