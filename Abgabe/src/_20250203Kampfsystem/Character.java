package _20250203Kampfsystem;

import myTools.Color;
import myTools.UserInputScanner;

import java.util.Random;
import java.util.Scanner;

/**
 * This is NOT the Wrapper class!
 */
class Character {
    private String name;
    private int health;
    private int attackPower;
    private int defense;

    Character() {
        this("Unknown Fighter", 100, 10, 5); //this() not with . in between!
    }

    Character(String name, int health, int attackPower, int defense) {
        this.name = Color.CYAN + name + Color.RESET;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public static void main(String[] args) {
        fight();
    }


    private static void fight(){
        Character fighter1 = new Character("Dominik", 100, 30, 5);
        Character fighter2 = new Character();

        Character attackingFighter = (new Random().nextBoolean()) ? fighter1 : fighter2; //choose first

        while (true) {
            Character targetFighter = (attackingFighter == fighter2) ? fighter1 : fighter2; //set other as target

            System.out.format("%n%s's current health: %s", attackingFighter.getName(), attackingFighter.getHealth());
            System.out.format("%n%s's current health: %s%n%n", targetFighter.getName(), targetFighter.getHealth());

            attackingFighter.attack(targetFighter);
            if (targetFighter.getHealth() <= 0) {
                System.out.println(attackingFighter.getName() + Color.GREEN + " has won the fight. 🥳" + Color.RESET);
                break;
            }
            UserInputScanner.pressReturnToContinue(new Scanner(System.in));
            attackingFighter = (attackingFighter == fighter2) ? fighter1 : fighter2;
        }
    }

    //For exercise only, confuses while debugging as hell.
    public void attack() {
        System.out.format("Character %s attacks with an attacking power of %s.%n", this.name, this.attackPower);
    }

    public void attack(Character target) {

        System.out.format("Character %s attacks with an attacking power of %s%s%s.%n"
                , this.name, Color.RED, this.attackPower, Color.RESET);

        int damage = (target.getDefense() < this.getAttackPower()) ? this.getAttackPower() - target.getDefense() : 0;

        if (damage > 0) {
            target.setHealth(target.getHealth() - damage);

            System.out.format("%s's health has been reduced by %s%s%s.%n",
                    target.getName(), Color.RED, damage, Color.RESET);
        } else
            System.out.println(Color.GREEN + target.getName() + " could defend successfully." + Color.RESET);
    }

    //Not in use, was only part of a task.
    public void specialAttack(String... moves) {
        Random random = new Random();
        int i = random.nextInt(moves.length);
        String move = moves[i];
        System.out.format("%n%s applies special attack %s!", this.getName(), move);
        //Is this even supposed to make any damage? :D
    }


    // Getter-Setter-Section

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0)
            this.health = health;
        //could throw an invalid health exception
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
