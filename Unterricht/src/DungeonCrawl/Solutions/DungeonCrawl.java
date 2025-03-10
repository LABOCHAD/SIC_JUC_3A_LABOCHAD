package DungeonCrawl.Solutions;

import DungeonCrawl.Solutions.Figuren.Gegner;
import DungeonCrawl.Solutions.Figuren.GegnerFiguren.Feuerdrache;
import DungeonCrawl.Solutions.Figuren.GegnerFiguren.Geisterkrieger;
import DungeonCrawl.Solutions.Figuren.GegnerFiguren.Giftkreatur;
import DungeonCrawl.Solutions.Figuren.GegnerFiguren.Schattengolem;
import DungeonCrawl.Solutions.Figuren.Spieler;
import DungeonCrawl.Solutions.Raetsel.Raetsel;
import DungeonCrawl.Solutions.Raetsel.Varianten.MathematikRaetsel;
import DungeonCrawl.Solutions.Raetsel.Varianten.WortAnagrammRaetsel;
import DungeonCrawl.Solutions.Raetsel.Varianten.ZahlenRaetsel;

import java.util.Scanner;

public class DungeonCrawl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kapitel 1: Der Eingang des Dungeons
        Spieler spieler = new Spieler("Abenteurer", 100, 20);

        System.out.println("Du stehst vor dem Eingang des Dungeons.");
        System.out.println("Eine massive Eisentür und eine hölzerne Tür stehen dir offen.");
        System.out.println("1. Gehe durch die Eisentür.");
        System.out.println("2. Versuche, die hölzerne Tür zu öffnen.");
        int entscheidung = scanner.nextInt();

        if (entscheidung == 1) {
            // Kapitel 2: Der Kampf mit einem zufälligen Gegner.Gegner
            // Wahl der Gegner.Gegner
            Gegner gegner1 = wähleGegner();
            System.out.println("Du betrittst einen Raum und siehst einen " + gegner1.getName() + "!");
            System.out.println("Was möchtest du tun?");
            System.out.println("1. Kämpfen");
            System.out.println("2. Fliehen");

            entscheidung = scanner.nextInt();
            if (entscheidung == 1) {
                // Kampf gegen den zufälligen Gegner.Gegner
                System.out.println("Du kämpfst gegen " + gegner1.getName() + "!");
                while (!spieler.istTot() && !gegner1.istTot()) {
                    spieler.angriff(gegner1);
                    if (!gegner1.istTot()) {
                        gegner1.angriff(spieler);
                        gegner1.spezielleFähigkeit(spieler);  // Gegner.Gegner benutzt seine spezielle Fähigkeit
                    }
                }
                if (spieler.istTot()) {
                    System.out.println("Du bist gestorben! Das Spiel ist vorbei.");
                    return;
                } else {
                    System.out.println("Du hast " + gegner1.getName() + " besiegt!");
                }
            } else if (entscheidung == 2) {
                System.out.println("Du hast beschlossen, vor " + gegner1.getName() + " zu fliehen.");
                return;
            } else {
                System.out.println("Ungültige Eingabe.");
                return;
            }

        } else if (entscheidung == 2) {
            // Weitere Abenteuerlogik, wie z.B. durch die Holz-Tür gehen
            System.out.println("Du gehst vorsichtig durch und gelangst in einen Raum voller Fallen.");
            Raetsel raetsel = wähleRaetsel(scanner);

            System.out.println("Du hast einen geheimen Raum erreicht, in dem ein Rätsel auf dich wartet.");
            raetsel.ausgabeFrage();

            scanner.nextLine(); // Clear buffer
            String antwort = scanner.nextLine();

            if (raetsel.loesen(antwort)) {
                System.out.println("Das war die richtige Antwort! Du hast das Rätsel gelöst.");
            } else {
                System.out.println("Das war leider die falsche Antwort.");
                System.out.println("Eine magische Falle wird ausgelöst und du wirst getötet verletzt.");
                spieler.setGesundheit(0);
                return;
            }
        } else {
            System.out.println("Ungültige Eingabe.");
            return;
        }

        //Neuer Kampf
        Gegner gegner2 = wähleGegner();
        System.out.println("Du betrittst eine Höhle und siehst einen " + gegner2.getName() + "!");
        System.out.println("Was möchtest du tun?");
        System.out.println("1. Kämpfen");
        System.out.println("2. Fliehen");

        entscheidung = scanner.nextInt();
        if (entscheidung == 1) {
            // Kampf gegen den zufälligen Gegner.Gegner
            System.out.println("Du kämpfst gegen " + gegner2.getName() + "!");
            while (!spieler.istTot() && !gegner2.istTot()) {
                spieler.angriff(gegner2);
                if (!gegner2.istTot()) {
                    gegner2.angriff(spieler);
                    gegner2.spezielleFähigkeit(spieler);  // Gegner.Gegner benutzt seine spezielle Fähigkeit
                }
            }
            if (spieler.istTot()) {
                System.out.println("Du bist gestorben! Das Spiel ist vorbei.");
                return;
            } else {
                System.out.println("Du hast " + gegner2.getName() + " besiegt!");
            }
        } else if (entscheidung == 2) {
            System.out.println("Du hast beschlossen, vor " + gegner2.getName() + " zu fliehen.");
            return;
        } else {
            System.out.println("Ungültige Eingabe.");
            return;
        }
        //Neuer Kampf
        Gegner gegner3 = wähleGegner();
        System.out.println("Du betrittst eine Höhle und siehst einen " + gegner3.getName() + "!");
        System.out.println("Was möchtest du tun?");
        System.out.println("1. Kämpfen");
        System.out.println("2. Fliehen");

        entscheidung = scanner.nextInt();
        if (entscheidung == 1) {
            // Kampf gegen den zufälligen Gegner.Gegner
            System.out.println("Du kämpfst gegen " + gegner3.getName() + "!");
            while (!spieler.istTot() && !gegner3.istTot()) {
                spieler.angriff(gegner3);
                if (!gegner3.istTot()) {
                    gegner3.angriff(spieler);
                    gegner3.spezielleFähigkeit(spieler);  // Gegner.Gegner benutzt seine spezielle Fähigkeit
                }
            }
            if (spieler.istTot()) {
                System.out.println("Du bist gestorben! Das Spiel ist vorbei.");
                return;
            } else {
                System.out.println("Du hast " + gegner3.getName() + " besiegt!");
            }
        } else if (entscheidung == 2) {
            System.out.println("Du hast beschlossen, vor " + gegner3.getName() + " zu fliehen.");
            return;
        } else {
            System.out.println("Ungültige Eingabe.");
            return;
        }
        // Kapitel 4: Die Entscheidung über das Artefakt
        System.out.println("Du erreichst das Erbe der Dunkelheit, ein mächtiges Artefakt in einem glänzenden Kristall.");
        System.out.println("Der Dunkle Wächter tritt vor und stellt dir eine Frage:");
        System.out.println("\"Bist du bereit, den Preis der Macht zu zahlen? Der Kristall verleiht dir ungeahnte Kräfte, aber er nimmt auch etwas von dir.\"");
        System.out.println("1. Nimm das Artefakt.");
        System.out.println("2. Lasse das Artefakt zurück.");

        entscheidung = scanner.nextInt();
        if (entscheidung == 1) {
            System.out.println("Du hast das Artefakt genommen und fühlst plötzlich die Macht in dir aufsteigen!");
            System.out.println("Doch du merkst, dass du etwas Wichtiges verloren hast... Deine Freiheit.");
            System.out.println("Du bist nun ein mächtiger, aber gefangener Wächter des Dungeons.");
        } else if (entscheidung == 2) {
            System.out.println("Du hast das Artefakt zurückgelassen und den Dungeon verlassen.");
            System.out.println("Du hast dich entschieden, den Preis der Macht nicht zu zahlen.");
        } else {
            System.out.println("Ungültige Eingabe.");
        }

        System.out.println("Das Spiel ist zu Ende.");
    }

    public static Gegner wähleGegner() {
        // Zufälliger Gegner.Gegner
        int zufall = (int) (Math.random() * 4);
        switch (zufall) {
            case 0: return new Schattengolem();
            case 1: return new Feuerdrache();
            case 2: return new Giftkreatur();
            case 3: return new Geisterkrieger();
            default: return new Schattengolem();
        }
    }

    public static Raetsel wähleRaetsel(Scanner scanner) {
        // Zufälliges Rätsel
        int zufall = (int) (Math.random() * 3);
        return switch (zufall) {
            case 1 -> new ZahlenRaetsel();  // Unser neues Zahlenrätsel
            case 2 -> new WortAnagrammRaetsel();  // Unser neues Wortanagramm-Rätsel
            default -> new MathematikRaetsel("Was ist 12 + 7?", "19");
        };
    }
}
