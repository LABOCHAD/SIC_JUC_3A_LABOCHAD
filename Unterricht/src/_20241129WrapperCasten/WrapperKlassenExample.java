package _20241129WrapperCasten;

import java.util.ArrayList;

public class WrapperKlassenExample {
    public static void main(String[] args) {
        /*
        Beispiel Wrapper Klasse Interger
         */
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);  // Autoboxing von int zu Integer
        numbers.add(20);
        System.out.println(numbers);  // Ausgabe: [10, 20]

        // Autoboxing: Umwandlung von int in Integer
        int primitiveInt = 5;
        Integer wrapperInt = primitiveInt;

        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapper Integer: " + wrapperInt);

        // Unboxing: Umwandlung von Integer in int
        Integer wrapperInt1 = Integer.valueOf(10);
        //Integer wrapperInt2 = new Integer(10);
        int primitiveInt1 = wrapperInt;

        System.out.println("Wrapper Integer: " + wrapperInt1);
        System.out.println("Primitive int: " + primitiveInt1);

    }
}
