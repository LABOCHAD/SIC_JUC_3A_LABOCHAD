package _20250107Wiederholung811.Lernplan.Lernfortschritt811;

public class WiederholungWrapper {
    //Auszug aus: https://freiheit.f4.htw-berlin.de/prog2/wrapper/

    public static void main(String[] args) {
        // Wrapper-Klassen haben die Klassenmethoden
        // valueOf(Wertetyp b) ...
        Integer iObject1 = Integer.valueOf(100);
        Boolean bObject1 = Boolean.valueOf(true);
        Double dObject1 = Double.valueOf(5.5);

        // ... oder valueOf(String s)
        Integer iObject2 = Integer.valueOf("100");
        Boolean bObject2 = Boolean.valueOf("true");
        Double dObject2 = Double.valueOf("5.5");

        //Prüfe ob Referenz bei gleichem hinterliegendem Literal gleich ist
        System.out.println(iObject1==iObject2);
        String s = String.valueOf(iObject1.intValue());

    }

}
