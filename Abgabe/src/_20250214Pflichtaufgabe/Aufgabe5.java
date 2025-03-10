package _20250214Pflichtaufgabe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Aufgabe5 {
    public static void main(String[] args) {
        ArrayList<Integer> zahlen = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Predicate<Integer> isEven = i -> i % 2 == 0;

        //inline invocation within for each loop :)
        System.out.println("\nGefundene gerade Zahlen:");
        for(Integer i : getEvenNumbers(zahlen, isEven)) {
            System.out.println(i);
        }
    }

    static ArrayList<Integer> getEvenNumbers (ArrayList<Integer> list, Predicate<Integer> isEvenPredicate) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (Integer i : list) {
            if (isEvenPredicate.test(i))
                evenNumbers.add(i);
        }

        return evenNumbers; //empty list, of no even number has been found.
    }
}
