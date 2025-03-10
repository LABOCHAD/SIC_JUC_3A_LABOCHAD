package _20241205WdhExceptions.Einkaufsplattform;

public class InvalidPreisException extends RuntimeException {
    public InvalidPreisException() {
        super("Ungültiger Preis.");
    }
}
