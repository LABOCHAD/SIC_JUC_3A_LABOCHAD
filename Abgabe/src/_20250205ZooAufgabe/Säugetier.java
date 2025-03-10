package _20250205ZooAufgabe;

// Unterklasse Säugetier
class Säugetier extends Tier{
    protected String fellFarbe;

    public Säugetier(String name, int alter, String fellFarbe) {
        super(name, alter);
        this.fellFarbe = fellFarbe;

    }

    @Override
    public void macheGeräusch() {
        System.out.println(this.name + " brummt.");
    }

    @Override
    public void füttern(String futter) {
        if (futter.equalsIgnoreCase("Pflanzen") || futter.equalsIgnoreCase("Fleisch"))
            super.füttern(futter);
        else
            System.out.println(this.name + ": Futter passt nicht!");
    }

    @Override
    public String toString() {
        return super.toString() +
               "Fellfarbe:  " + fellFarbe;

    }
}
