package _20241204Exceptions;

public class ExercisesExceptionsThrowThrows {

    //3: Rufe die Methode berechneQuadratwurzel auf und berechne die Quadratwurzel einer (negativen) Zahl.
    // Beachte das Exceptionhandling
    public static void main(String[] args) {
        tryCatchTest(25);
        tryCatchTest(42);
        tryCatchTest(-3);
    }

    public static void tryCatchTest(double zahl) {
        try {
            double ergebnis = berechneQuadratwurzel(zahl);
            System.out.println("Ergebnis: " + ergebnis);
        } catch (NegativeNumberException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    // 1: Implementiere die Methode zur Berechnung der Quadratwurzel einer Zahl.
    // 2: Werfe im Fall, dass die übergebene Zahl negativ ist die Exception NegativeNumberException
    public static double berechneQuadratwurzel(double zahl) throws NegativeNumberException {
        if (zahl < 0)
            throw new NegativeNumberException("Radikand darf nicht negativ sein.");
        return Math.sqrt(zahl); //muss angepasst werden!
    }

    //Only for the task
    public static class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }
    }
}

/*
Example for using throw und throws
 */
class Rechner {
    public static void main(String[] args) {
        //You know that the methode divide can throw an exception so you have to catch it
        try {
            int ergebnis = divide(10, 0);
            System.out.println("Ergebnis: " + ergebnis);
        } catch (DivisionByZeroException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    //When you throw an exception the methode throws also this exception in the head
    public static int divide(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            //Throw an exception
            throw new DivisionByZeroException("Division durch null ist nicht erlaubt.");
        }
        return a / b;
    }

    //Only for the example
    public static class DivisionByZeroException extends Exception {
        public DivisionByZeroException(String message) {
            super(message);
        }
    }
}
