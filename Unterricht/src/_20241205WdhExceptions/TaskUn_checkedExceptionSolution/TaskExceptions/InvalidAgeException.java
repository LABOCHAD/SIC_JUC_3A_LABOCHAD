package _20241205WdhExceptions.TaskUn_checkedExceptionSolution.TaskExceptions;

public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}