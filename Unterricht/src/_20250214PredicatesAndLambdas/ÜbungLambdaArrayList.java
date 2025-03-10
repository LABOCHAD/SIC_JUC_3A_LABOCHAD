package _20250214PredicatesAndLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ÜbungLambdaArrayList {

    public static void main(String[] args) {
        //2.Teste deine Methode mit folgenden Beispielen:
        //  welche Wörter der Liste sind mindestens 5 Zeichen lang?
        //  welche Wörter beginnen mit dem Buchstaben J?
        //  welche Wörter beginnen mit einem Vokal?
        //  welche Wörter sind mindestens 6 Zeichen lang und beginnen mit einem Vokal?
        //Nutze hierfür Lambdas, Predicate und die dazugehörige test()-Methode.
        //List<String> worte = Arrays.asList("Hallo", "Java", "Algorithmus", "Entwicklung", "Objekt", "Union", "Code", "Umbau");

        List<String> worte = Arrays.asList("Hallo", "Java", "Algorithmus", "Entwicklung", "Objekt", "Union", "Code", "Umbau");

        Predicate<String> hasMin5Chars = s -> s.length() >= 5;
        Predicate<String> startsWithJ = s -> s.toLowerCase().startsWith("j");

        //Danke Anita und Arthur :)
        Predicate<String> startsWithAVowelRegex = s -> s.matches("^[AEIOUaeiou].*"); //Patterns, Lernbeispiel
        Predicate<String> hasMin6CharsAndSTartsWithVowel = s -> s.length() >= 6 && startsWithAVowelRegex.test(s);

        //Beispiel von Arthur, erklärt von Tobi
        Predicate<String> startsWithVowelByIndexOf = s -> "aeiouäöü".indexOf(s.toLowerCase().charAt(0)) != -1;

        //Mein ursprünglicher Versuch
        Predicate<String> startsWithAVowel = s ->
                s.toLowerCase().startsWith("a") ||
                s.toLowerCase().startsWith("e") ||
                s.toLowerCase().startsWith("i") ||
                s.toLowerCase().startsWith("o") ||
                s.toLowerCase().startsWith("u"); //Gibts da auch was Kompakteres, wie startet mit, dem oder dem?

        //Mein etwas dynamischerer Mittelweg ohne Regex.
        Predicate<String> vowelsTestLooped = s -> {
            String[] vowels = {"a", "o", "i", "o", "u"};
            for (String vowel : vowels) {
                if (s.startsWith(vowel)) {
                    return true;
                }
            }
            return false;
        };

        //Teste jeden Filter nacheinander. (nicht kaskadiert)
        makeTest(worte, hasMin5Chars, "hat mind. 5 Zeichen");
        makeTest(worte, startsWithJ, "beginnt mit J");
        makeTest(worte, startsWithAVowel, "beginnt mit Vokal");
        makeTest(worte, hasMin6CharsAndSTartsWithVowel, "ist 6 Zeichen lang und beginnt mit Vokal");

    }

    //1.Erzeuge eine Methode filterWords(List<String>words, Predicate<String>predicate), die eine Liste an gefilterten Worten zurückgibt.
    //1.Es soll eine neue ArrayList erzeugt werden, wo die gefilterten Worte abgespeichert werden sollen
    //2.Eine Schleife soll über die übergebene Liste gehen
    //3.Sobald ein String den Test besteht, landet es in der neuen ArrayList
    static ArrayList<String> filterWords(List<String> words, Predicate<String> predicate) {
        ArrayList<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (predicate.test(word)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

    //Zusatzmethode, um nicht jeden Test neu zu schreiben.
    static void makeTest(List<String> words, Predicate<String> predicate, String testCondition) {
        ArrayList<String> wordsReturned = filterWords(words, predicate);

        System.out.println("\nTeste: " + testCondition);
        for (String word : wordsReturned) {
            System.out.println(word);
        }
    }
}
