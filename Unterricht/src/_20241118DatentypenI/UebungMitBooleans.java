package _20241118DatentypenI;

/*
Schreibe eine Methode, die einen Boolean übergeben bekommt und folgendes kann:
− true:
−Berechnung der Summe aller natürlichen Zahlen bis 50
−Ausgabe des Ergebnisses in der Konsole

− false:
−Berechnung des Produkts aller natürlichen Zahlen bis 20 (also 20!)
−Wenn das Ergebnis gerade durch 2 teilbar ist und größer als 50, dann soll eine Ausgabe des Ergebnisses erfolgen.
−Falls das Ergebnis durch 3 teilbar ist, dann soll keine Ausgabe erfolgen.
−Falls das Ergebnis durch 5 teilbar ist, dann soll eine andere Ausgabe erfolgen.
 */

import java.util.Scanner;

public class UebungMitBooleans {

    static void takeABool(boolean b) {
        if (b) { //wenn b = true (kurz)
            int summe = 0;
            for (int i = 1; i <= 50; i++) {
                summe += i;
            }
            System.out.println("Summe aller natürlichen Zahlen bis 50: " + summe);

        } else {
            long factorial = 1; //um multiplizieren zu können
            for (int i = 1; i <= 20; i++) {
                factorial *= i;
                System.out.println("Testausgabe: " + factorial);
            }
            System.out.println("Testausgabe Ende: " + factorial);

            if (factorial % 2 == 0 && factorial > 50) {
                System.out.println("Die Fakultät aus 20 ist teilbar durch 2, größer als 50 und lautet: " + factorial);
            } else if (factorial % 3 == 0) {
                return;
            } else if (factorial % 5 == 0) {
                System.out.println("Andere Ausgabe (weil Teilbar durch 5)");
            }

        }
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nGib ja oder nein ein: ");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("ja")) {
            takeABool(true);
            menu();

        } else if (answer.equalsIgnoreCase("exit")) {
            return;

        } else {
            takeABool(false);
            menu();
        }
        scanner.close();

    }

    public static void main(String[] args) {
        menu();
    }
}
