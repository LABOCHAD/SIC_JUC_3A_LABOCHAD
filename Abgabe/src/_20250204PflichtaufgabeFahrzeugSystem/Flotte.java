package _20250204PflichtaufgabeFahrzeugSystem;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private List<Fahrzeug> fahrzeuge= new ArrayList<>();

    void fahrzeugHinzufuegen(Fahrzeug f){
        fahrzeuge.add(f);
    }

    void alleFahrzeugeAnzeigen(){
        for (Fahrzeug f : fahrzeuge){
            if (f instanceof AbstraktesFahrzeug)
                ((AbstraktesFahrzeug) f).detailsAnzeigen();
            //System.out.println(f.toString());
            //in welcher Form sollen die Fahrzeuge ausgegeben werden?
        }
    }

    void gesamtAnzahlFahrzeuge(){
        System.out.println("Anzahl der Fahrzeuge: " + fahrzeuge.size());
    }

    public List<Fahrzeug> getFahrzeuge() {
        return fahrzeuge;
    }
}
