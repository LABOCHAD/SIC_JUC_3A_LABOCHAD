package _20241220_Wiederholungsaufgaben1_8;

import myTools.Color;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe8_AlleMitAllen {
    public static void main(String[] args) {
        //TODO Danke, dass du das ehrlich angibst! Damit ist es als Zitat auch in angemessenem Rahmen ok
        //BEISPIELE FÜR DIE LISTEN KI-GENERIERT (GEMINI)!
        //Anfang KI-generierter Teil - hier Vorschlag der IDE angenommen, Befüllen bei Deklaration
        ArrayList<String> subjekte = new ArrayList<>(List.of("Der Mann", "Die Frau", "Das Kind", "Der Hund", "Die Katze",
                "Der Vogel", "Die Maus", "Das Pferd", "Die Kuh", "Der Fisch",
                "Der Baum", "Das Haus", "Das Auto", "Der Computer", "Das Buch"));
        ArrayList<String> prädikate = new ArrayList<>(List.of("läuft", "springt", "fliegt", "schwimmt", "schläft", "isst", "trinkt",
                "spielt", "arbeitet", "lernt", "ist", "hat", "wird", "kann", "muss",
                "sieht", "hört", "riecht", "schmeckt", "fühlt", "denkt", "weiß", "glaubt",
                "hofft", "fürchtet", "wächst", "schrumpft"));
        ArrayList<String> objekte = new ArrayList<>(List.of("den Ball", "das Buch", "den Apfel", "die Birne", "die Blume",
                "das Haus", "das Auto", "den Computer", "das Handy", "das Geschenk",
                "die Wahrheit", "die Lüge", "die Hoffnung", "den Traum", "die Angst"));
        //Ende KI-generierter Teil (bis auf die Namen für die Listen)

        System.out.println("Anzahl Subjekte: " + subjekte.size());
        System.out.println("Anzahl Prädikate: " + prädikate.size());
        System.out.println("Anzahl Objekte: " + objekte.size());

        for (String subjekt : subjekte) {
            for (String prädikat : prädikate) {
                for (String objekt : objekte) {
                    System.out.printf("%n%s%s %s%s %s%s%s.",
                            Color.RED, subjekt,
                            Color.YELLOW, prädikat,
                            Color.GREEN, objekt, Color.RESET);
                }
            }
        }


    }
}
