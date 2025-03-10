package _20241210PflichtaufgabeMonsterGame.Monsterkampf;

public abstract class Monster {
    private final String name;
    private int leben;
    private final int angriffskraft;

    /**
     * Kreiert ein Monster mit Namen, Leben und Angriff.
     * Konstruiere mit geprüfter Exception, um sicherzustellen,
     * dass das Spiel nicht mit Monstern läuft, die ungültige
     * Parameter aufweisen und so den Spielablauf stören.
     * @throws MonsterException wenn Name leer oder Leben < 1.
     */
    Monster(String name, int leben, int angriffskraft) throws MonsterException{
        if (name.isEmpty())
            throw new MonsterException("Name darf nicht leer sein!");
        if (leben <= 0)
            throw new MonsterException("Leben muss positive Zahl sein");
        this.name = name;
        this.leben = leben;
        this.angriffskraft = angriffskraft;
    }

    /**
     * Leben des Gegners wird um Angriffskraft
     * des Angreifers reduziert mit Ausgabe.
     * @param gegner anzugreifendes Monster.
     */
    public void angreifen(Monster gegner){
        int gegnerLeben = gegner.getLeben();
        System.out.printf("Angriff auf %s verursacht Schaden von %d%n", gegner.getName(), angriffskraft); //kleines Extra
        gegnerLeben -= angriffskraft;
        gegner.setLeben(gegnerLeben);
    }

    /**
     * Doch nicht abstract, weil so nur ein Override nötig ist.
     * Zeigt die Attribute der Monster.
     */
    public void getDetails() {
        System.out.printf("[Name: %s, Leben: %d, Angriff: %d]%n", getName(), getLeben(), getAngriffskraft());
    }

    public String getName() {
        return name;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public int getAngriffskraft() {
        return angriffskraft;
    }

}

