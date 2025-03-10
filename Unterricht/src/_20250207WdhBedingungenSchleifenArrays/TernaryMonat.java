package _20250207WdhBedingungenSchleifenArrays;

import myTools.UserInputScanner;

import java.util.Scanner;

public class TernaryMonat {
    public static void main(String[] args) {
        System.out.println("Gib einen Monat (1-12) ein: ");
        int monthInt = UserInputScanner.getInt(new Scanner(System.in));
        //UserInputScanner.getIntOnlyPosRanged(new Scanner(System.in), 1, 13);

        String monthStr = switch (monthInt) { //jeweils ab Java 14, auch wenn ab Java 8 Lambdas eingeführt wurden.
            case 1 -> "Januar";
            case 2 -> "Februar";
            case 3 -> "März";
            case 4 -> "April";
            case 5 -> "Mai";
            case 6 -> "Juni";
            case 7 -> "Juli";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "Oktober";
            case 11 -> "November";
            case 12 -> "Dezember";
            default -> "Ungültige Monatszahl";
        };

        System.out.println("Monat " + monthInt + " = " + monthStr);
    }
}

