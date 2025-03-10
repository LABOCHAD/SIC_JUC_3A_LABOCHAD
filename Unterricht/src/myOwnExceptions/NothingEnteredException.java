package myOwnExceptions;

public class NothingEnteredException extends Exception{
    public NothingEnteredException(String message){
        super(message);
    }

    public NothingEnteredException(){
        super("There hasn't been entered anything at all.");
    }
}
