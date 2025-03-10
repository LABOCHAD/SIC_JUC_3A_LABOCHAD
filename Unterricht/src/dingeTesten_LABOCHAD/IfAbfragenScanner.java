package dingeTesten_LABOCHAD;

import java.util.Scanner;

public class IfAbfragenScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Eingabeaufforderung für die Dezimalzahl
        System.out.print("Geben Sie eine ganze Dezimalzahl ein: ");
        if (scanner.hasNextInt()) { //hier wird gelesen
            int decimal = scanner.nextInt(); //hier nicht mehr, nur Zuweisung (ohne hasNextInt hier Einlesen)
        } else {
            System.out.println("Eingabe ist kein Int!");
        }
    }
}
