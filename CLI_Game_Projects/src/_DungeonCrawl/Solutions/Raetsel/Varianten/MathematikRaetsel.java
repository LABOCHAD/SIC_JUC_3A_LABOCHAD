package _DungeonCrawl.Solutions.Raetsel.Varianten;

import _DungeonCrawl.Solutions.Raetsel.Raetsel;

public class MathematikRaetsel extends Raetsel {

    public MathematikRaetsel(String frage, String richtigeAntwort) {
        super(frage, richtigeAntwort);
    }

    @Override
    public void ausgabeFrage() {
        System.out.println("Löse das Rätsel: " + frage);
        System.out.println("Gib die Antwort ein:");
    }
}
