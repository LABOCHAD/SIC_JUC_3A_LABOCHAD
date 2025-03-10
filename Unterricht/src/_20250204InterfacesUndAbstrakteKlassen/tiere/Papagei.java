package _20250204InterfacesUndAbstrakteKlassen.tiere;

public class Papagei extends Tier{
    public Papagei(String name) {
        super(name);
    }

    @Override
    public void geraeuschMachen() {
        //https://www.youtube.com/watch?v=Lz9Rwa-eIgE deshalb macht er WTF :D
        System.out.println("Der Papagei macht: What the fuck. What the ... FUCK! 😂");
    }
}
