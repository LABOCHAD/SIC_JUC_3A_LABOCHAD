package DungeonCrawl.Solutions.Figuren;

public abstract class Figure {
    private String name;
    private int gesundheit;
    private int angriff;

    // Konstruktor der abstrakten Klasse
    public Figure(String name, int gesundheit, int angriff) {
        this.name = name;
        this.gesundheit = gesundheit;
        this.angriff = angriff;
    }

    // Getter für den Namen
    public String getName() {
        return name;
    }

    // Getter und Setter für Gesundheit
    public int getGesundheit() {
        return gesundheit;
    }

    public void setGesundheit(int gesundheit) {
        this.gesundheit = gesundheit;
    }

    // Getter für Angriff
    public int getAngriff() {
        return angriff;
    }

    // Abstrakte Methode für den Angriff (kann später spezifisch für Spieler und Gegner implementiert werden)
    public abstract void angriff(Figure charakter);

    // Prüft, ob der Charakter tot ist
    public boolean istTot() {
        return this.gesundheit <= 0;
    }
}
