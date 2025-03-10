package _20250304DatenstrukturenHashMapSet;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Implementiere eine HashMap, die Städte als Schlüssel und deren Einwohnerzahl als Wert speichert.
// Füge einige Städte hinzu und gib die Einwohnerzahl einer bestimmten Stadt aus.
// Gebe alle Elemente der Map aus.
class AufgabeHashMapStädte {
    public static void main(String[] args) {
        HashMap<String, Integer> staedte = new HashMap<>(); //Interface Map -> Abstract Map -> HashMap
        staedte.put("Berlin", 3_432_000);
        staedte.put("Hamburg", 1_946_000);
        staedte.put("Hannover", 513_300);

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        for (Map.Entry<String, Integer> eintrag: staedte.entrySet()) { //Statischer Aufruf Entry aus Map-Interface
            //System.out.printf("%n%s : %,.2f", eintrag.getKey(), (float) eintrag.getValue());
            System.out.printf("%n%s : %,d", eintrag.getKey(), eintrag.getValue());
            //System.out.printf("%n%s : %s", eintrag.getKey(), numberFormat.format(eintrag.getValue()));

        }



    }
}
