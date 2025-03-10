package _20241128Rekursion;

public class ExampleRekursionSolution {
    // Methode zur Berechnung der Fakultät
    public static int fakultaet(int n) {
        // Basisfall: Fakultät von 0 oder 1 ist 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Rekursiver Fall: n! = n * (n-1)!
        return n * fakultaet(n - 1);
    }

    //Methode zur Berechnung der Fibonacci-Zahlen
    public static int fibonacci(int n) {
        // Basisfälle: F(0) = 0, F(1) = 1
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Rekursiver Fall: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //Alternative zum Printen in einer Schleife der Fibonacci-Folge:
    public static void printFibonacci(int n, int a, int b) {
        // Ausgabe der aktuellen Zahl
        System.out.println(a);

        // Wenn wir n erreicht haben, beenden wir die Rekursion
        if (n > 0) {
            printFibonacci(n - 1, b, a + b);  // Rekursiver Aufruf mit den nächsten Fibonacci-Zahlen
        }
    }

    // Methode zur Berechnung von a^b (Potenz)
    public static int potenz(int a, int b) {
        // Basisfall: a^0 = 1
        if (b == 0) {
            return 1;
        }
        // Rekursiver Fall: a^b = a * a^(b-1)
        return a * potenz(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println(fakultaet(5)); // Ausgabe: 120
        System.out.println(fibonacci(5)); // Ausgabe: 5
        printFibonacci(100, 0, 1); //0 und 1 für die Basisfälle
    }
}
