package _20250214PredicatesAndLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Gegeben ist eine Liste von Zahlen. Entferne alle Zahlen, die kleiner als 10 sind, mit der Methode removeIf.
//◦Schritt 1: Erstelle eine ArrayList<Integer> mit den Werten: [5, 12, 8, 20, 3, 15, 10].
//◦Schritt 2: Verwende removeIf, um alle Zahlen kleiner als 10 zu entfernen.
//◦Schritt 3: Gib die bereinigte Liste aus.
// Erwartete Ausgabe: [12, 20, 15, 10]
public class AufgabeRemoveIf {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(5, 12, 8, 20, 3, 15, 10);
        ArrayList<Integer> numbers = new ArrayList<>(numList);

        System.out.println("\nVorher:");
        System.out.println(numbers);
        //numbers.forEach(System.out::println); //Vorschlag der IDE
        //numbers.forEach(i -> System.out.print(i + " ")); //mit consumer


        System.out.println("\nEntferne alle Zahlen kleiner 10...");
        numbers.removeIf(n -> n < 10);

        System.out.println("\nNachher:");
        System.out.println(numbers);


    }
}
