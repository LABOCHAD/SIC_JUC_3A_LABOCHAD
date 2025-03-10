package _20250214PredicatesAndLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Gegeben ist eine Liste mit Städtenamen. Gib jeden Städtenamen aus, indem du forEach nutzt.
//◦ Schritt 1: Erstelle eine List<String> mit den Werten: ["Berlin", "München", "Hamburg", "Stuttgart"].
//◦ Schritt 2: Verwende forEach, um jeden Städtenamen auszugeben.
public class AufgabeForEach {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Berlin", "München", "Hamburg", "Stuttgart");
        //Consumer: Takes an item as iterator and processes a void action
        cities.forEach(city -> System.out.println(city));
        cities.forEach(System.out::println);
    }
}
