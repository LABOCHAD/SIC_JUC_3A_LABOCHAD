package _20241205WdhExceptions.TaskUn_checkedExceptionSolution;

import _20241205WdhExceptions.TaskUn_checkedExceptionSolution.TaskExceptions.DivisionDurchNullException;
import _20241205WdhExceptions.TaskUn_checkedExceptionSolution.TaskExceptions.InvalidAgeException;

public class Main {
    public static void main(String[] args) {
        // Beispiel für die checked Exception:
        try {
            System.out.println(Mathematik.teilen(10, 0));  // Wird die DivisionDurchNullException werfen
        } catch (DivisionDurchNullException e) {
            System.out.println("Gefangene checked Exception: " + e.getMessage());
        }

        // Beispiel für die unchecked Exception:
        try {
            Benutzer.alterPruefen(-5);  // Wird die InvalidAgeException werfen
        } catch (InvalidAgeException e) {
            System.out.println("Gefangene unchecked Exception: " + e.getMessage());
        }

        // Beispiel für die unchecked Exception ohne catch:
        // Benutzer.alterPruefen(-10);  // Dies würde die Anwendung zum Absturz bringen, wenn nicht gefangen
    }
}
