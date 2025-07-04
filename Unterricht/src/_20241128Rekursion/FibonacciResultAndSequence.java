package _20241128Rekursion;

public class FibonacciResultAndSequence {
    public static void main(String[] args) {

        int base;

        base = 12;
        System.out.printf("%nErzeuge Fibonacci-Zahl von %d: %d -> %s", base, fibonacci(base), getSequence(base));

        base = 10;
        System.out.printf("%nErzeuge Fibonacci-Zahl von %d: %d -> %s", base, fibonacci(base), getSequence(base));

        base = 1;
        System.out.printf("%nErzeuge Fibonacci-Zahl von %d: %d -> %s", base, fibonacci(base), getSequence(base));

        base = 0;
        System.out.printf("%nErzeuge Fibonacci-Zahl von %d: %d -> %s", base, fibonacci(base), getSequence(base));

        base = 20;
        System.out.printf("%nErzeuge Fibonacci-Zahl von %d: %d -> %s", base, fibonacci(base), getSequence(base));
    }

    static long fibonacci(int base) {
        if (base <= 0) return 0; //Einzeiler brauchen keine Body
        if (base == 1) return 1;
        //Fibonacci: 0 + 1 -> 1 -> 1 + 1 -> 2 -> 1 + 2 -> 3 -> 2 + 3 -> 5...
        return fibonacci(base - 2) + fibonacci(base - 1);
    }

    static String getSequence(int base) {
        String s = "";
        for (int i = 0; i <= base; i++) {
            s += fibonacci(i) + " ";
        }
        return s;
    }
}
