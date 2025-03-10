package _20250214PredicatesAndLambdas;

import myTools.Color;

import java.util.ArrayList;
import java.util.Arrays;

@FunctionalInterface
interface StringTransformer {
    String transform(String input);
}

//1.Erstelle ein funktionales Interface, welches eine abstrakte Methode transform(String s) hat, die einen String zurückgibt
//2.Erstelle eine statische Methode transformStrings, die als Parameter eine Liste an Strings und eine Instanz des Interfaces aus
// 1) entgegennimmt und die transformierten Strings in einer Liste zurückgibt.
// 3.Nun soll eine Liste an Strings jeweils wie folgt transformiert und danach ausgegeben werden:
// 1.Originalstrings soll ausgegeben werden
// 2.Der String soll in Großbuchstaben ausgegeben werden
// 3.Alle Vokale sollen mit einem Y ersetzt werden
public class AufgabeTransform {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Hallo", "wir", "sind", "eine", "Liste", "bestehend", "aus", "Strings"));
        StringTransformer original = s -> s; //useless, but why not :D
        StringTransformer upperCase = s -> s.toUpperCase();
        StringTransformer replaceVowelsWithY = s -> s.replaceAll("[aeiouAEIOU]", Color.RED + "Y" + Color.RESET);

        testAllOfThem(strings, original, "originaler String");
        testAllOfThem(strings, upperCase, "Großgeschriebener String");
        testAllOfThem(strings, replaceVowelsWithY, "Alle Vokale durch Y ersetzen");
    }

    static ArrayList<String> transformStrings(ArrayList<String> strings, StringTransformer transformer) {
        for (String string : strings) {
            string = transformer.transform(string);
        }
        return strings;
    }

    static void testAllOfThem(ArrayList<String> strings, StringTransformer transformer, String scenario) {
        System.out.println("\nTeste: " + scenario);
        for (String string : strings) {
            string = transformer.transform(string);
            System.out.println(string);
        }
    }
}