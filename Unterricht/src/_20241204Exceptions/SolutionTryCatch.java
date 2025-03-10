package _20241204Exceptions;

import java.util.ArrayList;

public class SolutionTryCatch {
    public static void taskOne() {
        try {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            System.out.println(list.get(5));
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    public static void taskTwo() {
        try{
            ArrayList<Integer> listNull = null;
            System.out.println(listNull.add(5));
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}
