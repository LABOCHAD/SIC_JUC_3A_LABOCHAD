package _20250205Vererbung.übungBewegbar;

public class Main {
    public static void main(String[] args) {
        Bewegbar auto = new Auto();
        Bewegbar fahrrad = new Fahrrad();
        Bewegbar hund = new Hund();
        Bewegbar vogel = new Vogel();

        Bewegbar[] bewegbarObjekte = {auto, fahrrad, hund, vogel};
        bewegeAlle(bewegbarObjekte);
    }
    public static void bewegeAlle(Bewegbar[] bewegbarObjekte) {
        for (Bewegbar obj : bewegbarObjekte) {
            //zur Compilerzeit wird nur die abstrakte Methode erkannt aus dem Interface
            //zur Laufzeit wird dann der jeweilige Override in den Klassen gefunden
            //das funktioniert aber nur, weil es overrides sind, je eigene Methoden sind unsichtbar ohne recasting
            obj.beispiel();
            obj.bewege();  // Polymorphismus: unterschiedliche Implementierungen je nach Typ
        }
    }
}