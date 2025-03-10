package myOwnExceptions;

public class NumberIsNegativeException extends Exception{
    public NumberIsNegativeException(String message){
        super(message);
    }

    public NumberIsNegativeException(){
        super("You entered a negative number.");
    }
}
