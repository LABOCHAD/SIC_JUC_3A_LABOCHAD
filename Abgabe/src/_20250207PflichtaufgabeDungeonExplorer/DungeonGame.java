package _20250207PflichtaufgabeDungeonExplorer;

import myTools.Color;
import myTools.UserInputScanner;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Here is where the gameplay happens and the logic is being implemented.
 * Initially, a dungeon is being created and filled randomly from pool.
 * As soon as the player tries to move, it will be looked for encounters.
 * If there is an interaction like items or enemies according action occurs.
 * Player can move, collect items, fight, heal and finally leave when finished.
 */
public class DungeonGame {
    private static final char EMPTY = '-';
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Pool pool = new Pool();

    //Make sure there will be enough space for all elements to be placed
    private final int MIN_SIZE = pool.getFullCountOfStuff() + 1; //+1 for the player;
    Player player = new Player(Color.BLUE + "Dominik" + Color.RESET);
    char[][] dungeon;

    //Further Auxiliaries
    boolean isOver = false;
    char ContentAimedField;
    boolean hasAlreadyCollected; //make sure not more than one weapon can be collected in a row.
    boolean hasNotFoughtYet = true;


    /**
     * Invokes dungeon's creation and filling, then loops until the player dies or leaves.
     */
    void start() {
        initializeDungeon();
        fillDungeon();
        do {
            printDungeon();
            System.out.printf("%nWhich direction do you want to go? (W/A/S/D)?: ");
            try {
                movePlayer(scanner.nextLine().charAt(0));
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Please choose a direction!");
            }
        } while (!isOver);
        scanner.close();
    }

    /**
     * Initializes the dungeon array and fills if with the empty delimiter.
     * The minimal necessary size is being considered, but the dungeon is not rectangular.
     * (Since I learned, a 2D array is not only a rectangle matrix of rows and cols
     * but more like arrays inside a carrying array, and I also learned for the 811
     * that an array can be reassigned with another; that brought me to the idea of
     * bringing it to a new level of randomizing each row's length by reassigning.)
     */
    void initializeDungeon() {
        //make non-rectangles grid possible
        dungeon = new char[MIN_SIZE][1];

        for (int i = 0; i < dungeon.length; i++) {
            dungeon[i] = new char[random.nextInt(MIN_SIZE) + 2];
            //+2: make sure there will be no bottlenecks (1 col) or even rows with 0 cols (making areas unreachable).
        }

        for (char[] chars : dungeon) {
            Arrays.fill(chars, EMPTY); //really, there was an array fill method the whole time? :D
        }
    }

    /**
     * Gets the count if everything in the pool and mirrors their counts.
     * Sets the player first and then a randomized switch case placing the rest
     * runs inside a loop till everything has been placed in the dungeon.
     * The randomized switch case is not necessary, but it feels less predetermined.
     */
    void fillDungeon() {
        int enemyCount = pool.getEnemyCount();
        int chestCount = pool.getChestCount();
        int exitCount = pool.getExitCount();
        int potionsCount = pool.getPotionsCount();

        setRandomly('P'); //set Player anywhere

        while (enemyCount > 0 || chestCount > 0 || exitCount > 0 || potionsCount > 0) {

            switch (random.nextInt(1, 5)) {
                case 1: {
                    if (enemyCount == 0)
                        continue;
                    enemyCount--;
                    setRandomly('E');
                    break;
                }
                case 2: {
                    if (chestCount == 0)
                        continue;
                    chestCount--;
                    setRandomly('C');
                    break;
                }
                case 3: {
                    if (exitCount == 0)
                        continue;
                    exitCount--;
                    setRandomly('X');
                    break;
                }
                case 4: {
                    if (potionsCount == 0)
                        continue;
                    potionsCount--;
                    setRandomly('+'); //Heal Potion
                    break;
                }
                default: {
                    System.err.println("Something went wrong here!");
                }
            }
        }

    }

    /**
     * Tries to set passes content in the dungeon till it finds a free field.
     * If the content was the player, its position will be assigned.
     *
     * @param c content that has to be placed in the dungeon.
     */
    void setRandomly(char c) {
        int row;
        int col;

        do {
            row = random.nextInt(dungeon.length);
            col = random.nextInt(dungeon[row].length);
        }
        while (dungeon[row][col] != EMPTY);
        if (c == 'P') player.setPosition(new int[]{row, col});
        dungeon[row][col] = c;
    }

    /**
     * Prints out the dungeon giving all occurrences an own color.
     */
    void printDungeon() {
        System.out.println("\n" + player);

        for (char[] x : dungeon) {
            System.out.println();
            for (char y : x) {
                if (y == 'X')
                    System.out.print("  " + Color.GREEN + y + Color.RESET);
                else if (y == 'E')
                    System.out.print("  " + Color.RED + y + Color.RESET); //for making enemies displayed red
                else if (y == 'C')
                    System.out.print("  " + Color.YELLOW + y + Color.RESET);
                else if (y == 'P')
                    System.out.print("  " + Color.BLUE + y + Color.RESET);
                else if (y == '+')
                    System.out.print("  " + Color.GREEN_BRIGHT + y + Color.RESET);
                else
                    System.out.print("  " + y);
            }
        }
        System.out.println();
    }

    /**
     * First evaluates the input direction as coordinate shift, the look what lies on that field, if reachable.
     * Starts the action depending on the encounter with the player.
     * If the player did not die or leave, his position is reassigned.
     *
     * @param direction where the player tries to walk in.
     */
    void movePlayer(char direction) {
        int playerRow = player.getPosition()[0];
        int playerCol = player.getPosition()[1];
        int aimedRow = playerRow;
        int aimedCol = playerCol;

        //find out shift on board by direction
        switch (direction) {
            case 'w', 'W': {
                aimedRow--;
                break;
            }
            case 'a', 'A': {
                aimedCol--;
                break;
            }
            case 's', 'S': {
                aimedRow++;
                break;
            }
            case 'd', 'D': {
                aimedCol++;
                break;
            }
            default: {
                System.out.println("Couldn't move player.");
                return;
            }
        }

        try {
            ContentAimedField = dungeon[aimedRow][aimedCol];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid direction. Couldn't move character.");
            return;
        }

        //start action depending on content of target field.
        switch (ContentAimedField) {
            case 'E': {
                if (player.getWeapon() == null) {
                    System.err.println("You should get a weapon first.");
                    return;
                }
                fight();
                break;
            }
            case 'C': {
                if (hasAlreadyCollected) {
                    System.err.println("\nYou must compete the next fight before you collect anything new.");
                    return;
                }
                collectItem();
                break;
            }
            case '+': {
                System.out.println("You found a heal potion. 💖");
                player.heal(random.nextInt(50, 100));
                pool.getOnePotion();
                break;
            }
            case 'X': {
                if (pool.isPoolEmpty()) {
                    System.out.println(Color.GREEN + "Congratulations! You could escape successfully. 🥳\n" + Color.RESET);
                    isOver = true;
                    return;
                } else {
                    System.err.println("Seems like you forgot something...");
                    return;
                }
            }
            case EMPTY:
                break;
            default: {
                System.out.println("We found something and we don't know how to handle it.");
                UserInputScanner.pressReturnToContinue(scanner);
                return;
            }
        }

        //shift player's position if not already died
        if (!isOver) {
            dungeon[aimedRow][aimedCol] = 'P';
            player.setPosition(new int[]{aimedRow, aimedCol});
            dungeon[playerRow][playerCol] = EMPTY;
        }
    }

    /**
     * Gets an enemy from the pool and starts a fight.
     * Shows opponents' parameters and makes one make a move randomized in a loop.
     * Depending on who wins, feedback will be printed.
     * States the game as over if the player dies.
     */
    void fight() {
        hasNotFoughtYet = false;
        Enemy enemy = pool.getAnEnemy();
        System.out.println("\n" + enemy.getName() + " appears.");
        final int MAX_TURNS = 3; //avoids too many turns from one side in a row
        int enemyTurns = 0;
        int playerTurns = 0;
        do {
            System.out.println("-----------------------------------------------");
            System.out.printf("%n%s%n%s%n", player, enemy);
            UserInputScanner.pressReturnToContinue(scanner);

            if (random.nextBoolean() && enemyTurns < MAX_TURNS) {
                System.out.println("It's your enemy's turn.");
                playerTurns = 0;
                enemyTurns++;
                enemy.attack(player);

            } else if (playerTurns < MAX_TURNS) {
                System.out.println("It's your turn " + player.getName() + ".");
                player.attack(enemy);
                enemyTurns = 0;
                playerTurns++;

                if (random.nextBoolean() && enemy.isAlive()) {
                    System.out.println("Your last attack stunned your enemy. That's your chance for another hit!");
                    if (random.nextBoolean()) {
                        player.attack(enemy);
                        System.out.println("Well done, that was another hit! 💪");
                    } else {
                        System.out.println("Dammit, you missed! 🙁");
                    }
                }
            }

            UserInputScanner.pressReturnToContinue(scanner);
        } while (enemy.isAlive() && player.isAlive());
        if (player.isAlive()) {
            System.out.println("You have defeated " + enemy.getName());
            System.out.println(Color.GREEN + "Winner, winner, Chicken Dinner. 🥳" + Color.RESET);
        } else {
            System.out.println("You have been defeated by " + enemy.getName());
            System.err.println("This is the sad end of your journey. RIP...🪦");
        }
        isOver = !player.isAlive(); //game ends if player is dead
        UserInputScanner.pressReturnToContinue(scanner);
        hasAlreadyCollected = false; //player is allowed to collect a new weapon
    }

    /**
     * Gets a sword from the pool and asks the player if he wants to equip it.
     * If the player has one equipped, yet it will be contrasted to the found one.
     * In case the player doesn't agree, the find will be discarded.
     */
    void collectItem() {
        System.out.println("You found a treasure chest. There is a weapon in it.");
        Sword found = pool.getASword();
        System.out.println("Found: " + found.toString());
        System.out.println("Already equipped: " + ((player.getWeapon() instanceof Sword) ? player.getWeapon().toString() : "nothing"));

        System.out.println("Do you want to equip the found weapon? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y"))
            player.equip(found);
        else if (hasNotFoughtYet){
            System.out.println("You cannot refuse to take your first weapon.");
            player.equip(found);
        }
        else {
            System.out.println("Weapon has not been equipped.");
        }
        //later on, a chest could contain other stuff like potions pulled randomly from the pool.
        UserInputScanner.pressReturnToContinue(scanner);
        hasAlreadyCollected = true;
    }
}
