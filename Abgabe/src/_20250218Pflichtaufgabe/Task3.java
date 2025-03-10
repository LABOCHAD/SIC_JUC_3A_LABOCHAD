package _20250218Pflichtaufgabe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Task 3: Remove Words Containing a Specific Character
Requirements:
•	Create a method removeWordsContainingChar(List<String> list, char character).
•	The method should use removeIf to remove all words that contain the given character.
    O	Example: If character = 'L' and the ArrayList contains "Hello", "Hello" should be removed because it contains two 'L's.
•	The cleaned list should be printed using forEach.
•	Use an ArrayList, fill it with 6 strings, and test the method 2–3 times with different characters when calling the method.
*/
public class Task3 {
    public static void main(String[] args) {
        String sentence = "Hello there, I am another example for testing another method in here.";
        char c = 'e';
        ArrayList<String> words = new ArrayList<>(Arrays.asList(sentence.split(" "))); //works as well, nice.

        System.out.println("\nBefore:");
        words.forEach(s -> System.out.print(s + " "));
        System.out.println("\nAfter:");
        removeWordsContainingChar(words, c);
        words.forEach(s -> System.out.print(s + " "));
    }

    static void removeWordsContainingChar(List<String> list, char character){
        list.removeIf(s -> s.indexOf(character) != -1); //if char has been found, index != -1 //.contains doesn't work with char
    }

}
