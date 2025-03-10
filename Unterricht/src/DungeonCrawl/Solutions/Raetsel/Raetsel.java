package DungeonCrawl.Solutions.Raetsel;

public abstract class Raetsel {
    protected String frage;
    protected String richtigeAntwort;

    public Raetsel(String frage, String richtigeAntwort) {
        this.frage = frage;
        this.richtigeAntwort = richtigeAntwort;
    }

    public String getFrage() {
        return frage;
    }

    public boolean loesen(String antwort) {
        return antwort.equalsIgnoreCase(richtigeAntwort);
    }

    // Jede spezifische Rätselklasse kann diese Methode überschreiben, um eigene Logik hinzuzufügen
    public abstract void ausgabeFrage();
}
