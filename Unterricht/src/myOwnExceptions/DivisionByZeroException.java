package myOwnExceptions;

public class DivisionByZeroException extends Exception{
    public DivisionByZeroException(String message){
        super(message);
    }

    public DivisionByZeroException(){
        super("Division through zero not allowed!.");
    }
}
