package DungeonCrawl.Project.Figures;

import DungeonCrawl.Project.Figures.Enemies.Enemy;
import DungeonCrawl.Project.GamePlay;
import myTools.Color;
import java.util.Random;

public class Player extends Figure {

    public final int initialHealth;

    //This might be useful later, when implementing difficulties
    public Player(String name, int health, int attack, int agility) {
        super(name, health, attack, agility);
        initialHealth = health;
    }

    //predefined default for now
    public Player(String name) {
        super(name, 100, 25, 50);
        initialHealth = health;
    }

    /**
     * Is being called every turn in fight.
     * So player can see how close he is to
     * death and decide accordingly.
     * Additionally stated is health has
     * already fallen below 50% or even 20%
     * of initial full health of the player.
     * Colored depending on current health loss.
     */
    @Override
    public void showHealthReport() {
        super.showHealthReport();
        if (health < initialHealth * 0.2)
            System.out.println(Color.RED + "You have less than 20% health!" + Color.RESET);
        else if (health < initialHealth * 0.5)
            System.out.println(Color.YELLOW + "You have less than 50% health!" + Color.RESET);
    }

    @Override
    public void specialSkill(Figure f) {
        //insert figure specific attacking text here each
        System.out.println("You fokus all your strength in order to make a strong hit.");
        super.specialSkill(f);
    }

    /**
     * Only applicable by player, not enemies.
     * Gambles if healing is possible at all.
     * Reports if not. Reports back if player
     * was already full life, otherwise gambles
     * in a range between 20% and 50% of full
     * health how many health points will be
     * restored and reports back considering
     * if healing led to full or partial heal.
     */
    public void heal(Enemy enemy) {
        if (health == initialHealth) {
            System.out.println("You are already full life. Don't waste your turns.");
            return;
        }

        System.out.println("You take out a heal potion to restore your health.");

        if (!GamePlay.isPlayerFasterByAgility(this, enemy)) {
            System.out.println(Color.RED + "Your enemy smashed the viol, before you could drink the potion." +
                               " You couldn't heal yourself." + Color.RESET);
            return;
        }

        Random randomHealing = new Random();
        int recovery = (int) randomHealing.nextDouble(initialHealth * 0.2, initialHealth * 0.5);

        if (health + recovery > initialHealth) {
            health = initialHealth;
            System.out.println(Color.GREEN + "You are fully healed to " + initialHealth + Color.RESET);
        } else {
            health += recovery;
            System.out.println(Color.GREEN + "You're healed by " + recovery + Color.RESET);
        }
    }

}
