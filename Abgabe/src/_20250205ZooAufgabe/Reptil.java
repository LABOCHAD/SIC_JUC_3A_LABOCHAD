package _20250205ZooAufgabe;

// Unterklasse Reptil
class Reptil extends Tier {
    protected boolean giftig;

    public Reptil(String name, int alter, boolean giftig) {
        super(name, alter);
        this.giftig = giftig;
    }

    @Override
    public void macheGeräusch() {
        System.out.println(this.name + " zischt.");
    }

    @Override
    public void füttern(String futter) {
        if (futter.equalsIgnoreCase("kleine Tiere") || futter.equalsIgnoreCase("Eier"))
            super.füttern(futter);
        else
            System.out.println(this.name + " mag sein Futter nicht und spuckt es wieder aus.");
    }

    @Override
    public String toString() {
        return super.toString() +
               "Giftig:     " +
               ((giftig) ? "ja" : "nein");

    }
}
