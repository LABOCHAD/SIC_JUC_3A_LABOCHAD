package _20241204Exceptions;

public class SolutionThrowThrows {
    public static void main(String[] args) {
        try {
            double ergebnis = berechneQuadratwurzel(-4);
            System.out.println("Ergebnis: " + ergebnis);
        } catch (NegativeNumberException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    public static double berechneQuadratwurzel(double zahl) throws NegativeNumberException {
        if (zahl < 0) {
            throw new NegativeNumberException("Die Zahl darf nicht negativ sein: " + zahl);
        }
        return Math.sqrt(zahl);
    }

    public static class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }
    }
}

