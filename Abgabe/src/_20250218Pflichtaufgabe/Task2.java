package _20250218Pflichtaufgabe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Task 2: Remove All Words with Less Than 5 Characters
//Requirements:
//•	Create a method removeShortWords(List<String> list).
//•	Use removeIf to remove all strings with fewer than 5 characters.
//•	The method should be called in main, and the result should be printed using forEach.
//•	Use an ArrayList and fill it with 6 strings.
public class Task2 {
    public static void main(String[] args) {
        String sentence = "Hello, I am a string holding words for testing a method in this task.";
        String[] words = sentence.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(words)); //cool, man kann ein primitives Array zur Liste machen :D

        System.out.println("\nBefore:");
        list.forEach(s -> System.out.print(s + " "));

        System.out.println("\nAfter:");
        removeShortWords(list);
        list.forEach(s -> System.out.print(s + " "));
    }

    static void removeShortWords(List<String> words){
        words.removeIf(word -> word.length() < 5);
    }
}
