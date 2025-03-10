package _20250205ZooAufgabe;

// Basisklasse Tier
class Tier {
    protected String name;
    protected int alter;

    public Tier(String name) {
        this(name, 0); //Dummywert um Konstruktor korrekt zu bedienen
    }

    public Tier(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public void macheGeräusch() {
        System.out.println("Das Tier macht ein Geräusch.");
    }

    public void füttern(String futter) {
        System.out.println(this.name + " bekommt " + futter + ".");
    }

    @Override
    public String toString() {
        return String.format("""
                        
                        Art:        %s
                        Name:       %s
                        Alter:      %s
                        """,
                this.getClass().getName().split("\\.")[1], //split um den packagename auszuschließen
                this.name,
                this.alter
        );
    }

    public String getName() {
        return name;
    }
}











