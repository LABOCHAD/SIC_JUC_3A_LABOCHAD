package _20250214Pflichtaufgabe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Aufgabe3 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList(Arrays.asList("Hello", "test", "", "!"));

        //String::isEmpty suggestion IDE method reference (to containing class?)
        // "" is empty string with length zero, but not null
        Predicate<String> isEmpty = s -> s.isEmpty();

        for (String str : strings) {
            System.out.printf("%nString: \"%s\" is empty: %s%n", str, isEmpty.test(str) ? "yes" : "no");
        }
    }
}
