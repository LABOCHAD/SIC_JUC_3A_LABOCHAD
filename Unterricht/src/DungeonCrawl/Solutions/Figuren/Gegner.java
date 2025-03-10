package DungeonCrawl.Solutions.Figuren;

public abstract class Gegner extends Figure {

    public Gegner(String name, int gesundheit, int angriff) {
        super(name, gesundheit, angriff);  // Aufruf des Konstruktors der abstrakten Klasse
    }

    @Override
    public void angriff(Figure spieler) {
        int schaden = this.getAngriff();
        spieler.setGesundheit(spieler.getGesundheit() - schaden);
        System.out.println(this.getName() + " fügt " + spieler.getName() + " " + schaden + " Schaden zu!");
    }

    // Jede spezifische Gegnerklasse kann dies überschreiben, um spezielle Fähigkeiten zu haben
    public abstract void spezielleFähigkeit(Spieler spieler);
}
