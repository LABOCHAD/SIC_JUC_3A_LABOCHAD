package _20250213Aufgabe;

import myTools.Color;
import myTools.UserInputScanner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Aufgaben {
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) {

        //LocalDateTime
        System.out.println("\nAufgabe 1");
        aufgabe1();

        System.out.println("\nAufgabe 2");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusHours(2).plusMinutes(10);
        aufgabe2(now, later); //jetzt - jetzt+2h,2min
        aufgabe2(later, now); //Negativprobe, wird err triggern

        System.out.println("\nAufgabe 3");
        aufgabe3();

        //LocalDate
        System.out.println("\nAufgabe 4");
        aufgabe4();

        System.out.println("\nAufgabe 5");
        aufgabe5();

        System.out.println("\nAufgabe 6");
        aufgabe6();

        //LocalTime
        System.out.println("\nAufgabe 7");
        aufgabe7();

        System.out.println("\nAufgabe 8");
        aufgabe8();

        System.out.println("\nAufgabe 9");
        aufgabe9();

        //DateTimeFormatter
        System.out.println("\nAufgabe 10");
        aufgabe10();

        System.out.println("\nAufgabe 11");
        aufgabe11();

        System.out.println("\nAufgabe 12");
        aufgabe12();

        //Period
        System.out.println("\nAufgabe 13");
        aufgabe13();

        System.out.println("\nAufgabe 14");
        aufgabe14();

        System.out.println("\nAufgabe 15");
        aufgabe15();

    }

    //LocalDateTime

    //1. Schreibe eine Methode, die das aktuelle Datum und die Uhrzeit als LocalDateTime ausgibt
    static void aufgabe1() { //Aufgabe 1
        LocalDateTime nowToday = LocalDateTime.now();
        System.out.println("Jetzt und heute: " + nowToday.format(dateFormatter));
    }

    //2. Schreibe eine Methode, die den Unterschied in Stunden und Minuten zwischen zwei
    //LocalDateTime-Objekten berechnet. Die Methode soll dabei zwei LocalDateTime-Objekte entgegennehmen.
    static void aufgabe2(LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) {
            System.out.println("Start time cannot be after end time!");
            return; //could also throw an IllegalArgumentException
        }

        Duration duration = Duration.between(start, end); //no Period usable here, cause requires LocalDate
        System.out.println("Startzeit (HH:mm): " + start.format(dateTimeFormatter));
        System.out.println("Endzeit (HH:mm): " + end.format(dateTimeFormatter));

        System.out.println("Unterschied in Stunden und Minuten:" +
                           "\nStunden: " + duration.toHours() +
                           "\nMinuten: " + duration.toMinutes()); // je Stunden oder Minuten
        System.out.println("Oder in Stunden Rest Minuten: " + duration.toHours() + ":" + duration.toMinutes() % 60);
    }

    //3. Schreibe eine Methode, die das Datum und die Uhrzeit 3 Monate und 10 Tage in der
    //Vergangenheit basierend auf dem aktuellen Datum und der Uhrzeit berechnet. (Also
    //heutiges Datum – 3 Monate und 10 Tage)
    static void aufgabe3() {
        LocalDateTime dateTime = LocalDateTime.now().minusMonths(3).minusDays(10);
        System.out.println("Jetzt und heute vor 3 Monaten und 10 Tagen: " + dateTime.format(dateTimeFormatter));
    }


    //LocalDate

    //4. Schreibe eine Methode, die das aktuelle Datum als LocalDate ausgibt.
    static void aufgabe4() {
        LocalDate today = LocalDate.now();
        System.out.println("Heute: " + today.format(dateFormatter));
    }

    //5. Schreibe eine Methode, die zum aktuellen Datum 5 Tage hinzufügt und das Ergebnis ausgibt.
    static void aufgabe5() {
        LocalDate today = LocalDate.now();
        System.out.println("Heute plus 5 Tage: " + today.plusDays(5).format(dateFormatter));
    }

    //6. Schreibe eine Methode, die die Anzahl der Tage zwischen zwei beliebigen LocalDate-Instanzen berechnet.
    //Achievement unlocked: discovered TemporalUnit-Class :D
    static void aufgabe6() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Period period = Period.between(today, tomorrow);

        System.out.printf("Unterschied zwischen %s und %s in Tagen: %s%n",
                today.format(dateFormatter), tomorrow.format(dateFormatter), period.getDays());

    }


    //LocalTime

    //7. Schreibe eine Methode, die die aktuelle Uhrzeit als LocalTime ausgibt.
    static void aufgabe7() {
        LocalTime now = LocalTime.now();
        System.out.println("Jetzt: " + now.format(timeFormatter));
    }

    //8. Schreibe eine Methode, die 3 Stunden zur aktuellen Uhrzeit hinzufügt und das Ergebnis ausgibt.
    static void aufgabe8() {
        LocalTime now = LocalTime.now();
        System.out.println("Jetzt in 3h: " + now.plusHours(3).format(timeFormatter));
    }

    //9. Schreibe eine Methode, die die Dauer zwischen zwei LocalTime-Instanzen in Minuten berechnet.
    static void aufgabe9() {
        LocalTime now = LocalTime.now();
        LocalTime later = now.plusMinutes(60); //ab 86min wird Unterschied in Minuten negative in duration
        Duration duration = Duration.between(now, later);
        System.out.println("Unterschied jetzt und später in Minuten: " + duration.toMinutes());
    }


    //DateTimeFormatter

    //10. Schreibe eine Methode, die das aktuelle Datum im Format „dd.MM.yyyy“ ausgibt.
    static void aufgabe10() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Heute ist der: " + now.format(localDateFormatter));
    }

    //11. Schreibe eine Methode, die das aktuelle Datum und die Uhrzeit im Format „yyyy-MM-dd HH:mm:ss“ ausgibt.
    static void aufgabe11() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println("Aktuelles Datum und Uhrzeit: " + now.format(localDateTimeFormatter));
    }

    //12. Schreibe eine Methode, die ein Datum im Format „yyyy/MM/dd“ als String
    //entgegennimmt, es in ein LocalDate-Objekt umwandelt und das Ergebnis ausgibt.
    static void aufgabe12() {
        final String taskPattern = "yyyy/MM/dd";

        System.out.println("Erste Variante: fix");
        String today = "2025/02/13"; //auch mit Scanner möglich

        System.out.print("Aus " + today + " wird ");
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern(taskPattern);
        LocalDate localDate = LocalDate.parse(today, localDateTimeFormatter);
        System.out.print(localDate.format(dateFormatter));

        System.out.println("\nZweite Variante: benutzerdefiniert");
        System.out.print(Color.GREEN + "Gib ein Datum im Format 'yyyy/MM/dd' ein: " + Color.RESET);
        today = new Scanner(System.in).nextLine();

        try {
            localDate = LocalDate.parse(today, localDateTimeFormatter);
            System.out.println(localDate.format(dateFormatter));
        } catch (DateTimeParseException e) {
            System.out.println("Das hat nicht geklappt. Format falsch! Schade...");
        }
        UserInputScanner.pressReturnToContinue(new Scanner(System.in));
    }


    //Period

    //13. Schreibe eine Methode, die die Anzahl der Jahre zwischen zwei LocalDate-Instanzen berechnet
    static void aufgabe13() {
        LocalDate today = LocalDate.now();
        LocalDate later = LocalDate.now().plusDays(365);
        Period period = Period.between(today, later);
        System.out.println("Unterschied in Tagen: " + period.getYears());

    }

    //14. Schreibe eine Methode, die den Zeitraum zwischen
    //zwei LocalDate-Instanzen in Monaten und Tagen berechnet.
    static void aufgabe14() {
        LocalDate today = LocalDate.now();
        LocalDate later = LocalDate.now().plusDays(50);
        Period period = Period.between(today, later);

        System.out.println("Unterschied in Tagen und Monaten: "); //could have been done with period.getMonths/Days
        List<TemporalUnit> daysMonths = Arrays.asList(ChronoUnit.DAYS, ChronoUnit.MONTHS); //this enum has FOREVER LMAO
        for (TemporalUnit temporalUnit : daysMonths) { //just for playing around
            System.out.println(temporalUnit + ":\t" + period.get(temporalUnit));
        }
    }

    //15. Schreibe eine Methode, die den Zeitraum zwischen
    //zwei LocalDate-Instanzen in Jahren, Monaten und Tagen ausgibt.
    static void aufgabe15() {
        LocalDate today = LocalDate.now();
        LocalDate later = LocalDate.now().plusDays(400);
        Period period = Period.between(today, later);

        System.out.println("Unterschied in Tagen/Monaten/Jahren: ");
        for (TemporalUnit temporalUnit : period.getUnits()) { //time to shine :D
            System.out.println(temporalUnit + ":\t" + period.get(temporalUnit));
        }
    }
}
