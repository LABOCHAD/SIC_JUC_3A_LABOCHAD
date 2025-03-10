package _20250205ZooAufgabe;

// Spezialisierung Löwe
class Löwe extends Säugetier {
    protected String lieblingsbeschäftigung;

    public Löwe(String name, int alter, String fellFarbe, String lieblingsbeschäftigung) {
        super(name, alter, fellFarbe);
        this.lieblingsbeschäftigung = lieblingsbeschäftigung;
    }

    @Override
    public void macheGeräusch() {
        System.out.println(this.name + " brüllt.");
    }

    @Override
    public void füttern(String futter) {
        if (futter.equalsIgnoreCase("Fleisch"))
            super.füttern(futter);
        else
            System.out.println(this.name + " brüllt wütend, weil es kein Fleisch gibt!");
    }

    @Override
    public String toString() {
        return super.toString()
               + "\nLieblingsbeschäftigung:  "
               + lieblingsbeschäftigung;
    }
}