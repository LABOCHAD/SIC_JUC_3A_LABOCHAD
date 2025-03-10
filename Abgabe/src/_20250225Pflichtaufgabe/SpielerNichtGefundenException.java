package _20250225Pflichtaufgabe;

public class SpielerNichtGefundenException extends RuntimeException {
    // Unchecked Exception
    //DONE erbe von RuntimeException und erstelle einen Konstruktor für diese Klasse
    public SpielerNichtGefundenException() {super("Spieler nicht gefunden!");}
    public SpielerNichtGefundenException(String message) {super(message);}
}
