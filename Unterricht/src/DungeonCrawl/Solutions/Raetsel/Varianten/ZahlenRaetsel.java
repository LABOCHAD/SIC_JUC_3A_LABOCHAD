package DungeonCrawl.Solutions.Raetsel.Varianten;

import DungeonCrawl.Solutions.Raetsel.Raetsel;

public class ZahlenRaetsel extends Raetsel {
    public ZahlenRaetsel() {
        super("Berechne die Summe von 12 + 15.", "27");
    }

    @Override
    public void ausgabeFrage() {
        System.out.println("Was ist 12 + 15?");
        System.out.println("Gib die Antwort ein:");
    }
}
