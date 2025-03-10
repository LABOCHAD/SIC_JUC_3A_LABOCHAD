package _20250303_MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

//•Erstelle eine Liste von Strings.
//•Erstelle eine zusätzliche Methode, welche die Länge ausgibt.
//•Rufe nun innerhalb der Main-Methode die in Punkt 2 erstelle Methode mittels Method References auf.
//•Programmiere das Gleiche auch mithilfe eines Lambdas.
//•Welches ist von der Schreibweise leserlicher?
public class StringListe {
    public static void main(String[] args) {
        String string = "Hallo wir sind eine Liste von Wörtern für eine Liste von Strings."; //12
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(string.split(" ")));
        printLength(strings);

        Consumer<List<String>> consumer = list -> System.out.println(list.size());
        consumer.accept(strings);
    }

    static void printLength(List<String> list){
        System.out.println(list.size());
    }
}
