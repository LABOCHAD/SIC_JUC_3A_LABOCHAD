package _20241128Rekursion;

public class Rekursion {
    //TODO Schreibe eine Methode zur Berechnung der Potenz a^b= a*a*...*a (b-mal)
    // Was ist der Basisfall?
    // Was berechnen wir?
    public static int potenz(int a, int b) {
        // Basisfall:
        if(b == 0) {
            return 1;
        }
        //Rekursion:
        return a * potenz(a, b-1);
    }

    public static void main(String[] args) {
        System.out.println(potenz(2, 5)); // Ausgabe: 32 (2^5 = 32)
        System.out.println(potenz(3, 3)); // Ausgabe: 27 (3^3 = 27)
        System.out.println(potenz(5, 0)); // Ausgabe: 1 (5^0 = 1)
    }
}
