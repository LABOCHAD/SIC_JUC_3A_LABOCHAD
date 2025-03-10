package dingeTesten_LABOCHAD;

import java.util.Arrays;

public class ArrayInEinemStringAusgeben {
    public static void main(String[] args) {
        int[] testzahlen = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // new int[] kann man weglassen vor den {...}
        //teste andere Variante

        int zahlen2[] = {1,2};
        int zahlen3[] = new int[3]; //definiere mit Länge 3


        int[] zahlen5 = new int[] {}; //leere {} nur wenn Konstruktor ohne vorwerte und anzahl
        int[] zahlen6 = new int[3];

        //Gibt Array mit eckigen Klammern und Kommata getrennt aus
        System.out.println(Arrays.toString(testzahlen));
    }
}
