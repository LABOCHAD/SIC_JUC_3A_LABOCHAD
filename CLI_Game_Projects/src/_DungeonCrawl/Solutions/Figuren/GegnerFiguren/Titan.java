package _DungeonCrawl.Solutions.Figuren.GegnerFiguren;

import _DungeonCrawl.Solutions.Figuren.Gegner;
import _DungeonCrawl.Solutions.Figuren.Spieler;

public class Titan extends Gegner {

    public Titan() {
        super("Gegner.Titan", 150, 40);  // Der Gegner.Titan hat 150 Gesundheit, 40 Angriff
    }

    @Override
    public void spezielleFähigkeit(Spieler spieler) {
        System.out.println("Der Gegner.Titan schlägt mit seiner riesigen Faust!");
        int schaden = 30;
        spieler.setGesundheit(spieler.getGesundheit() - schaden);
        System.out.println("Du hast 30 Schaden durch den Titanenangriff erlitten.");
    }
}
