package _20250303_MethodReferences;

import java.util.ArrayList;
import java.util.List;

//•Erstelle eine Klasse MathHelper mit einer statischen Methode doubleTheValue(int value), die den Wert verdoppelt.
//•Erstelle in der Main-Methode eine Liste an Zahlen
//•Ersetze alle Elemente (replaceAll) mit dem verdoppelten Wert.
//•Gebe nun jedes Element der Liste in der Konsole aus.
//•Nutze Methoden-Referenzen!
public class MathHelper {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList();
        for (int i = 1; i < 11; i++) {
            numbers.add(i);
        }

        numbers.replaceAll(MathHelper::doubleTheValue);
        numbers.forEach(System.out::println);
    }

    static int doubleTheValue(int value){
        return value*2;
    }
}
