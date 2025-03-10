package _20241205WdhExceptions.UnterschiedCheckedUnchecked;

import myOwnExceptions.DivisionByZeroException;

//Aufgabe 1
public class Mathematik {

    public static double teilen(int a, int b) throws DivisionByZeroException{
        if (b == 0)
            throw new DivisionByZeroException();
        return (double) a/b;
    }

}
