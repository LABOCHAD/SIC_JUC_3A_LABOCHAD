package _20241122ArrayList;

import java.util.ArrayList;

public class Obstkiste {
    public static void main(String[] args) {
        //1.
        System.out.println("1. Erstelle Obstkiste.");
        ArrayList<String> obstkiste = new ArrayList<>();
        obstkiste.add("Bananen");
        obstkiste.add("Äpfel");
        obstkiste.add("Birnen");

        //2.
        System.out.println("2. Erstes Element des Obstkorbes: " + obstkiste.getFirst()); //geht auch mit .get(0)

        //3.
        obstkiste.remove(2); //entferne Birnen an Stelle 3 / Index 2
        //geht auch mit enhanced loop for (String s : obstkorb){sout s}
        System.out.println("3. Birnen wurden aus dem Obstkorb entfernt, noch übrig: " + obstkiste); //.toString, wenn anderer Typ (vgl. Arrays.asList(Arr))


        //4.
        System.out.println("4. Größe der Obstkiste: " + obstkiste.size());

        //5.
        System.out.println("5.1. Enthält die Kiste noch Birnen?: " + (obstkiste.contains("Birnen") ? "ja" : "nein"));
        System.out.println("5.2. Enthält die Kiste noch Bananen?: " + (obstkiste.contains("Bananen") ? "ja" : "nein"));

        //5.5
        System.out.println("5.5. Packe wieder Birnen an Stelle 2: ");
        obstkiste.add(2, "Birnen"); //nur zur Übung
        System.out.println("5.5 Inhalt jetzt: "+ obstkiste); //ein add hätte gereicht, weil letzte Stelle

        //6.
        obstkiste.clear();
        System.out.println("6. Inhalt des Korbes nach Leerung: " + obstkiste);
    }
}
