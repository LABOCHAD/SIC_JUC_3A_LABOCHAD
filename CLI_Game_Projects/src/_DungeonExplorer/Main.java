package _DungeonExplorer;

/**
 * Just a launcher, nothing special in here.
 */
public class Main {
    //TODO consider more Items like Potions, shields, Treasures, …
    //TODO consider more several Players to chose from initially (Warrior, Mage,…).
    //TODO consider surrounding exit with more enemies

    /**
     * Creates a game and starts it.
     * @param args not considered.
     */
    public static void main(String[] args) {
        DungeonGame dg = new DungeonGame();
        dg.start();

    }
}
