package _20241126LogikOperatoren;

public class LogicOperators {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        //TODO Finde durch ausprobieren raus, welcher Boolean zurückgegeben wird
        // Verändere hierfür a und b jeweils passend

        //AND-Operator: bedingung1 && bedingung2
            /*
            true && true -> true
            true && false -> false
            false && true -> false
            false && false -> false
             */
            System.out.println(b && b);

        //OR-Operator: bedingung1 || bedingung2
            /*
            true && true -> true
            true && false -> true
            false && true -> true
            false && false -> false
             */
            System.out.println(b || b);

        //NOT-Operator: !bedingung
            /*
            !true -> false
            !false -> true
             */
            System.out.println(!b);

        //XOR-Operator: bedingung1 ^ bedingung2
            /*
            true && true -> false
            true && false -> true
            false && true -> true
            false && false -> false
             */
        System.out.println(b ^ b);
    }
}
