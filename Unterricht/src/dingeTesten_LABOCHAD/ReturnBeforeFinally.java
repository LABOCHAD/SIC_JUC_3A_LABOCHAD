package dingeTesten_LABOCHAD;

public class ReturnBeforeFinally {
    public static void main(String[] args) {
        try{
            //throw new Exception();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
