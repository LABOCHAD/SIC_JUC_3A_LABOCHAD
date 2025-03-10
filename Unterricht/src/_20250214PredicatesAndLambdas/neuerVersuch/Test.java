package _20250214PredicatesAndLambdas.neuerVersuch;

public class Test {
    public static void main(String[] args) {
        versuchMitKlassen();
        versuchMitLambdas();

        //Was im Hintergrund passiert
        Calculator calc = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return 0; //statt null a rechenzeichen b
            }
        };

        //daraus wird dann daraus, Typendeklaration muss nicht beistehen, ist ja schon im Interface
        Calculator calc2 = ((a, b) -> a%b); //beispiel modulo

        //Syntax
        //Interface Bezeichner = (Parameter, noch einer) -> was hinter dem return steht
    }

    static void versuchMitKlassen(){
        System.out.println("\nObjektorientierter Ansatz");
        int a = 25;
        int b = 5;
        Plus plus = new Plus();
        Minus minus = new Minus();
        Multiplizieren multiplizieren = new Multiplizieren();
        Teilen teilen = new Teilen();

        System.out.println(plus.calculate(a, b));
        System.out.println(minus.calculate(a, b));
        System.out.println(multiplizieren.calculate(a, b));
        System.out.println(teilen.calculate(a, b));
    }

    static void versuchMitLambdas(){
        System.out.println("\nFunktionaler Ansatz");
        int a = 25;
        int b = 5;

        //erschaffe Funktion aus abstrakter Methode
        Calculator add = (x,y) -> x+y; //variablen müssen hier anders heißen
        int sum = add.calculate(a, b); //erst hier werden scope variablen übergeben.
        System.out.printf("Sum: %d\n", sum);

        Calculator sub = (x,y) -> x-y;
        int diff = sub.calculate(a,b);
        System.out.printf("Diff: %d\n", diff);

        Calculator multiply = (x,y) -> x*y;
        int product = multiply.calculate(a,b);
        System.out.printf("Product: %d\n", product);

        Calculator div = (x,y) -> x/y; //nur ganzzahlige Division //kann mit {} als ganzen body geschrieben werden
        int quotient = div.calculate(a,b); //interface gibt eh int zurück, double lohnt also nicht
        System.out.printf("Quotient: %d\n", quotient);

        Calculator div2 = (x,y) -> {
            if (y == 0)
                throw new ArithmeticException("Division by zero");
            else return x/y;
        };
        int q2 = div2.calculate(a,b);
        System.out.printf("Quotient 2: %d\n", q2);

    }
}
