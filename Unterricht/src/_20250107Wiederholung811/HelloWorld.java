package _20250107Wiederholung811;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] array = new int[3];
        array[0] = 75;
        array[1] = 25;
        array[2] = 50;

        List<Object> list = new ArrayList<>();
        list.add(0, 75);
        list.add(1, 25);
        list.add(2, 50);

        for (int aElement : array) { System.out.print(aElement + "% "); }
        System.out.println();
        for (Object lElement : list) { System.out.print(lElement + "% ");  }
        String s = "";
        String ss = "";
        System.out.println(s.equals((ss)));


    }
}
