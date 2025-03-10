package _20250204PflichtaufgabeFahrzeugSystem;

public class AbstraktesFahrzeug {
    protected String model;
    protected int maxGeschwindigkeit;
    protected String Kennzeichen;
    //wieso protected und nicht private?

    AbstraktesFahrzeug(String modell, String kennzeichen, int maxGeschwindigkeit) {
        this.model = modell;
        this.Kennzeichen = kennzeichen;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    //laut Aufgabenstellung nie verwendet. Schade :D
    void detailsAnzeigen() {
        System.out.printf("""
                Details zum Fahrzeug:
                Modell:                     %s
                Maximale Geschwindigkeit:   %s
                Kennzeichen:                %s
                
                """, this.model, this.maxGeschwindigkeit, this.Kennzeichen);
    }

}
