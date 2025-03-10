package _20241126LogikOperatoren;

import myTools.UserInputScanner;
import java.util.Scanner;

public class AufgabeSwitchCase {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        //1.
        System.out.printf("%nGib eine Zahl von 1-7 ein: ");
        int numForDay = UserInputScanner.getIntOnlyPos(scanner);

        /*
        Switch-Case zur Belegung einer Variable
        darf nur Datentyp der zu belegenden Variable
        als Ergebnis haben, keine Ausgabe oder
        weitere Befehle, die keinen Wert zuweisen.
        Außerdem muss er im Gegensatz zum üblichen
        Switch-Case mit einem Semikolon außen enden.
        */

        String weekdayStr = switch (numForDay) {
            case 1 -> "Montag";
            case 2 -> "Dienstag";
            case 3 -> "Mittwoch";
            case 4 -> "Donnerstag";
            case 5 -> "Freitag";
            case 6 -> "Samstag";
            case 7 -> "Sonntag";

            default -> "Ungültige Wochentagsnummer!";
        };
        System.out.println(weekdayStr);

        //2.
        System.out.printf("%nGib eine Zahl von 1 bis 12 ein: ");
        int numForMonth = UserInputScanner.getIntOnlyPos(scanner);

        String monthStr = switch (numForMonth) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Frühling";
            case 6, 7, 8 -> "Sommer";
            case 9, 10, 11 -> "Herbst";

            default -> "Ungültige Zahl für den Monat";
        };
        System.out.println(monthStr);

        //3.
        System.out.printf("%nWie viele Stunden noch bis zum Wochenende?");
        int hoursTillWeekend = 5 * 24;
        hoursTillWeekend = switch (weekdayStr) {
            case "Montag" -> hoursTillWeekend - 0 * 24;
            case "Dienstag" -> hoursTillWeekend - 1 * 24;
            case "Mittwoch" -> hoursTillWeekend - 2 * 24;
            case "Donnerstag" -> hoursTillWeekend - 3 * 24;
            case "Freitag" -> hoursTillWeekend - 4 * 24;

            default -> -1;
        };

        if (hoursTillWeekend == -1){
            System.out.printf("%nUngültiger Wochentag oder bereits Wochenende!%n");
        } else {
            System.out.printf("%nAm %s sind es noch %d Stunden bis zum Wochenende. (Ausgehend von 0 Uhr)%n", weekdayStr, hoursTillWeekend);
        }

        scanner.close();
    }


}
