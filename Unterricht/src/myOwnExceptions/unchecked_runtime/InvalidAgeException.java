package myOwnExceptions.unchecked_runtime;

public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException() {
        super("Entered age is invalid!");
    }
}
