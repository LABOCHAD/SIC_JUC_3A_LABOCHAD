package _20241205WdhExceptions.TaskExceptionSolution.ProductException;

public class NichtGenugLagerbestandException extends Exception {
    public NichtGenugLagerbestandException(String message) {
        super(message);
    }
}