package myOwnExceptions;

public class NoNumberException extends Exception{
    public NoNumberException(String message){
        super(message);
    }

    public NoNumberException(){
        super("No number has been entered.");
    }
}
