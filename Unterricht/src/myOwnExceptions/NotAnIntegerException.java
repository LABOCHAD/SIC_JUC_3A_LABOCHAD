package myOwnExceptions;

public class NotAnIntegerException extends Exception {
    public NotAnIntegerException(String message) {
        super(message);
    }

    public NotAnIntegerException() {
        super("Number is not an Integer!");
    }
}
