package _DungeonExplorer;

import myTools.Color;

/**
 * Basically built like the abstract character but with another attack method.
 */
public class Enemy extends Character {

    Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    /**
     * Prints out the attack, then invokes getting damage on target.
     * @param target that is being attacked.
     */
    @Override
    void attack(Character target) {
        System.out.printf("%nEnemy %s attacks Player %s with a strength of %s%d%s"
                , getName(), target.getName(), Color.RED, getAttackPower(), Color.RESET);
        target.takeDamage(getAttackPower());
    }

}
