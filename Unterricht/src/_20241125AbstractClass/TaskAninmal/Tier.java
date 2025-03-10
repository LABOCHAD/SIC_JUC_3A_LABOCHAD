package _20241125AbstractClass.TaskAninmal;

public abstract class Tier extends Lebewesen{
    protected String name;

    Tier(String name, String Gattung) {
        super(Gattung);
        this.name = name;
    }

    public abstract void lautGeben();

    public abstract void bewegeDich();
}
