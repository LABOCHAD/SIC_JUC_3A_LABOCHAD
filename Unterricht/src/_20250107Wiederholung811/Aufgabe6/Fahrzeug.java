package _20250107Wiederholung811.Aufgabe6;

public class Fahrzeug{
    private String marke;
    private int geschwindigkeit;

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public void start(){
        System.out.println("Fahrzeug startet.");
    }
}
