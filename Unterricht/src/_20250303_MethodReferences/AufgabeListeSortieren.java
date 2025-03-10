package _20250303_MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Sortieren einer Liste
//•Erstelle eine Liste von Namen und sortieren Sie diese alphabetisch mithilfe einer Methodenreferenz. Nutze dafür die Methode compareTo der Klasse String.
//•Ergänze den Code, sodass die Namen in der Konsole ausgegeben werden. Nutze hierfür ebenfalls Methodenreferenzen
public class AufgabeListeSortieren {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Cäsar","Berta","Anton");
        //names.add("Dominik"); //UnsupportedOperationException
        ArrayList<String> sameNames = new ArrayList<>(Arrays.asList("Cäsar","Berta","Anton"));
        sameNames.add(1, "Dominik");

        names.sort(String::compareTo); //"statischer" Aufruf auf Instanzen der Klasse
        sameNames.sort(AufgabeListeSortieren::compare); //alternativ eigene Methode

        names.forEach(System.out::println);
        System.out.println();
        sameNames.forEach(System.out::println);
    }

    static int compare(String a, String b) {
        return a.compareTo(b);
    }

}
