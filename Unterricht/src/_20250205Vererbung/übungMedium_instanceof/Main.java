package _20250205Vererbung.übungMedium_instanceof;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Medium> medien = new ArrayList<>();

        Medium medium = new Medium("Beispielmedium");
        Medium bravo = new Zeitschrift("Bravo", 69);
        Medium präluzid = new Buch("Präluzid - Die göttliche Fügung", "Dominik Paolo Labocha");

        medien.add(medium);
        medien.add(bravo);
        medien.add(präluzid);

        for (Medium m : medien){
            m.zeigeInfo();

            //Variante aus der Aufgabenstellung
            if (m instanceof Buch){
                Buch buch = (Buch) m;
                System.out.printf("\nDieses Buch wurde von %s geschrieben.", buch.getAutor());
            }

            //--- ab hier optional ---

            //kürzere Alternative (Pattern-Variable, Vorschlag der IDE)
            //ERST AB JAVA 17!
/*            if (m instanceof Buch buch){
                System.out.printf("\nDieses Buch wurde von %s geschrieben.", buch.getAutor());
            }*/

            //"ekelhafte" Variante :D
            if (m instanceof Buch)
                System.out.printf("\nDieses Buch wurde von %s geschrieben.", ((Buch) m).getAutor());
        }
    }
}
