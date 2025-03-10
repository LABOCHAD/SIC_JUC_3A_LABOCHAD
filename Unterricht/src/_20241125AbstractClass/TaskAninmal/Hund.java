package _20241125AbstractClass.TaskAninmal;

public class Hund extends Tier {


    Hund(String name, String Gattung) {
        super(name, Gattung);
    }

    @Override
    public void lautGeben() {
        System.out.println("Der Hund macht \"Wuff\"");
    }

    @Override
    public void bewegeDich() {
        System.out.println("Der Hund läuft auf allen Vieren");
    }

}
