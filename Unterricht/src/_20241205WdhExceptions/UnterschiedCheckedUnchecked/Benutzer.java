package _20241205WdhExceptions.UnterschiedCheckedUnchecked;

import myOwnExceptions.unchecked_runtime.InvalidAgeException;

public class Benutzer {

    public static void alterPruefenHandled(int alter) throws RuntimeException{ //can be kept as super
        if (alter < 0)
            throw new InvalidAgeException();
        else
            System.out.println("Age is valid.");
    }

    public static void alterPruefenUnhandled(int alter){ //can be kept as super
        if (alter < 0)
            System.out.println("Alter ist negativ.");
        else
            System.out.println("Age is valid.");
    }
}
