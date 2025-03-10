package _20250207PflichtaufgabeDungeonExplorer;

import myTools.Color;

/**
 * Sword class for making it collectable, equippable and usable for the player.
 * Has just name, damage and comment as basic parameters.
 */
public class Sword implements Item {
    private final String name;
    private final int damage;
    private String comment;


    Sword(String name, int damage, String comment) {
        this.name = Color.BLACK_BACKGROUND_BRIGHT + name + Color.RESET;
        this.damage = damage;
        this.comment = Color.MAGENTA + comment + Color.RESET;
    }

    public String getComment() {
        return this.comment;
    }

    //I know it is for exercise, but why the did we use an interface just for getters and casting a weapon as an item?
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String toString() {
        return "{" +
               "name='" + name + '\'' +
               ", damage=" + Color.RED + damage + Color.RESET +
               '}';
    }
}
