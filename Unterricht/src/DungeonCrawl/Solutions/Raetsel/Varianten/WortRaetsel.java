package DungeonCrawl.Solutions.Raetsel.Varianten;

import DungeonCrawl.Solutions.Raetsel.Raetsel;

public class WortRaetsel extends Raetsel {

    public WortRaetsel(String frage, String richtigeAntwort) {
        super(frage, richtigeAntwort);
    }

    @Override
    public void ausgabeFrage() {
        System.out.println("Löse das Worträtsel: " + frage);
        System.out.println("Gib die Antwort ein:");
    }
}
