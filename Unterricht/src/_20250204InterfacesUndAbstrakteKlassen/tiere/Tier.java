package _20250204InterfacesUndAbstrakteKlassen.tiere;

public abstract class Tier {
    private String name;

    Tier(String name){
        this.name = name;
    }

    public abstract void geraeuschMachen();

    public void zeigeTier(){
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }
}
