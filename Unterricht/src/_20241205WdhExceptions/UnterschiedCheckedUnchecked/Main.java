package _20241205WdhExceptions.UnterschiedCheckedUnchecked;

import myOwnExceptions.DivisionByZeroException;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Fange checked handled Exception");
            Mathematik.teilen(10,0);
        } catch (DivisionByZeroException e) {
            System.err.println(e.getMessage());
        }

        //System.out.println("Fange checked handled Exception NICHT");
        //Mathematik.teilen(10,0);

        //-----------------------------------------------------------

        try {
            System.out.println("Fange unchecked handled Exception");
            Benutzer.alterPruefenHandled(-3);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());;
        }

        System.out.println("Fange unchecked handled Exception NICHT");
        //Benutzer.alterPruefenHandled(-3);

        try {
            System.out.println("Fange unchecked unhandled Exception");
            Benutzer.alterPruefenUnhandled(-3);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Fange unchecked unhandled Exception");
        Benutzer.alterPruefenUnhandled(-3);
    }
}
