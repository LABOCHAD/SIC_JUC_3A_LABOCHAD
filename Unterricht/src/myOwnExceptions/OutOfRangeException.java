package myOwnExceptions;

public class OutOfRangeException extends Exception{
    public OutOfRangeException(String message){
        super(message);
    }

    public OutOfRangeException(){
        super("You entered number is out of stated range.");
    }
}
