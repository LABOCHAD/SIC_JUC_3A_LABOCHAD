package _20250207PflichtaufgabeDungeonExplorer;

import myTools.Color;

/**
 * General definition for characters in the game.
 */
public abstract class Character {

    private String name;
    private int health;
    private int attackPower;

    Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    /**
     * How to attack will be defined in subclasses each.
     * @param target that is being attacked.
     */
    abstract void attack(Character target);

    /**
     * Evaluates if health still over zero.
     * @return if character is still alive.
     */
    boolean isAlive() {
        return (health > 0);
    }

    /**
     * Reduces health by damage taken and displays feedback.
     * @param damage that has been dealt.
     */
    void takeDamage(int damage) {
        this.health -= damage;
        System.out.printf("%n%s takes damage of %d.%n", name, damage);
    }

    /**
     * Quite a basic toString Override, except the output of the calling class's name.
     * This way it can be used for all subclasses just displaying basics info.
     * Another override in subs won't be needed this way.
     * @return a String of the attributes am´n arranged way.
     */
    @Override
    public String toString() {
        //getting classname of caller directly makes toString for subs each obsolete
        //works for enemies as well as for players like a charm, that's why I love being lazy as hell :D
        return getClass().getName().split("\\.")[1] + " {" +
               "name = '" + name + '\'' +
               ", health = " + Color.GREEN + health + Color.RESET +
               ", attackPower = " + Color.RED + attackPower + Color.RESET +
               '}';
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
