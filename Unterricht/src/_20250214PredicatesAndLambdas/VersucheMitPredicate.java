package _20250214PredicatesAndLambdas;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class VersucheMitPredicate {
    public static void main(String[] args) {
        vierteÜbung();


    }

    static void ersterVersuch(){
        Predicate<Integer> isEven = i -> i % 2 == 0;

        System.out.println(isEven.test(1));

        //Der Ansatz hier war komplett fürn Arsch, geil -.-
/*    static boolean isEven(int number, Predicate<Integer> predicate) {
        boolean even = false;
        if (predicate.test(number)) {
            even = true;
        }
        return even;
    }*/

        //Kann auch vereinfacht werden
//    static boolean isEven(int number, Predicate<Integer> predicate) {
//        return predicate.test(number);
//    }
    }

    static void zweiterVersuch(){
        //Schreibe einen Predicate<Integer>, der true zurückgibt, wenn die Zahl größer als 20 ist, sonst fals.
        //Das könnte folgendermaßen aussehen:
        //Predicate<Integer> biggerThan20 = LAMBDA-AUSDRUCK;
        //Teste deine Lösung, indem du folgendes eingibst:
        //System.out.println(biggerThan20.test(15));

        Predicate<Integer> isBiggerThan20 = i -> i > 20;
        System.out.println(isBiggerThan20.test(21));
        System.out.println(isBiggerThan20.test(20));
        System.out.println(isBiggerThan20.test(15));
    }

    static void dritteÜbungMitString(){
        //Schreibe einen Predicate<String>, der true zurückgibt, wenn ein String mit dem Buchstaben „A“ beginnt.
        //Das könnte folgendermaßen aussehen:
        //  Predicate<String> beginsWithA = LAMBDA-AUSDRUCK;
        //Teste deine Lösung.

        Predicate<String> hasAFirst = s -> s.startsWith("A"); //s = parameter -> bool'sche Frage
        String string1 = "Anita";
        String string2 = "Dominik";
        System.out.println(string1 + " beginnt mit einem A: " + (hasAFirst.test(string1) ? "ja" : "nein"));
        System.out.println(string2 + " beginnt mit einem A: " + (hasAFirst.test(string2) ? "ja" : "nein"));


    }

    static void vierteÜbung(){
        //Schreibe einen Predicate<String, Integer>, der true zurückgibt, wenn die Länge des Strings gleich der angegebenen Zahl ist.
        //Das könnte folgendermaßen aussehen:
        //  Predicate<String, Integer> lengthMatches = LAMBDA - AUSDRUCK; //BiPredicate!
        //Teste deine Lösung.

        //It was supposed to be BiPredicate instead of Predicate -.-
        BiPredicate<String, Integer> isLongAsNumIsBig = (s, i) -> s.length() == i;
        System.out.println(isLongAsNumIsBig.test("Dominik", 10));

    }

}


