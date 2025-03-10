package _20241210PflichtaufgabeMonsterGame.Monsterkampf;

import myTools.UserInputScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KampfArena_ExceptionProvozierbarDISCONTINUED {
    static Scanner scanner = new Scanner(System.in);

    List<Monster> monsterList = new ArrayList<>();
    Random random = new Random();

    String eingabe;
    boolean creationFailed;
    Monster eigenesMonster = null;

    String name;
    int leben;
    int angriff;

    public static void main(String[] args) {
        KampfArena_ExceptionProvozierbarDISCONTINUED arena = new KampfArena_ExceptionProvozierbarDISCONTINUED();
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

    public void getMonsterParameter() {
        System.out.println("Gib einen Namen ein:");
        name = scanner.nextLine();
        System.out.println("Gib die Lebenspunkte ein:");
        leben = UserInputScanner.getInt(scanner); //extra nicht nur positive, um exception zu testen
        System.out.println("Gib die Angriffspunkte ein:");
        angriff = UserInputScanner.getInt(scanner); //extra nicht nur positive, um exception zu testen
    }


    public void erstelleGegner() {
        boolean stopp;
        boolean isDrache;
        boolean isZentaur;

        //Füge Monster der Liste hinzu
        System.out.println("Bevor wir starten, darfst du deine Gegner erschaffen.");
        System.out.println("Es werden Gegner erzeugt, bis du \"stopp\" sagst.");
        do {
            creationFailed = false;
            System.out.println("Was möchtest du hinzufügen? DRACHE oder ZENTAUR?");
            eingabe = scanner.nextLine();

            stopp = (eingabe.equalsIgnoreCase("stopp"));
            isDrache = eingabe.equalsIgnoreCase("Drache");
            isZentaur = eingabe.equalsIgnoreCase("Zentaur");


            if (isDrache || isZentaur) {
                getMonsterParameter();
                try {
                    if (isDrache) {
                        monsterList.add(new Drache(name, leben, angriff)); //Parameter erstmal fest.
                        System.out.println("Drache hinzugefügt.");
                    } else { //zentaur always true
                        monsterList.add(new Zentaur("Zentaur", 10, 2)); //Parameter erstmal fest.
                        System.out.println("Zentaur hinzugefügt.");
                    }
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
            getMonsterParameter();
            try {
                eigenesMonster = new EigenesMonster(name, leben, angriff);
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

        //Suche Gegner zufällig aus
        Monster gegner = monsterList.get(random.nextInt(monsterList.size()));

        System.out.printf("%n%n%s erscheint und fordert einen Kampf.%n", gegner.getName());
        do {
            System.out.printf("%nSpieler: ");
            eigenesMonster.getDetails();
            System.out.print("Gegner:  ");
            gegner.getDetails();

            System.out.println("Du bist am Zug");
            eigenesMonster.angreifen(gegner);

            if (gegner.getLeben() <= 0) {
                System.out.println("Gegner wurde besiegt.");
                break;
            }

            System.out.println("Gegner ist am Zug:");
            gegner.angreifen(eigenesMonster);

            if (eigenesMonster.getLeben() <= 0) {
                System.err.println("Dein Monster wurde besiegt.");
                break;
            }
            UserInputScanner.pressReturnToContinue(scanner);
        } while (true);

    }
}
