package _20250204InterfacesUndAbstrakteKlassen;

// Oberstes Interface für alle Fahrzeuge
interface Fahrzeug {
    // Abstrakte Methode, die jede Klasse selbst implementieren muss
    void bewegen();

    // Default-Methode mit einer Standard-Implementierung
    default void hupen() {
        System.out.println("Hup Hup!");
    }
}

// Interface für Elektroantriebe, das Fahrzeug erweitert
interface ElektroAntrieb extends Fahrzeug {
    // Zusätzliche abstrakte Methode für Elektrofahrzeuge
    void ladeBatterie();

    // Default-Methode für den Ladestatus
    default void ladeStatus() {
        System.out.println("Batterie wird geladen...");
    }
}

// Klasse Auto implementiert das Fahrzeug-Interface
class Auto implements Fahrzeug {
    @Override
    public void bewegen() {
        System.out.println("Das Auto fährt mit Benzin!");
    }
}

// Klasse ElektroAuto implementiert das ElektroAntrieb-Interface
class ElektroAuto implements ElektroAntrieb {
    @Override
    public void bewegen() {
        System.out.println("Das Elektroauto gleitet lautlos dahin!");
    }

    @Override
    public void ladeBatterie() {
        System.out.println("Das Elektroauto wird aufgeladen.");
    }
}

// Testklasse mit main-Methode
public class FahrzeugTest {
    public static void main(String[] args) {
        // Erstelle ein Auto und rufe Methoden auf
        Auto meinAuto = new Auto();
        meinAuto.bewegen();
        meinAuto.hupen();

        System.out.println();

        // Erstelle ein ElektroAuto und rufe Methoden auf
        ElektroAuto meinElektroAuto = new ElektroAuto();
        meinElektroAuto.bewegen();
        meinElektroAuto.hupen();
        meinElektroAuto.ladeStatus();
    }
}
