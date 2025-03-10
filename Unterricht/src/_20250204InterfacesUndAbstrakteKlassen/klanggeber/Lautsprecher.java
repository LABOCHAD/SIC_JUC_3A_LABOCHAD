package _20250204InterfacesUndAbstrakteKlassen.klanggeber;

public class Lautsprecher implements Klanggeber {

    @Override
    public void erzeugeKlang() {
        System.out.println("Bass: Wumm Wumm");
    }

}
