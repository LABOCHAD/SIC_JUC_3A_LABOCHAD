package DungeonCrawl.Solutions.Figuren;

public class Spieler extends Figure {
    // Konstruktor des Spielers
    public Spieler(String name, int gesundheit, int angriff) {
        super(name, gesundheit, angriff);  // Aufruf des Konstruktors der abstrakten Klasse
    }

    @Override
    public void angriff(Figure charakter) {
        int schaden = getAngriff();
        charakter.setGesundheit(charakter.getGesundheit() - schaden);
        System.out.println(getName() + " fügt " + charakter.getName() + " " + schaden + " Schaden zu!");
    }
}
