package _DungeonCrawl.Solutions.Figuren.GegnerFiguren;

import _DungeonCrawl.Solutions.Figuren.Gegner;
import _DungeonCrawl.Solutions.Figuren.Spieler;

public class Geisterkrieger extends Gegner {

    public Geisterkrieger() {
        super("Gegner.Geisterkrieger", 50, 10);  // Der Gegner.Geisterkrieger hat 50 Gesundheit, 10 Angriff
    }

    @Override
    public void spezielleFähigkeit(Spieler spieler) {
        System.out.println("Der Gegner.Geisterkrieger wird unsichtbar und greift aus dem Schatten an!");
        int schaden = 20;
        this.setGesundheit(this.getGesundheit() - schaden);
        System.out.println("Du hast den unsichtbaren Gegner.Geisterkrieger getroffen!");
    }
}
