package _20241220_Wiederholungsaufgaben1_8;
//TODO nur zum Test.
// BITTE NICHT BEWERTEN!
// FEHLER, WENN VORHANDEN, ANALOG ZUR ANDEREN VERSION.
import java.util.ArrayList;

public class NurAufgabe4_GegenprobeWrappers {

//Anlegen der Testvariablen

    //primitive Typen
    static Byte byteVar = (byte) 0;
    static Short shortVar = (short) 0;
    static Integer intVar = 0;
    static Long longVar = 0L;
    static Float floatVar = 0.0f;
    static Double doubleVar = 0.0;

    static Character charVar = 'c';
    static Boolean boolVar = true;

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

        testGleichGleich();
        testEquals();
        testCompareTo();

    }

    public static void testGleichGleich() {

        System.out.printf("%nVergleiche Datentypen mit ==" +
                          "%nTeste Byte: %s" +
                          "%nTeste Short: %s" +
                          "%nTeste Integer: %s" +
                          "%nTeste Long: %s" +
                          "%nTeste Float: %s" +
                          "%nTeste Double: %s" +
                          "%nTeste Char: %s" +
                          "%nTeste Boolean: %s" +
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
        System.out.printf("%n%nVergleiche Datentypen mit equals()%n" +
                          "%nTeste Byte: %s" +
                          "%nTeste Short: %s" +
                          "%nTeste Integer: %s" +
                          "%nTeste Long: %s" +
                          "%nTeste Float: %s" +
                          "%nTeste Double: %s" +
                          "%nTeste Char: %s" +
                          "%nTeste Boolean: %s" +
                          "%nTeste String: %s" +
                          "%nTeste Array(int[]): %s" +
                          "%nTeste Array(Object[]): %s" +
                          "%nTeste Car (Beispielklasse): %s" +
                          "%nTeste ArrayList<Object>: %s",

                byteVar.equals(0),
                shortVar.equals(0),
                intVar.equals(0),
                longVar.equals(0),
                floatVar.equals(0.0f),
                doubleVar.equals(0.0),
                charVar.equals('c'),
                boolVar.equals(true),
                stringVar.equals("example"),
                arrayVarInt.equals(new int[2]),
                arrayVarObject.equals(new Object[2]),
                car.equals(new Car()),
                arrayListVar.equals(new ArrayList<>()));


    }

    public static void testCompareTo() { //object.compareTo(anotherObject) -> returns numeric/alphabetic shifting (-1, 0, 1)
        System.out.printf("%n%nVergleiche Datentypen mit .compareTo()" +
                          "%nTeste Byte: %s" +
                          "%nTeste Short: %s" +
                          "%nTeste Integer: %s" +
                          "%nTeste Long: %s" +
                          "%nTeste Float: %s" +
                          "%nTeste Double: %s" +
                          "%nTeste Char: %s" +
                          "%nTeste Boolean: %s" +
                          "%nTeste String: %s",

                byteVar.compareTo((byte) 0),
                shortVar.compareTo((short) 0),
                intVar.compareTo(0),
                longVar.compareTo(0L),
                floatVar.compareTo(0.0f),
                doubleVar.compareTo(0.0),
                charVar.compareTo('c'),
                boolVar.compareTo(true),
                stringVar.compareTo("example"));
    }

}
