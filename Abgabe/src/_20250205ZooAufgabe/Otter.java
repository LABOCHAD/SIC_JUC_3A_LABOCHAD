package _20250205ZooAufgabe;

public class Otter extends Säugetier implements Schwimmen{
    public Otter(String name, int alter, String fellFarbe) {
        super(name, alter, fellFarbe);
    }

    @Override
    public void schwimme() {
        System.out.println("Der Otter paddelt flink durch das Wasser!");
    }
}
