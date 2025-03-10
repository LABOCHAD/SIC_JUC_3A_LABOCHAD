package _20250204PflichtaufgabeFahrzeugSystem;

public class Motorrad extends AbstraktesFahrzeug implements Fahrzeug{
    private boolean hatHelmpflicht; //Gemäß Konvention ergänzt

    Motorrad(String modell, String kennzeichen, int maxGeschwindigkeit, boolean hatHelmpflicht) {
        super(modell, kennzeichen, maxGeschwindigkeit);
        this.hatHelmpflicht = hatHelmpflicht;
    }

    @Override
    public void starten() {
        System.out.println("Das Motorrad startet.");
    }

    @Override
    public void stoppen() {
        System.out.println("Das Motorrad hält an.");

    }

    @Override
    public void beschleunigen(int geschwindigkeit) {
        System.out.println("Das Motorrad beschleunigt um/auf " + geschwindigkeit);
    }

    public void beschleunigen(int geschwindigkeit, int gang) {
        System.out.format("%nDas Motorrad beschleunigt um/auf %s und schaltet in den %s. Gang.%n", geschwindigkeit, gang);
    }

    @Override
    public String toString() {
        return "Motorrad{" +
               "hatHelmpflicht=" + hatHelmpflicht +
               ", model='" + model + '\'' +
               ", maxGeschwindigkeit=" + maxGeschwindigkeit +
               ", Kennzeichen='" + Kennzeichen + '\'' +
               '}';
    }
}
