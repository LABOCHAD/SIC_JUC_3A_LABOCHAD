package _20250218Pflichtaufgabe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Task 4 (Hard): Replace All Even Numbers with Half Their Value
//Requirements:
//•	Create a method halveEvenNumbers(List<Integer> list).
//•	Use replaceAll to replace every even number with half its value (e.g., 8 → 8 / 2 = 4).
//•	Inside a Lambda expression after ->, you can use {} to add an if condition and return the appropriate value.
//•	The method should be called in main, and the result should be printed using forEach.
//•	Use an ArrayList and fill it with 10 numbers.
public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.println("\nBefore:");
        numbers.forEach(i -> System.out.print(i + " "));

        System.out.println("\nAfter:");
        halveEvenNumbers(numbers);
        numbers.forEach(i -> System.out.print(i + " "));
    }

    static void halveEvenNumbers(List<Integer> list) {
        list.replaceAll(i -> { //works like a charm, but I turned off suggestions for this, for finding it myself.
            if (i % 2 == 0)
                return i / 2;
            else
                return i;
        });
    }
}
