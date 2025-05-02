package _DungeonCrawl.Solutions.Figuren.GegnerFiguren;

import _DungeonCrawl.Solutions.Figuren.Gegner;
import _DungeonCrawl.Solutions.Figuren.Spieler;

public class Giftkreatur extends Gegner {

    public Giftkreatur() {
        super("Gegner.Giftkreatur", 60, 15);  // Die Kreatur hat 60 Gesundheit, 15 Angriff
    }

    @Override
    public void spezielleFähigkeit(Spieler spieler) {
        System.out.println("Die Gegner.Giftkreatur vergiftet dich!");
        int vergiftungsSchaden = 5;
        spieler.setGesundheit(spieler.getGesundheit() - vergiftungsSchaden);
        System.out.println("Du hast 5 Vergiftungsschaden erlitten.");
    }
}
