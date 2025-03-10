package _20241125AbstractClass.TaskAninmal;

public class Vogel extends Tier{

    Vogel(String name, String Gattung){
        super(name, Gattung);
    }

    @Override
    public void lautGeben() {
        System.out.println("Der Vogel macht \"Piep\"");
    }

    @Override
    public void bewegeDich() {
        System.out.println("Der Vogel fliegt.");
    }
}
