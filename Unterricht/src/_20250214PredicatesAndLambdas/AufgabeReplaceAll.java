package _20250214PredicatesAndLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Eine Liste enthält Namen, die in Kleinbuchstaben geschrieben sind. Verwandle alle Namen in
//Großbuchstaben mithilfe der Methode replaceAll.
//◦ Schritt 1: Erstelle eine ArrayList<String> mit den Werten: ["anna", "bob", "charlie", "david"].
//◦ Schritt 2: Verwende replaceAll, um alle Namen in Großbuchstaben umzuwandeln.
//◦ Schritt 3: Gib die transformierte Liste aus.
//Erwartete Ausgabe: ["ANNA", "BOB", "CHARLIE", "DAVID"]
public class AufgabeReplaceAll {
    public static void main(String[] args) {
        //List<String> list = Arrays.asList("anna", "bob", "charlie", "david");
        //ArrayList<String> names = new ArrayList<>(list));
        ArrayList<String> names = new ArrayList<>(Arrays.asList("anna", "bob", "charlie", "david"));

        System.out.println("\nDavor: "+names);
        //unary operator -> accepts a string and returns one as well
        names.replaceAll((n) -> n.toUpperCase()); //works without reassignment, because set() is used internally

        System.out.println("\nDanach: "+names);



    }
}
