package _20250225Pflichtaufgabe;

public class KaderVollException extends Exception {
    // Checked Exception
    //DONE erbe von Exception und erstelle einen Konstruktor für diese Klasse
    KaderVollException(){super("Der Kader ist voll!");}
    KaderVollException(String message) {super(message);}
    //Was ist ein Kader?
    //https://de.wikipedia.org/wiki/Kader
}
