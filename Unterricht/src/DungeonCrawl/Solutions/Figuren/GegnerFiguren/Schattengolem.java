package DungeonCrawl.Solutions.Figuren.GegnerFiguren;

import DungeonCrawl.Solutions.Figuren.Gegner;
import DungeonCrawl.Solutions.Figuren.Spieler;

public class Schattengolem extends Gegner {

    public Schattengolem() {
        super("Gegner.Schattengolem", 50, 15);  // Der Golem hat 50 Gesundheit, 15 Angriff
    }

    @Override
    public void spezielleFähigkeit(Spieler spieler) {
        System.out.println("Der Gegner.Schattengolem nutzt seine Schattenkraft, um sich zu heilen!");
        this.setGesundheit(this.getGesundheit() + 10);  // Der Golem heilt sich um 10 Gesundheit
    }
}
