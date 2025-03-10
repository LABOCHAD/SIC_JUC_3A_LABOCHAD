package _20250304DatenstrukturenHashMapSet;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class AufgabeTreeMap {
    public static void main(String[] args) {
        Comparator<String> comparator = ( s1,  s2) -> s2.compareTo(s1); //reversed order
        Comparator<String> comparator2 = String::compareTo;
        TreeMap<String, String> kunden_bestellungen = new TreeMap<>(comparator);
        kunden_bestellungen.put("Spongebob", "Schneckenfutter");
        kunden_bestellungen.put("Thaddäus", "Klarinette");
        kunden_bestellungen.put("Patrick", "Eiscreme");

        System.out.println("Bestellungen:");
        for (Map.Entry<String, String> eintrag : kunden_bestellungen.entrySet()) {
            System.out.println(eintrag.getKey() + " \t: " + eintrag.getValue());
        }

        System.out.println(kunden_bestellungen);
    }
}
