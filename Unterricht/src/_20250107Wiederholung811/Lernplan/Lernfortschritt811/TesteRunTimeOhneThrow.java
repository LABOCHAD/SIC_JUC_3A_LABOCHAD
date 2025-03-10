package _20250107Wiederholung811.Lernplan.Lernfortschritt811;

public class TesteRunTimeOhneThrow {
    public static void main(String[] args) {
        double quotient;

        //unbehandelte (unchecked) Exception wird auftreten
        //System.out.println(0/0);
        //quotient = division(10, 0);

        try {
            //Exception wird auftreten, aber behandelt
            quotient = division(10, 0);
            System.out.println(quotient);

        } catch (ArithmeticException ae) {
            // "/ by zero", wenn ohne eigenes throw new ArithmeticException("")
            System.err.println(ae.getMessage());
        }
    }


    //warum int, wieso nicht double. Nun ja, double macht daraus "Infinity"
    //da ich aber beweisend blind eine Exception auslösen wollte,
    //war das nicht hilfreich.
    public static int division(int dividend, int divisor) {
        //throws ArithmeticException nicht nötig
/*
    //auch optional weil unchecked, aber spezifischer
    if (divisor == 0) {
            throw new ArithmeticException("Division durch 0!");
        }
*/
        //gegenprobe checked, muss in signatur
        //throw new Exception("Blabla");

        return dividend / divisor;
    }
}
