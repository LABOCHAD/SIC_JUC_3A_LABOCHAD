package _20241129WrapperCasten;

public class WrapperKlassenSolutions {
    public static void main(String[] args) {
       /*
        Schreibe ein Programm, das eine Zeichenkette "123" in eine Integer-Zahl umwandelt und
        diese Zahl dann als String zurückgibt.
         */
        String str = "123";

        // String zu Integer konvertieren
        Integer number = Integer.valueOf(str);
        System.out.println("Integer: " + number);

        // Integer zu String konvertieren
        String strAgain = number.toString();
        System.out.println("String: " + strAgain);

        /*
        Schreibe ein Programm, das zwei Integer-Objekte vergleicht. Verwende dazu die Methode compareTo() der
        Integer-Klasse und gib das Ergebnis aus.
         */
        Integer num1 = 50;
        Integer num2 = 100;

        // Vergleich der Wrapper-Objekte
        int result = num1.compareTo(num2);

        if (result < 0) {
            System.out.println(num1 + " ist kleiner als " + num2);
        } else if (result > 0) {
            System.out.println(num1 + " ist größer als " + num2);
        } else {
            System.out.println(num1 + " ist gleich " + num2);
        }
    }
}
