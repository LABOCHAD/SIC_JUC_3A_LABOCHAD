package _20250207WdhBedingungenSchleifenArrays;

import java.util.ArrayList;

public class Ternary {
    public static void main(String[] args) {
        int neg = -1;
        int pos = +1;
        int zero = 0;

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(neg);
        numbers.add(pos);
        numbers.add(zero);

        System.out.println("\nMit if-else Konstruktion");
        for (int i : numbers) {
            System.out.print("Die Zahl " + i + " ist ");
            if (i > 0)
                System.out.print("positiv");
            else if (i < 0)
                System.out.print("negativ");
            else
                System.out.print("null");
            System.out.println();
        }

        System.out.print("\nMit ternärer Operation");
        for (int i : numbers) {
            System.out.print("\nDie Zahl " + i + " ist ");
            System.out.print((i > 0) ? "positiv" : ((i < 0)? "negativ" : "null"));
        }
        System.out.println();


    }
}
