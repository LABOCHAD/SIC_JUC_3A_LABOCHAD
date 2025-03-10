package _20250218Pflichtaufgabe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Task 1: Remove Negative Numbers from a List
//Requirements:
//•	Create a method removeNegativeNumbers(List<Integer> list).
//•	The method should use removeIf to remove all negative numbers from the list.
//•	The cleaned list should be printed in main using forEach.
//•	Use an ArrayList and fill it with 10 numbers.
public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-1, -2, 3, 4, -5, 6, -7, 8, -9, 10));
        System.out.println("\nBefore:");
        numbers.forEach(n -> System.out.print(n + " "));

        removeNegativeNumbers(numbers);
        System.out.println("\nAfter:");
        numbers.forEach(n -> System.out.print(n + " "));
    }

    static void removeNegativeNumbers(List<Integer> list){
        list.removeIf(n -> n < 0);
    }
}
