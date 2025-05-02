package _DungeonCrawl.Solutions.Figuren.GegnerFiguren;

import _DungeonCrawl.Solutions.Figuren.Gegner;
import _DungeonCrawl.Solutions.Figuren.Spieler;

public class Feuerdrache extends Gegner {

    public Feuerdrache() {
        super("Gegner.Feuerdrache", 70, 20);  // Der Drache hat 70 Gesundheit, 20 Angriff
    }

    @Override
    public void spezielleFähigkeit(Spieler spieler) {
        System.out.println("Der Gegner.Feuerdrache entfacht einen Flammensturm!");
        int feuerSchaden = 10;
        this.setGesundheit(this.getGesundheit() - feuerSchaden);
        System.out.println("Der Drache nimmt 10 Schaden durch den Flammensturm.");
    }
}
