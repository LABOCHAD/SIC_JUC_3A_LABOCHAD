package _20250107Wiederholung811.Aufgabe6;

public class Auto extends Fahrzeug{
    private int anzahlTueren;

    public int getAnzahlTueren() {
        return anzahlTueren;
    }

    public void setAnzahlTueren(int anzahlTueren) {
        this.anzahlTueren = anzahlTueren;
    }

    @Override
    public void start(){
        System.out.println("Auto startet.");
    }
}
