package _20241205WdhExceptions.Einkaufsplattform;

public class InvalidHaltbarkeitsdatumException extends RuntimeException {
    public InvalidHaltbarkeitsdatumException() {
        super("Ungültiges MHD!");
    }
}
