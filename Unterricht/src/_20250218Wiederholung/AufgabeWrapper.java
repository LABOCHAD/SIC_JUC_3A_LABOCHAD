package _20250218Wiederholung;

import java.util.Scanner;

//Schreibe ein Java-Programm, das einen Benutzer nach einer Zahl fragt,
//diese mit Integer.parseInt() umwandelt und diese dann mit sich selbst multipliziert.
public class AufgabeWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (sc) {
            System.out.print("\nGib eine ganze Zahl ein: ");
            String zahl = sc.next();
            Integer i = Integer.parseInt(zahl);
            i *= i; //Autoboxing, Behandlung wie ein primitiver Wert
            System.out.println(i);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
