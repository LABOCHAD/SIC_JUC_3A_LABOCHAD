package _DungeonCrawl.Solutions.Raetsel.Varianten;

import _DungeonCrawl.Solutions.Raetsel.Raetsel;

public class WortAnagrammRaetsel extends Raetsel {
    public WortAnagrammRaetsel() {
        super("Löse das Anagramm: \"etimrca\".", "armetic");
    }

    @Override
    public void ausgabeFrage() {
        System.out.println("Löse das Anagramm: \"etimrca\".");
        System.out.println("Gib die Antwort ein:");
    }
}
