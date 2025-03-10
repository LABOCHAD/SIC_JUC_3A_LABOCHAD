package _20250213CalendarAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

public class ProbeDateTimeAPI {
    public static void main(String[] args) {
        System.out.println("\nAufgabe 1");
        ersteÜbung();

        System.out.println("\nAufgabe 2");
        zweiteÜbung();

        System.out.println("\nAufgabe 3");
        dritteÜbung();

        System.out.println("\nAufgabe 4");
        vierteÜbung();

        System.out.println("\nAufgabe 5");
        fünfteÜbung();
    }

    static void fünfteÜbung() {
        // Gegeben sind drei Strings:
        //◦"28.02.2025" (ein Datum)
        //◦"14:45:30" (eine Uhrzeit)
        //◦"28.02.2025 14:45" (Datum und Zeit kombiniert)
        // Schreibe ein Programm, das diese Strings mit DateTimeFormatter in LocalDate, LocalTime und LocalDateTime umwandelt.
        // Gib die geparsten Werte in der Konsole aus.

        String date = "28.02.2025";
        String time = "14:45:30";
        String dateTime = "28.02.2025 14:45";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        try{
            LocalDate localDate = LocalDate.parse(date, dateFormatter);
            LocalTime localTime = LocalTime.parse(time, timeFormatter);
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);

            System.out.println(localDate.format(dateFormatter));
            System.out.println(localTime.format(timeFormatter));
            System.out.println(localDateTime.format(dateTimeFormatter));
        } catch (UnsupportedTemporalTypeException e){
            System.out.println(e.getMessage());
        }
    }

    static void vierteÜbung() {
        //Erstelle ein LocalDate-Objekt mit dem aktuellen Datum und formatiere es, sodass beispielsweise 12.02.2025 herauskommt.
        LocalDate today = LocalDate.now();
        String germanDate = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        //Erstelle ein LocalTime-Objekt mit der aktuellen Uhrzeit und formatiere es, sodass 12:32:50 herauskommt.
        LocalTime now = LocalTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm"));

        // Erstelle ein LocalDateTime-Objekt mit dem aktuellen Datum und der aktuellen Zeit
        // und formatiere es, sodass beispielsweise 12. Februar 2025 - 14:30 herauskommt.
        // Gib die formatierten Strings in der Konsole aus.
        LocalDateTime dateTime = LocalDateTime.of(today, now);
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm")));
    }

    static void dritteÜbung() {
        // Erstelle ein LocalDate-Objekt mit dem aktuellen Datum.
        LocalDate date = LocalDate.now();

        // Erstelle ein weiteres LocalDate-Objekt für den 1. Januar 2028.
        LocalDate fixDate = LocalDate.of(2028, Month.JANUARY, 1);

        // Berechne die Differenz zwischen diesen beiden Daten mit Period und gib aus, wie viele Jahre, Monate und Tage dazwischen liegen.
        Period period = Period.between(date, fixDate); //danke Ultimate :D
        System.out.println("Differenz zwischen heute und dem 01.01.2028: " +
                           "\nJahre:    " + period.getYears() +
                           "\nMonate:   " + period.getMonths() +
                           "\nTage:     " + period.getDays());

        // Erstelle ein LocalTime-Objekt mit der aktuellen Uhrzeit.
        LocalTime timeNow = LocalTime.now();

        // Erstelle ein weiteres LocalTime-Objekt, das um 3 Stunden und 45 Minuten später liegt.
        LocalTime fixTime = timeNow.plusHours(3).plusMinutes(40);

        // Erstelle ein LocalDateTime-Objekt für Silvester (31. Dezember 2024, 23:59 Uhr) und überprüfe, ob es nach der aktuellen Zeit liegt.
        LocalDateTime silvester2024 = LocalDateTime.of(2024, 12, 31, 23, 59);
        boolean isAfter = silvester2024.isAfter(LocalDateTime.now()); //isBefore für anderen Fall
        System.out.println("Silvester 2024 liegt nach der aktuellen Zeit: " + (isAfter ? "ja" : "nein"));
    }

    static void zweiteÜbung() {
        //DONE Ergänze system outs um Info wie: heute:, heute in 10 Jahren, ...
        //TODO formatieren später wenn noch Zeit ist
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss"); //HH 0-23, kk 1-24, hh AM/PM
        //kk statt hh macht 24h format - https://stackoverflow.com/questions/8907509/how-to-set-24-hours-format-for-date-on-java
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - hh:mm:ss");

        //◦Erstelle ein LocalDate-Objekt mit dem heutigen Datum und gib es aus.
        LocalDate date = LocalDate.now();
        System.out.println("Heute: " + dateFormatter.format(date));

        //◦Berechne das Datum in 3 Jahren, 2 Monaten und 10 Tagen und gib es aus.
        date = date.plusYears(3).plusMonths(2).plusDays(10);
        System.out.println("Heute in 3 Jahren, 2 Monaten und 10 Tagen: " + dateFormatter.format(date));

        //◦Erstelle ein LocalTime-Objekt mit der aktuellen Uhrzeit.
        LocalTime time = LocalTime.now();

        //◦Berechne die Uhrzeit in 5 Stunden und 30 Minuten und gib sie aus.
        time = time.plusHours(5).plusMinutes(30); //AM/PM Format???
        System.out.println("Jetzt in 5 Stunden und 30 Minuten: " + timeFormatter.format(time));

        //◦Erstelle ein LocalDateTime-Objekt mit dem aktuellen Datum und der aktuellen Uhrzeit.
        LocalDateTime dateTime = LocalDateTime.now();

        //◦Berechne das Datum und die Uhrzeit 1 Woche in der Vergangenheit und gib es aus.
        dateTime = dateTime.minusWeeks(1);
        System.out.println("Jetzt und heute vor einer Woche: " + dateTimeFormatter.format(dateTime));

    }

    static void ersteÜbung() {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.of(today, time); //oder LocalDateTime.now() aber dann ggf mit Verzögerung

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("Heute ist der: " + formatDate.format(today));
        System.out.println("Jetzt ist es: " + formatTime.format(time));
        System.out.println("Aktueller Zeitpunkt: " + formatDateTime.format(dateTime));
    }
}
