package _20241205WdhExceptions.TaskUn_checkedExceptionSolution;

import _20241205WdhExceptions.TaskUn_checkedExceptionSolution.TaskExceptions.InvalidAgeException;

public class Benutzer {
    public static void alterPruefen(int alter) {
        if (alter < 0) {
            throw new InvalidAgeException("Fehler: Das Alter kann nicht negativ sein!");
        }
        System.out.println("Das Alter ist: " + alter);
    }
}
