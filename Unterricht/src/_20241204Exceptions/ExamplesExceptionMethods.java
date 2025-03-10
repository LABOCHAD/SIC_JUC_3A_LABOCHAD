package _20241204Exceptions;
import java.util.ArrayList;
import java.util.List;
//Eigentlich eine Buchverwaltung
public class ExamplesExceptionMethods {

    private List<String> buecher = new ArrayList<>();

    // Methode zum Hinzufügen eines Buches mit try-catch und finally
    public void buchHinzufuegen(String titel) {
        try {
            if (titel == null) {
                throw new NullPointerException("Buchtitel darf nicht null sein");
            }
            buecher.add(titel);
            System.out.println("Buch hinzugefügt: " + titel);
        } catch (NullPointerException e) {
            System.err.println("Fehler: " + e.getMessage());
        } finally {
            System.out.println("buchHinzufuegen wurde ausgeführt.");
        }
    }

    // Methode zum Entfernen eines Buches mit throw und throws
    public void buchEntfernen(String titel) throws BuchNichtGefundenException {
        if (!buecher.contains(titel)) {
            throw new BuchNichtGefundenException("Buch nicht gefunden: " + titel);
        }
        buecher.remove(titel);
        System.out.println("Buch entfernt: " + titel);
    }

    // Methode zur Buchsuche mit Exception Wrapping und Rethrowing
    public String buchSuchen(String titel) {
        try {
            return sucheBuch(titel);
        } catch (BuchNichtGefundenException e) {
            throw new RuntimeException("Fehler bei der Buchsuche", e);
        }
    }

    // Interne Methode zur Buchsuche, die eine Exception wirft
    private String sucheBuch(String titel) throws BuchNichtGefundenException {
        for (String buch : buecher) {
            if (buch.equals(titel)) {
                return buch;
            }
        }
        throw new BuchNichtGefundenException("Buch nicht gefunden: " + titel);
    }

    public static void main(String[] args) {
        //Das ist ein Beispiel für eine Buchverwaltung
        ExamplesExceptionMethods verwaltung = new ExamplesExceptionMethods();
        verwaltung.buchHinzufuegen("Java Programming");
        verwaltung.buchHinzufuegen(null);

        try {
            verwaltung.buchEntfernen("C# Programming");
        } catch (BuchNichtGefundenException e) {
            System.err.println("Fehler: " + e.getMessage());
            System.out.println("toString()" + e.toString());
            //e.printStackTrace();
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement element : stackTraceElements) {
                System.out.println("getStackTrace()" + element);
            }
        }

        try {
            verwaltung.buchSuchen("Java Programming");
        } catch (RuntimeException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    // Benutzerdefinierte Exception
    public static class BuchNichtGefundenException extends Exception {
        public BuchNichtGefundenException(String message) {
            super(message);
        }
    }
}
