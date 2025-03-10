package _20250204InterfacesUndAbstrakteKlassen.klanggeber;

public class Gitarre implements Klanggeber{

    @Override
    public void erzeugeKlang() {
        System.out.println("Gitarrenklang: Strumm!");
    }

}
