package _20241122ArrayList;

import java.util.ArrayList;

/**
 * Diese Klasse stellt eine Obstkiste dar und führt mehrere Operationen auf einer Liste von Obstsorten durch.
 */
public class ObstkisteMusterloesung {

    /**
     * Hauptmethode, um die Aufgaben zu demonstrieren.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        // Schritt 1: Erstellen der Obstkiste als ArrayList und Hinzufügen von mindestens 3 Obstsorten
        ArrayList<String> obstKiste = new ArrayList<>();
        obstKiste.add("Apfel");
        obstKiste.add("Banane");
        obstKiste.add("Orange");

        // Ausgabe des aktuellen Stands der Obstkiste
        System.out.println("Aktuelle Obstkiste: " + obstKiste);

        // Schritt 2: Ausgabe des ersten Elements der Liste
        System.out.println("Das erste Obst in der Kiste ist: " + obstKiste.get(0));

        // Schritt 3: Entfernen einer Frucht und Ausgabe der neuen Obstkiste
        obstKiste.remove("Banane"); // Entfernen der Banane
        System.out.println("Nach dem Entfernen einer Frucht: " + obstKiste);

        // Schritt 4: Bestimmen der Größe der Obstkiste und Ausgabe
        int groesse = obstKiste.size();
        System.out.println("Die Obstkiste enthält " + groesse + " Früchte.");

        // Schritt 5: Überprüfen, ob die Kiste ein bestimmtes Obst enthält
        String obstZuPruefen = "Apfel";
        boolean enthält = obstKiste.contains(obstZuPruefen);
        if (enthält) {
            System.out.println("Die Obstkiste enthält einen " + obstZuPruefen + ".");
        } else {
            System.out.println("Die Obstkiste enthält keinen " + obstZuPruefen + ".");
        }

        // Schritt 6: Leeren der Obstkiste und Ausgabe des Stands
        obstKiste.clear();
        System.out.println("Nach dem Leeren der Obstkiste: " + obstKiste);
    }
}

