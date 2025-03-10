package _20250204PflichtaufgabeFahrzeugSystem;

public interface Fahrzeug {

    void starten();
    void stoppen();
    void beschleunigen(int geschwindigkeit); //Zielgeschwindigkeit oder Zuwachs?

    default void statusAnzeigen(){
        System.out.println("Ich bin der Status eines konkreten Fahrzeuges einer implementierenden Klasse.");
        //Ich bin default, damit ich basierend auf einem Objekt einer implementierenden Klasse aufgerufen werde.
        //Es macht praktisch so jetzt nicht wirklich Sinn, aber dient als konstruiertes Beispiel.
    }

    static void allgemeineInfo(){
        System.out.println("Ich bin eine allgemeine Info und gehöre dem Interface Fahrzeug.");
        //In einem statischen Kontext kann ich nicht auf Instanzvariablen zugreifen, denn von welcher Instanz?
    }
}
