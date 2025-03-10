package _20250214PredicatesAndLambdas;

import myTools.UserInputScanner;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateLambdaAlsParameter {

    //2.In der Main-Methode:
    //•Schreibe eine Benutzereingabe, die das Alter abfragt
    //•Rufe die Methode checkForVoteRight auf und überprüfe, ob der Benutzer über 16 ist.
    // Speichere das Ergebnis in einer Variablen.
    //•Wenn ja, dann hat er das Recht wählen zu gehen. Wenn nicht, dann muss er leider zu Hause bleiben.
    // Mache Konsolenausgaben.
    public static void main(String[] args) {
        System.out.print("\nType in an age: ");
        int age = UserInputScanner.getIntOnlyPos(new Scanner(System.in));

        Predicate<Integer> hasVotingAge = i -> i >= 16; //benenne von außen quasi .test() um

        boolean result = checkForVoteRight(age, hasVotingAge);

        System.out.println("The person with the age " + age + " has voting age: " + ((result) ? "right" : "wrong"));

    }

    //1.Erstelle eine statische Methode boolean checkForVoteRight(int age, Predicate<Integer>predicate)
    //◦Die Methode soll das Ergebnis des Tests zurückgeben. Nutze dafür die test() Methode
    static boolean checkForVoteRight(int age, Predicate<Integer> predicate) { //wir übergeben quasi eine Frage in einer Box
        return predicate.test(age); //.test ist standardmäßig die Funktion, deshalb der Aufruf, wir haben es overriden
        //wir nehmen das Alter und schieeeben es in test von Predicate
    }
}
