package _20250204InterfacesUndAbstrakteKlassen.tiere;

public class Löwe extends Tier implements Laufen{
    public Löwe(String name) {
        super(name);
    }

    @Override
    public void laufen() {
        System.out.println("Der Löwe läuft.");
    }

    @Override
    public void geraeuschMachen() {
        System.out.println("Der Löwe brüllt: ROAAARRR!");
    }
}
