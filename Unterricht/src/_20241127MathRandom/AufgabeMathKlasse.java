package _20241127MathRandom;

import myTools.UserInputScanner;

import java.util.Scanner;

public class AufgabeMathKlasse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;
        double d;

        //• Berechnung des absoluten Wertes einer Zahl
        System.out.printf("%nGib eine (negative) Zahl ein, um den Absolutwert zu bilden: ");
        i = Math.abs(UserInputScanner.getInt(scanner));
        System.out.printf("Das Ergebnis lautet: %d", i);

        //• Die Quadratwurzel einer Zahl berechnet
        System.out.printf("%n%nGib eine positive Zahl ein, um daraus die Quadratwurzel zu ziehen: ");
        d = Math.sqrt(UserInputScanner.getDoubleOnlyPos(scanner));
        System.out.printf("Das Ergebnis lautet: %.2f", d);

        //• Die Potenz einer zufallsgenerierten Zahl berechnet
        d = Math.pow(Math.random(), Math.random());
        System.out.printf("%n%nPotenzierung zwei zufälliger Zahlen zwischen 0 und 1: %.2f", d);

        //• Eine Zufallszahl zwischen 25 und 50 generiert
        //https://www.geeksforgeeks.org/java-math-random-method-examples/
        int min = 25;
        int max = 50;
        int range = max - min + 1; //+1 weil, wir sonst nicht auf 50 kommen
        d = (int) (Math.random() * range + min); //(int) damit wir nicht über 50 kommen

        System.out.printf("%n%nGeneriere eine Zufallszahl zwischen 25 und 50: %.2f", d);

        scanner.close();
    }
}
