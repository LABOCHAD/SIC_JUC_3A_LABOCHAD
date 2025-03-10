package _20241205WdhExceptions.Einkaufsplattform;

public class NichtGenugLagerbestandException extends RuntimeException {
    public NichtGenugLagerbestandException() {
        super("Unzureichender Lagerbestand!");
    }

}
