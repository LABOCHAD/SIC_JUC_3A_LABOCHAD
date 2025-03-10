package _20250205ZooAufgabe;

public class Krokodil extends Reptil implements Schwimmen{
    public Krokodil(String name, int alter, boolean giftig) {
        super(name, alter, giftig);
    }

    @Override
    public void schwimme() {
        System.out.println("Das Krokodil gleitet lautlos durch den Fluss!");
    }
}
