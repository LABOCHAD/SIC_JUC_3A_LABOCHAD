
package _20241210PflichtaufgabeMonsterGame.Monsterkampf;

import myTools.UserInputScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KampfArena {
    static Scanner scanner = new Scanner(System.in);

    List<Monster> monsterList = new ArrayList<>();
    Random random = new Random();
    String eingabe;
    boolean creationFailed;
    Monster eigenesMonster = null;

    public static void main(String[] args) {
        KampfArena arena = new KampfArena();
        arena.startFight();
        System.out.println("Danke fürs Spielen. Bye...");
        scanner.close();
    }


    /**
     * Zeigt die Details aller Monster in der Liste.
     */
    public void showAllMonster() {
        if (monsterList.isEmpty()) {
            System.err.println("Keine Monster hier.");
        } else {
            System.out.println("Monster in der Arena:");
            for (Monster m : monsterList) {
                m.getDetails();
            }
        }
    }


    /**
     * Lässt den Benutzer Gegner erstellen, bis er stopp schreibt.
     * Wird wiederholt, wenn Liste noch leer ist,
     * letzte Erstellung erfolglos war (Exception),
     * oder noch nicht stopp eingegeben wurde.
     * Gegner werden der Liste hinzugefügt.
     */
    public void erstelleGegner() {
        boolean stopp;

        System.out.println("Bevor wir starten, darfst du deine Gegner erschaffen.");
        System.out.println("Es werden Gegner erzeugt, bis du \"stopp\" sagst.");
        do {
            creationFailed = false;
            System.out.println("Was möchtest du hinzufügen? DRACHE oder ZENTAUR?");
            eingabe = scanner.nextLine();
            stopp = (eingabe.equalsIgnoreCase("stopp"));

            if (eingabe.equalsIgnoreCase("Drache")) {
                try {
                    monsterList.add(new Drache("Drache", 10, 2)); //Parameter erstmal fest.
                    System.out.println("Drache hinzugefügt.");
                } catch (MonsterException e) {
                    System.err.println(e.getMessage());
                    creationFailed = true;
                }
            }

            if (eingabe.equalsIgnoreCase("Zentaur")) {
                try {
                    monsterList.add(new Zentaur("Zentaur", 10, 2)); //Parameter erstmal fest.
                    System.out.println("Zentaur hinzugefügt.");
                } catch (MonsterException e) {
                    System.err.println(e.getMessage());
                    creationFailed = true;
                }
            }

            if (monsterList.isEmpty() && !creationFailed) //keine Meldung, wenn kein Stopp bei Erstlauf
                System.err.println("Es muss mindestens 1 Monster erstellt werden!");

        } while (!stopp || monsterList.isEmpty() || creationFailed);
    }

    /**
     * Lässt Spieler eigenes Monster erstellen.
     * Erstmal wird nur Name festgelegt.
     * Kampfparameter vorerst Hardcode.
     */
    public void erstelleEigenesMonster() {
        //eigenes Monster erstellen
        do {
            System.out.printf("%n%nWie soll dein Monster heißen?: ");
            eingabe = scanner.nextLine();

            try {
                eigenesMonster = new EigenesMonster(eingabe, 10, 5); //Parameter erstmal fest.
                creationFailed = false;
            } catch (MonsterException e) {
                System.err.println(e.getMessage());
                creationFailed = true;
            }
        } while (creationFailed);
        System.out.println("Eigenes Monster erstellt:");
        eigenesMonster.getDetails();
    }

    /**
     * Einfache Kampflogik in Form einer
     * Schleife, die endet, wenn entweder
     * das eigene Monster oder das in Form
     * des Gegners keine Lebenspunkte mehr hat.
     * Läuft bislang nur einmal und wählt den
     * Gegner zufällig aus.
     */
    public void startFight() {

        erstelleGegner();
        showAllMonster();
        erstelleEigenesMonster();
        boolean isPlayerDead = false;

        do {
            Monster gegner = monsterList.get(random.nextInt(monsterList.size()));
            System.out.printf("%n%n%s erscheint und fordert einen Kampf.%n", gegner.getName());
            do {
                System.out.printf("%nSpieler: ");
                eigenesMonster.getDetails();
                System.out.print("Gegner:  ");
                gegner.getDetails();

                System.out.println("Du bist am Zug.");
                eigenesMonster.angreifen(gegner);

                if (gegner.getLeben() <= 0) {
                    System.out.println("Gegner wurde besiegt.");
                    break;
                }

                System.out.println("Gegner ist am Zug.");
                gegner.angreifen(eigenesMonster);

                if (eigenesMonster.getLeben() <= 0) {
                    System.err.println("Dein Monster wurde besiegt.");
                    isPlayerDead = true;
                    break;
                }
                UserInputScanner.pressReturnToContinue(scanner);
            } while (true);

            monsterList.remove(gegner);
            if (monsterList.isEmpty())
                System.out.println("Alle Monster wurden besiegt");
            else
                System.out.println("Gegner wurde von der Liste entfernt");
            UserInputScanner.pressReturnToContinue(scanner);
        } while (!monsterList.isEmpty() && !isPlayerDead);
    }
}
