package _20250214Pflichtaufgabe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Aufgabe2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-5,0,10); //erstelle fix-große Liste, asList gibt eine ArrayList zurück.
        //ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-5,0,10)); //falls explizit ArrayList gewünscht.
        //https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line

        Predicate<Integer> isBiggerZero = i -> i > 0; //überschreibe die boolean test(T t), i hier ist ungleich dem unten, kann auch x sein.

        for (Integer i : list) {
            System.out.printf("%n%d ist größer als 0: %s", i, isBiggerZero.test(i) ? "ja":"nein"); //hier darf auch i genommen werden, weil tieferer scope
        }




    }
}
