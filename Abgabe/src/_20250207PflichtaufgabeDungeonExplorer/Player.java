package _20250207PflichtaufgabeDungeonExplorer;

import myTools.Color;

public class Player extends Character {
    int strength = getAttackPower(); //basic attack power plus weapon power (if any is equipped).
    Item weapon; //for raising attackPower
    int[] position = new int[2];
    int initialHealth = getHealth();

    Player(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    Player(String name) {
        super(name, 100, 25);
    }

    /**
     * Allows a player to heal, but doesn't avoid heal waste.
     * It makes sure heal won't exceed initial health.
     *
     * @param recovery the amount of HP healed.
     */
    void heal(int recovery) {
        if (getHealth() + recovery <= initialHealth) {
            System.out.printf("%nYour health recovers by %d.%n", recovery);
            this.setHealth(getHealth() + recovery);
        } else {
            System.out.println("Your health is fully restored.");
            this.setHealth(initialHealth);
        }

    }

    /**
     * Assigns a passes item to the player as a weapon.
     * The Interface Item makes sure there is no item without a getter for damage.
     * Player's attack power and weapon's damage will be summed to player's new strength.
     * If the weapon is a sword, its comment will be printed out immediately.
     *
     * @param weapon that will be passes after collecting by player (if he wants).
     */
    void equip(Item weapon) {
        this.weapon = weapon;
        this.strength = getAttackPower() + weapon.getDamage(); //not += getDamage, in case the weapon will change
        //I added it already here and not in attack, because the task asked what happens to attackPower in here.
        System.out.printf("%nYour strength has been set to %d thanks to %s.%n", strength, weapon.getName());
        if (weapon instanceof Sword) System.out.println(((Sword) weapon).getComment());
    }

    /**
     * Prints out the attack with its power.
     * It looks for a weapon equipped and adds up the strength if there is any.
     * Invokes enemy to take the damage.
     *
     * @param target that is being attacked.
     */
    @Override
    void attack(Character target) {
        System.out.printf("%nPlayer %s attacks Enemy %s with a strength of %s%d.%s%n"
                , getName(), target.getName(), Color.RED, strength, Color.RESET);
        target.takeDamage(strength);
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        if (position.length > 2)
            throw new IllegalArgumentException("There should be exact two coordinates.");
        this.position = position;
    }

    public Item getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst("}","") +
               ", strength = " + Color.RED + strength + Color.RESET +
               '}';
    }
}
