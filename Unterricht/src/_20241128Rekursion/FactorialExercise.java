package _20241128Rekursion;

public class FactorialExercise {
    public static void main(String[] args) {

        int base;
        base = 15;
        System.out.printf("%nErzeuge Fakultät von %d: %d", base, factorial(base));

        base = 2;
        System.out.printf("%nErzeuge Fakultät von %d: %d", base, factorial(base));

        base = 1;
        System.out.printf("%nErzeuge Fakultät von %d: %d", base, factorial(base));

        base = 0;
        System.out.printf("%nErzeuge Fakultät von %d: %d", base, factorial(base));
    }

    static long factorial(int base) {
        if (base < 0) return 0; //Einzeiler brauchen keine Body


        if (base <= 1) {
            return 1;
        }

        return base * factorial(base - 1);
    }
}
