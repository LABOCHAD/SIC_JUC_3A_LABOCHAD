package _20241204Exceptions;

import java.util.ArrayList;

public class ExercisesExceptionsTryCatch {
    public static void main(String[ ] args) {
        exampleOne();
        taskOne();
        taskTwo();
    }

    //Example try-catch
    public static void exampleOne() {
        int[] myNumbers = {1, 2, 3};
        try {
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try catch' is finished.");
        }
    }

    //TODO 1: Überlege dir, welche Fehler eintreten könnte und schreibe ein passendes Exceptionshandling
    // ohne finally
    public static void taskOne() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        try{
            System.out.println(list.get(5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    //TODO 2: Überlege dir, welche Fehler eintreten könnte und schreibe ein passendes Exceptionshandling
    // mit finally
    public static void taskTwo() {
        ArrayList<Integer> listNull = null;
        try{
           System.out.println(listNull.add(5));
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Here is the end.");
        }
    }
}
