package _20241205WdhExceptions.TaskUn_checkedExceptionSolution;

import _20241205WdhExceptions.TaskUn_checkedExceptionSolution.TaskExceptions.DivisionDurchNullException;

public class Mathematik {
    public static int teilen(int a, int b) throws DivisionDurchNullException {
        if (b == 0) {
            throw new DivisionDurchNullException("Fehler: Division durch null!");
        }
        return a / b;
    }
}
