package _20241220_Wiederholungsaufgaben1_8;

import java.util.ArrayList;

public class Aufgabe4Bis6 {

//Anlegen der Testvariablen

    //primitive Typen
    static byte byteVar = 0;
    static short shortVar = 0;
    static int intVar = 0;
    static long longVar = 0;
    static float floatVar = 0.0f;
    static double doubleVar = 0.0;

    static char charVar = 'c';
    static boolean boolVar = true;

    //Referenztypen
    static String stringVar = "example";

    //Array
    static int[] arrayVarInt = new int[2]; //Array, es wurde nicht gesagt welches
    static Object[] arrayVarObject = new Object[2]; //Generische Alternative

    //Car
    static class Car {
        //inner class just for comparison
    }

    static Car car = new Car();
    //static Car anotherCar = new Car();

    static ArrayList<Object> arrayListVar = new ArrayList<>(); //<Object> als generic dazu


    public static void main(String[] args) {

        System.out.println("Aufgabe 4");
        testGleichGleich();
        testEquals();
        testCompareTo();

        System.out.println("Aufgabe 5");
        aufgabe5();

        System.out.println("Aufgabe 6");
        aufgabe6();
    }

    //Aufgabe 4
    public static void testGleichGleich() {
        //TODO Das ist etwas unübersichtlich bzw sehr lang, man kann das ganze noch kürzer und übersichtlicher gestalten.
        System.out.printf("%nVergleiche Datentypen mit ==" +
                          "%nTeste byte: %s" +
                          "%nTeste short: %s" +
                          "%nTeste int: %s" +
                          "%nTeste long: %s" +
                          "%nTeste float: %s" +
                          "%nTeste double: %s" +
                          "%nTeste char: %s" +
                          "%nTeste boolean: %s" +
                          "%nTeste String: %s" +
                          "%nTeste Array(int[]): %s" +
                          "%nTeste Array(Object[]): %s" +
                          "%nTeste Car (Beispielklasse): %s" +
                          "%nTeste ArrayList<Object>: %s",
                byteVar == 0,
                shortVar == 0,
                intVar == 0,
                longVar == 0,
                floatVar == 0.0f,
                doubleVar == 0.0,
                charVar == 'c',
                boolVar == true,
                stringVar == "example",
                arrayVarInt == new int[2],
                arrayVarObject == new Object[2],
                car == new Car(),
                arrayListVar == new ArrayList<>());
    }

    public static void testEquals() { //object.equals(anotherObject) -> same content
        System.out.printf("%n%nVergleiche Datentypen mit .equals()" +

                          "%nTeste String: %s" +
                          "%nTeste Array(int[]): %s" +
                          "%nTeste Array(Object[]): %s" +
                          "%nTeste Car (Beispielklasse): %s" +
                          "%nTeste ArrayList<Object>: %s",

                stringVar.equals("example"),
                arrayVarInt.equals(new int[2]),
                arrayVarObject.equals(new Object[2]),
                car.equals(new Car()),
                arrayListVar.equals(new ArrayList<>()));

    }

    public static void testCompareTo() { //object.compareTo(anotherObject) -> returns numeric/alphabetic shifting (-1, 0, 1)
        System.out.printf("%n%nVergleiche Datentypen mit .compareTo()" +
                          "%nTeste String: %d",
                stringVar.compareTo("example"));
        //TODO Tipp: Gewöhne dir an lieber alles auf Englisch oder alles auf Deutsch zu kommentieren. Das ist einheitlicher.
        //Zusatztest mit Wrapper
        Integer i = intVar;
        System.out.println("\nInteger Wrapper compareTo(): "+i.compareTo(intVar));
        Character c = 'C';
        Boolean b = true;
        System.out.println(b.compareTo(false));
        System.out.println();
    }
    //Ende Aufgabe 4

    public static void aufgabe5() {
        System.out.println("Vergleiche einen double mit einem int: ");
        double d = 1.0;
        int i = 1;
        System.out.printf("Der double %.2f entspricht dem integer %d: %s%n%n", d, i, (d == (double) i));

        System.out.println("Vergleiche einen String mit einem int: ");
        String s = "2";
        i = 2;
        System.out.printf("Der String \"%s\" entspricht dem integer %d: %s%n%n", s, i, (Integer.parseInt(s) == i));
    }

    public static void aufgabe6() {
        System.out.println("Vergleiche einen String mit einem int bis erfolgreich: ");
        String s = "Wort";
        int i = 2;
        boolean isParseSuccess;

        do {
            System.out.printf("%nDer String \"%s\" entspricht dem integer %d: ", s, i);
            try{
                System.out.print(Integer.parseInt(s) == i);
                isParseSuccess = true;
            } catch (NumberFormatException e) {
                System.out.print(false);
                isParseSuccess = false;
                s = "2";
                System.out.printf("%nVersuche es nun mit \"2\"");
            }
        } while (!isParseSuccess); //besagter "Neustart des Programms"

    }

}
