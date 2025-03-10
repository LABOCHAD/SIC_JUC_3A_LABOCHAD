package _20241129WrapperCasten;

public class CastingSolutions {
    public static void main(String[] args) {

        // 1. Primitive Datentypen
        int intValue = 42;
        double doubleValue = 12.34;
        float floatValue = 5.67f;
        char charValue = 'A';
        boolean booleanValue = true;

        // 2. Automatisches Casting
        long longValue = intValue;  // int zu long (automatisch)
        double doubleFromFloat = floatValue;  // float zu double (automatisch)

        System.out.println("Automatisches Casting:");
        System.out.println("int zu long: " + longValue);
        System.out.println("float zu double: " + doubleFromFloat);

        // 3. Manuelles Casting
        int intFromDouble = (int) doubleValue;  // double zu int (manuell)
        short shortFromLong = (short) longValue;  // long zu short (manuell, Datenverlust möglich)

        System.out.println("\nManuelles Casting:");
        System.out.println("double zu int: " + intFromDouble);
        System.out.println("long zu short: " + shortFromLong);
    }
}
