package _20250204PflichtaufgabeFahrzeugSystem;

public class Auto extends AbstraktesFahrzeug implements Fahrzeug {
    private int anzahlTüren;

    Auto(String modell, String kennzeichen, int maxGeschwindigkeit, int anzahlTüren) {
        super(modell, kennzeichen, maxGeschwindigkeit);
        this.anzahlTüren = anzahlTüren;
    }

    //abstrakte Methoden aus dem Interface Fahrzeug (müssen overridden werden).
    @Override
    public void starten() {
        System.out.println("Das Auto startet.");
    }

    @Override
    public void stoppen() {
        System.out.println("Das Auto hält an.");
    }

    @Override
    public void beschleunigen(int geschwindigkeit) {
        System.out.println("Das Auto beschleunigt um/auf " + geschwindigkeit);
    }

    //Hier die gewünschte Überladung
    public void beschleunigen(int geschwindigkeit, int sekunden) {
        System.out.format("Das Auto beschleunigt um/auf %s innerhalb von %s Sekunden.", geschwindigkeit, sekunden);
        // wenn was anderes gemeint war, bitte nächstes Mal genauer angeben.
        // Mit Formeln wie a = v/t und v = s/t, sowie dem Faktor 3,6 (km/h <-> m/s) kam ich nicht weit.
        // Ich hatte vor über 10 Jahren Physik-Leistungskurs im Abitur und bin trotzdem verwirrt.
    }

    //durch den Wizard von IntelliJ generiert
    @Override
    public String toString() {
        return "Auto{" +
               "anzahlTüren=" + anzahlTüren +
               ", model='" + model + '\'' +
               ", maxGeschwindigkeit=" + maxGeschwindigkeit +
               ", Kennzeichen='" + Kennzeichen + '\'' +
               '}';
    }
}
