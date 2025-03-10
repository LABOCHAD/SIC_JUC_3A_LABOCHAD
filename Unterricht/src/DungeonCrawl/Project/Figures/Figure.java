package DungeonCrawl.Project.Figures;

import myTools.Color;

import java.util.Random;

public abstract class Figure {
    protected String name;
    public int health;
    protected int attack;
    private static final Random random = new Random();
    protected int agility;
    /*
    TODO add agility to be considered as ratio for gambling whose turn it is
    the bigger the agility as bound of randomizer, the bigger is the chance, that the random number will be bigger, too.
    must be added to every constructor in sub classes later, when implemented
    int playersChance = random.nextInt(player.getAgility());
    int enemyChance = random.nextInt(enemy.getAgility());
    if (playerChance > enemyChance){
    //players turn
    
     */

    public Figure(String name, int health, int attack, int agility) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.agility = agility;
    }

    /**
     * Provides normal attacking functionality.
     * Gambles if attack will succeed.
     * If health by victim falls below 0,
     * will be just 0. Output partially colored.
     * Also reports back if attack has failed.
     * @param f figure that is being attacked.
     */
    public void attack(Figure f) {
        System.out.println(name + " attacks normally.");
        if (random.nextBoolean()){
            System.out.println("Dealt damage: " + Color.RED + attack + Color.RESET);
            f.health = ((attack > f.health) ? 0 : f.health - attack);
        }
        else System.out.println("The attack has failed.");

    }

    public boolean isDead() {
        return (health == 0);
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public int getAgility() {
        return agility;
    }

    /**
     * Provides another attacking functionality.
     * Currently, damage is double of normal.
     * Gambles if attack will succeed.
     * If health by victim falls below 0,
     * will be just 0. Output partially colored.
     * Also reports back if attack has failed.
     * @param f figure that is being attacked.
     */
    public void specialSkill(Figure f) {
        int damage = attack * 2;
        if (random.nextBoolean()) {
            System.out.println("That was a strong attack.");
            System.out.println("Dealt damage: " + Color.RED + damage + Color.RESET);
            f.health = ((damage > f.health) ? 0 : f.health - damage);
        } else {
            System.out.println("That was a miss.");
        }
    }

    /**
     * Is being called every turn in fight.
     * So player can see how close he or his
     * enemy is to death and decide accordingly.
     */
    public void showHealthReport() {
        System.out.println("Current health of " + name + " is: " + health);
    }
}
