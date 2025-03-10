package _20241210PflichtaufgabeMonsterGame.Monsterkampf;

public class Drache extends Monster {
    private final int feuerkraft;

    /**
     * Kreiert einen Drachen mit Namen, Leben und Angriff.
     * Abwandlung aufgrund der Aufgabenstellung.
     * @param angriffskraft wird hier zur Feuerkraft
     * @throws MonsterException
     * wenn Name leer oder Leben kleiner als 1.
     */
    Drache(String name, int leben, int angriffskraft) throws MonsterException {
        super(name, leben, angriffskraft);
        this.feuerkraft = super.getAngriffskraft();
    }

    /**
     * Reduziert Gegnerleben hier mit Feuer-
     * anstelle von Angriffskraft. Im Prinzip
     * wurde diese aber eh aus der Angriffskraft
     * des Superkonstruktors Monster abgeleitet.
     * @param gegner anzugreifendes Monster.
     */
    @Override
    public void angreifen(Monster gegner){
        int gegnerLeben = gegner.getLeben();
        System.out.printf("Angriff auf %s verursacht Schaden von %d%n", gegner.getName(), feuerkraft); //kleines Extra
        gegnerLeben -= feuerkraft;
        gegner.setLeben(gegnerLeben);
    }

    /**
     * Zeigt die Attribute des Drachen.
     * Hier mit Feuerkraft.
     */
    @Override
    public void getDetails() { //Später ggf. mit String Return
        System.out.printf("[Name: %s, Leben: %d, Feuerkraft: %d]%n", getName(), getLeben(), feuerkraft);
    }
}
