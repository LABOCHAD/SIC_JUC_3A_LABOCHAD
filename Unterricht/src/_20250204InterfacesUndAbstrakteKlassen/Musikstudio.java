package _20250204InterfacesUndAbstrakteKlassen;

// Interface mit abstrakter, default- und static-Methode
interface Klanggeber {
    // Abstrakte Methode, die jede Klasse selbst implementieren muss
    void erzeugeKlang();

    // Default-Methode mit einer Standard-Implementierung
    default void spieleTon() {
        System.out.println("Standardklang wird abgespielt...");
    }

    // Static-Methode, die direkt über das Interface aufgerufen wird
    static void info() {
        System.out.println("Alle Klanggeber erzeugen Töne.");
    }
}

// Klasse Gitarre implementiert das Interface Klanggeber
class Gitarre implements Klanggeber {
    @Override
    public void erzeugeKlang() {
        System.out.println("Gitarrenklang: Strumm!");
    }

    // Optional: Überschreiben der default-Methode
    @Override
    public void spieleTon() {
        System.out.println("Gitarrensound: Tsching!");
    }
}

// Klasse Lautsprecher implementiert das Interface Klanggeber
class Lautsprecher implements Klanggeber {
    @Override
    public void erzeugeKlang() {
        System.out.println("Bass: Wumm Wumm!");
    }
}

// Testklasse mit main-Methode
public class Musikstudio {
    public static void main(String[] args) {
        // Aufruf der static-Methode direkt über das Interface
        Klanggeber.info();

        // Gitarre-Objekt erstellen und Methoden aufrufen
        Gitarre meineGitarre = new Gitarre();
        meineGitarre.spieleTon();  // Überschriebene default-Methode
        meineGitarre.erzeugeKlang(); // Implementierte Methode

        // Lautsprecher-Objekt erstellen und Methoden aufrufen
        Lautsprecher meinLautsprecher = new Lautsprecher();
        meinLautsprecher.spieleTon();  // Standard default-Methode
        meinLautsprecher.erzeugeKlang(); // Implementierte Methode
    }
}
