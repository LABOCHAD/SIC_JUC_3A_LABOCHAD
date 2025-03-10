package _20241126LogikOperatoren;

public class SwitchCase {
    public static void main(String[] args) {
        calcWeekday();
        calcSeason();
        calcHoursToWeekend();
        calcBoolean();
    }
    /*
    Schreibe ein Java-Programm, das basierend auf einer Zahl von 1 bis 7 den entsprechenden Wochentag ausgibt.
     Verwende die switch-case-Anweisung. Wenn die Zahl außerhalb des Bereichs von 1 bis 7 liegt,
     soll das Programm „Ungültige Zahl“ ausgeben.
     */
    private static void calcWeekday() {
        int tag = 5;

        switch (tag) {
            case 1:
                System.out.println("Montag");
                break;
            case 2:
                System.out.println("Dienstag");
                break;
            case 3:
                System.out.println("Mittwoch");
                break;
            case 4:
                System.out.println("Donnerstag");
                break;
            case 5:
                System.out.println("Freitag");
                break;
            case 6:
                System.out.println("Samstag");
                break;
            case 7:
                System.out.println("Sonntag");
                break;
            default:
                System.out.println("Ungültige Zahl");
        }
    }

    /*
    Schreibe ein Java-Programm, das den Monat als Zahl (1 bis 12) entgegennimmt und die
    entsprechende Jahreszeit ausgibt.
     */
    private static void calcSeason() {
        int monat = 6;

        switch (monat) {
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Frühling");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Sommer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Herbst");
                break;
            default:
                System.out.println("Ungültiger Monat");
        }
    }

    /*
    Schreibe ein Java-Programm, das basierend auf dem Wochentag als String (z. B. "Montag",
    "Dienstag") die Anzahl der Stunden bis zum Wochenende anzeigt. Verwende den switch-
    case-Befehl und setze die richtige Anzahl der Stunden für jeden Wochentag.
     */
    private static void calcHoursToWeekend() {
        String wochentag = "Mittwoch";

        int stundenBisWochenende = switch (wochentag) {
            case "Montag" -> 120;
            case "Dienstag" -> 108;
            case "Mittwoch" -> 96;
            case "Donnerstag" -> 84;
            case "Freitag" -> 72;
            case "Samstag" -> 48;
            case "Sonntag" -> 24;
            default -> {
                System.out.println("Ungültiger Wochentag");
                yield 0;
            }
        };

        if (stundenBisWochenende > 0) {
            System.out.println(stundenBisWochenende + " Stunden bis zum Wochenende");
        }
    }

    /*
    Schreibe ein Java-Programm, das die Werte von drei booleschen Variablen (a, b und c) überprüft und eine
    Entscheidung trifft, welche von zwei möglichen Bedingungen zutrifft:
    Fall 1: Alle drei Variablen (a, b und c) sind true.
    Fall 2: Mindestens eine der Variablen ist false.
    Verwende Logik-Operatoren und einen switch-case-Block, um diese Bedingungen zu überprüfen und die entsprechende
    Nachricht auszugeben.
    Hinweis: Die Werte der Variablen a, b und c sind direkt im Code festgelegt und müssen nicht vom Benutzer
    eingegeben werden.
     */
    public static void calcBoolean() {
        boolean a = true;
        boolean b = false;
        boolean c = true;

        int fall = (a && b && c) ? 1 : 2;

        switch (fall) {
            case 1:
                System.out.println("Alle Werte sind true.");
                break;
            case 2:
                System.out.println("Mindestens einer der Werte ist false.");
                break;
        }
    }
}
