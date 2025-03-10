package _20250214Pflichtaufgabe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Aufgabe4 {
    public static void main(String[] args) {
        ArrayList<Integer> taskNumbers = new ArrayList(Arrays.asList(5, 33, 39));
        ArrayList<Integer> myNumbers = new ArrayList();

        //eben schnell befüllen
        for (int i = 15; i <= 45; i += 5) {
            taskNumbers.add(i);
        }

        //zwischen != von - bis, also exklusive
        //Ich stehe ja auch zwischen zwei Wänden, nicht in ihnen.
        Predicate<Integer> isBetween20And40 = x -> x > 20 && x < 40;

        System.out.println("\nTestzahlen nach Aufgabenstellung:");
        iterateNumbers(taskNumbers, isBetween20And40);

        System.out.println("\nNochmal mit eigener Liste");
        iterateNumbers(myNumbers, isBetween20And40);

        //Durch mein Herumspielen hat sich zufällig noch eine weitere Anwendung des Gelernten ergeben. :)
        //Die Methode mit Übergabe des Predicate war nicht geplant, bis hier zwei for-Schleifen waren. :D
    }

    static void iterateNumbers(ArrayList<Integer> numbers, Predicate<Integer> predicate) {
        for (Integer number : numbers) {
            System.out.printf("%n%d ist zwischen 20 und 40: %s", number, predicate.test(number) ? "ja" : "nein");
        }
    }
}
