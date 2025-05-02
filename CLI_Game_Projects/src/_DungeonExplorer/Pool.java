package _DungeonExplorer;

import myTools.Color;

import java.util.ArrayList;
import java.util.Random;

/**
 * Auxiliary class for providing all the stuff that has to be spread allover the dungeon's field.
 */
public class Pool {
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<Sword> swords = new ArrayList<>();
    //P = Player, E = Enemy, C = Chest (Treasure), X = Exit; _ = empty space, + = Heal potion
    Random random = new Random();
    private int potions;
    private final int exits;

    //Fill ArrayLists on initialization
    {
        enemies.add(new Enemy((Color.RED + "Fire Dragon" + Color.RESET), random.nextInt(50, 201), random.nextInt(10, 21)));
        enemies.add(new Enemy((Color.MAGENTA + "Shadow Golem" + Color.RESET), random.nextInt(50, 201), random.nextInt(10, 21)));
        enemies.add(new Enemy((Color.GREEN + "Venom Creature" + Color.RESET), random.nextInt(50, 201), random.nextInt(10, 21)));
        enemies.add(new Enemy((Color.CYAN + "Depression" + Color.RESET), random.nextInt(50, 201), random.nextInt(10, 21)));

        swords.add(new Sword("Excalibur", random.nextInt(10,51), "You have knighted to Sir Cum A Lot :D"));
        swords.add(new Sword("Skull Crusher", random.nextInt(10,51), "And his name is JOHN CENAAA!!! (🎶🎵🎺)"));
        swords.add(new Sword("Your Parents' disappointment", random.nextInt(10,51), "You gathered the force of EMOTIONAL DAMAGE!!!"));

        potions = 3;
        exits = 1;
    }

    /**
     * For making sure, the dungeon's dimension won't be smaller than things those have to be placed.
     * @return the number of fields that will be needed (without the player).
     */
    public int getFullCountOfStuff() {
        return swords.size() + enemies.size() + potions;
    }

    /**
     * For not letting player leave, until everything has been encountered.
     * @return if there are still items not collected or enemies not fought.
     */
    public boolean isPoolEmpty() {
        return (enemies.isEmpty() && swords.isEmpty() && potions == 0);
    }

    public int getPotionsCount() {
        return potions;
    }

    public void getOnePotion() {
        this.potions--;
    }

    public int getEnemyCount() {
        return enemies.size();
    }

    public int getChestCount() {
        return swords.size();
    }

    /**
     * Chooses an enemy randomly from the List.
     * @return the chosen enemy.
     */
    public Enemy getAnEnemy() {
        Enemy enemy = enemies.get(random.nextInt(enemies.size()));
        enemies.remove(enemy);
        return enemy;
    }

    /**
     * Chooses a sword randomly from the List.
     * @return the chosen sword.
     */
    public Sword getASword() {
        Sword sword = swords.get(random.nextInt(swords.size()));
        swords.remove(sword);
        return sword;
    }

    public int getExitCount() {
        return exits;
    }
}
