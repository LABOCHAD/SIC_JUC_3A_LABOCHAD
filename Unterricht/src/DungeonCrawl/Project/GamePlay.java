package DungeonCrawl.Project;

import DungeonCrawl.Project.Figures.Enemies.*;
import DungeonCrawl.Project.Figures.Player;
import DungeonCrawl.Project.Mysteries.*;
import myTools.Color;
import myTools.UserInputScanner;

import java.util.Random;
import java.util.Scanner;

/**
 * Here is where all components are arranged to a working game.
 * Player can decide between default or randomized story.
 * Fighting is implemented in here, as well as evaluating
 * the outcome of fights and decisions. Ends if player dies.
 * For more information see details of the according method.
 */
public class GamePlay {
    public static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static String decision;
    static int chambers;
    static boolean isSuccess;

    //Mach lieber etwas längere Zeilen, damit es übersichtlich bleibt. - ich werde es mir merken

    /**
     * Lets player choose a name.
     * Is adventurer, when left blank.
     * Player can choose if he wants
     * to play default story or randomized.
     * Calls according gameplay method.
     * Feeds back how many chambers are done
     * in random gameplay after leaving.
     * Closes scanner in the end.
     *
     * @param args not considered.
     */
    public static void main(String[] args) {
        System.out.printf("%nWelcome adventurer. How shall I call you?: ");

        String name = scanner.nextLine();
        name = (name.isEmpty() ? "adventurer" : name);

        Player player = new Player(name);

        int chooseStory;
        do {
            System.out.printf("%nAlright %s.%n" +
                              "Do you want to play a default [1] or the randomized [2] story? [1/2]: ", player.getName());
            chooseStory = UserInputScanner.getIntOnlyPos(scanner);
            //Alternativ wäre hier ein switch-Blöck auch gut möglich - erledigt
            switch (chooseStory) {
                case 1 -> defaultStory(player);
                case 2 -> {
                    randomizedStory(player);
                    System.out.printf("%nThis time you made it through %d chambers.%n", chambers);
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (chooseStory > 2);

        System.out.printf("%n%nThanks for playing... Bye 😊");
        scanner.close(); //Super!
    }

    /**
     * Tiny auxiliary for pausing output.
     * Story goes on after pressing return.
     *
     * @param scanner for input.
     */
    public static void proceed(Scanner scanner) {
        System.out.println();
        System.out.println("Press return to continue...");
        scanner.nextLine();
        scanner.reset();
    }

    /**
     * Auxiliary method for balancing chances by agility.
     * Agility values from figures are taken as a bound
     * for a randomizer each and then compared.
     * The bigger the bound is, the bigger is the chance
     * that the created random number will be bigger.
     * @param player whose chances is gambled.
     * @param enemy whose chances is gambled.
     * @return if player won comparison of gambled values.
     */
    public static boolean isPlayerFasterByAgility(Player player, Enemy enemy){
        int playersChance = random.nextInt(player.getAgility());
        int enemyChance = random.nextInt(enemy.getAgility());

        //For Debugging/Watching
        //System.out.printf("Player's chance from agility was %d out of %d.", playersChance,player.getAgility());
        //System.out.printf("%nEnemy's chance from agility was %d out of %d.%n%n", enemyChance, enemy.getAgility());

        return playersChance > enemyChance;
    }

    /**
     * Provides fighting functionality.
     * Displays figures' health's every turn.
     * Gambles whose turn it is. In case of
     * player, invokes another method for it.
     * If enemy's turn, gambles which attack
     * is being used and calls according method.
     * Loops until one of both figures dies.
     * Displays message according who has
     * been defeated and returns boolean.
     *
     * @param player who fights the enemy.
     * @param enemy  who fights the player.
     * @return states if enemy is defeated.
     */
    public static boolean fight(Player player, Enemy enemy) {
        System.out.printf("%s appears.%n", enemy.getName());
        do {
            enemy.showHealthReport();
            player.showHealthReport();
            System.out.println();

            if (isPlayerFasterByAgility(player, enemy)) {
                System.out.println("It's your turn, " + player.getName() + ".");
                DoPlayersTurn(player, enemy);
            } else {
                System.out.println("The enemy was faster than you.");

                boolean strongAttack = random.nextBoolean();
                //Nutze bei sowas auch den ternären Operator --> Das klappt nicht (Not a statement)
                //random.nextBoolean() ? enemy.attack(player) : enemy.specialSkill(player);
                if (strongAttack) enemy.specialSkill(player);
                else enemy.attack(player);
            }
            proceed(scanner);
        } while (!(player.isDead() || enemy.isDead()));

        if (player.isDead())
            System.out.printf("%n%sYou have been defeated by %s%s, %s." +
                              "%nYour journey ends here...%s⚰️☠️💀%n",
                    Color.RED, enemy.getName(), Color.RED, player.getName(), Color.RESET);
        else
            System.out.printf("%n%sYou have defeated the %s%s, %s." +
                              "%nYour journey goes on!%s 🥳👍💪%n",
                    Color.GREEN, enemy.getName(), Color.GREEN, player.getName(), Color.RESET);

        return enemy.isDead();
    }

    /**
     * Extension for fighting, for better
     * understanding and readability.
     * Provides a menu for the player, he
     * can choose of which action to apply.
     * Loops until choice is valid.
     * According action is done in switch case.
     * Player can attack normally or specially,
     * try to heal or escape and run in circles.
     *
     * @param player who fights the enemy.
     * @param enemy  who fights the player.
     */
    public static void DoPlayersTurn(Player player, Enemy enemy) {
        int choice;
        do {
            System.out.printf("What you gonna do?: " + //(When I come for you 😂)
                              "%n(1) Attack ⚔️" +
                              "%n(2) Special attack 💪" +
                              "%n(3) Heal 🤕💊" +
                              "%n(4) Escape the fight. 🏃‍♂️‍➡️" +
                              "%n(5) Run in circles and scream, " +
                              "'cause you know you're screwed. 😱" +
                              "%nYour choice: ");
            choice = UserInputScanner.getIntOnlyPos(scanner);
            System.out.println();
        } while (choice > 5);

        switch (choice) {
            case 1 -> player.attack(enemy);
            case 2 -> player.specialSkill(enemy);
            case 3 -> player.heal(enemy);
            case 4 -> System.out.println("You can't escape the fight.");
            case 5 -> //noinspection SpellCheckingInspection
                    System.out.println("AAAAAHHHHHHHHHHHH!!! - That wasn't helpful at all. 🤦");
            default -> System.out.println("Whatever you've done, didn't help, either."); //shouldn't occur
        }
    }


    /**
     * Lets user choose, if he wants to play
     * a fight or a solve a riddle.
     * Both are chosen randomly in other
     * methods, whose returns shouldn't be null.
     * Loops till choice is valid or player
     * decides to leave. Increments count of
     * chambers after every trail competed.
     *
     * @param player for usage in gameplay.
     */
    public static void randomizedStory(Player player) {
        int choice;
        chambers = 0;
        System.out.println("Welcome to your journey " + player.getName());

        do {
            System.out.printf("%nChoose your fade:" +
                              "%n(1) Way of strength" +
                              "%n(2) Way of wisdom" +
                              "%n(3) I want to leave the dungeon." +
                              "%n%nYour choice: ");
            choice = UserInputScanner.getIntOnlyPos(scanner);
            System.out.println();
            String way = "";
            switch (choice) {
                case 1 -> {
                    Enemy enemy = chooseEnemy();
                    if (enemy != null) {
                        boolean won = fight(player, enemy);
                        if (!won) return;
                        way = "strength";
                    }
                }
                case 2 -> {
                    Mystery mystery = chooseMystery();
                    if (mystery != null) {
                        mystery.solve(scanner);
                        way = "wisdom";
                    }
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Seems like you're still indecisive...");
            }
            if (!way.isEmpty()) {
                System.out.printf("%sCongratulation! You mastered the way of %s. Can you go deeper?%s%n", Color.GREEN, way, Color.RESET);
                chambers++;
            }
        } while (true);
    }

    /**
     * Chooses an enemy randomly.
     *
     * @return chosen enemy (not null).
     */
    public static Enemy chooseEnemy() {
        int choice;
        choice = random.nextInt(5);
        //Dead code ist immer etwas problematisch - ist entfernt
        //Later on make difficulty decide enemies parameters attack, health (+ agility)

        switch (choice) {
            case 0 -> {
                return new FireDragon();
            }
            case 1 -> {
                return new GhostWarrior();
            }
            case 2 -> {
                return new ShadowGolem();
            }
            case 3 -> {
                return new Titan();
            }
            case 4 -> {
                return new VenomCreature();
            }
            default -> {
                System.out.println("No enemy could be chosen.");
                return null;
            }
        }
    }

    /**
     * Chooses a mystery randomly.
     *
     * @return chosen mystery (not null).
     */
    public static Mystery chooseMystery() {
        int choice;
        choice = random.nextInt(4);
        //For texting particular case
        //choice = UserInputScanner.getIntOnlyPos(scanner);

        switch (choice) { //only for examples for the beginning
            case 0 -> {
                return new MathPuzzle();
            }
            case 1 -> {
                return new NumberPuzzle();
            }
            case 2 -> {
                return new WordAnagramPuzzle();
            }
            case 3 -> {
                return new WordPuzzle();
            }
            default -> {
                System.out.println("No mystery to solve could be chosen.");
                return null;
            }
        }
    }

    /**
     * Wraps the main story's four chapters.
     * Returns to main if a fight is lost.
     *
     * @param player who plays the story.
     */
    public static void defaultStory(Player player) {
        //Das kannst du auch in eine Abfrage komprimieren
        //  meinst du so?
        if (!(chapter1(player) &&
              chapter2(player) &&
              chapter3(player)))
            return;
        chapter4(player);
    }

    /**
     * Player enters the dungeon. At first,
     * he can choose which door to go through.
     * Depending on decision, a math puzzle
     * or a fight against a shadow golem
     * will be triggered and result returned.
     * Outputs storytelling depending on
     * choices made by the player before.
     *
     * @param player who plays the story.
     * @return if challenge was succeeded.
     */
    public static boolean chapter1(Player player) {
        System.out.printf("%nChapter 01: Entering the dungeon%n");
        System.out.printf("%n" + """    
                You are standing in the forecourt
                and there are two different doors
                one made of iron, the other of wood.
                Which one will you take to enter?
                """);

        boolean iron;
        boolean wood;
        do {
            System.out.printf("%nEnter [wood] or [iron]: ");
            decision = scanner.nextLine();
            iron = decision.equalsIgnoreCase("iron");
            wood = decision.equalsIgnoreCase("wood");
        } while (!(iron || wood));

        if (iron) {
            System.out.printf("%n" + """    
                    The iron door opens with a loud squeak.
                    You come into a room full of floating dust.
                    It feels like a darkness tries to consume you.
                    I dark creature arises from the nowhere.
                    Your whole body starts trembling and the
                    entrance you came through is buried by rubble.
                    There is no return. You must compete the fight.
                    """);
            proceed(scanner);
            isSuccess = fight(player, new ShadowGolem());
            if (isSuccess)
                System.out.printf("%nWell done, %s." +
                                  "%nYou discover a passage the golem had covered.%n", player.getName());

        } else {
            System.out.printf("%n" + """    
                    The wooden door opens with a loud creak.
                    In the middle of the chamber is a big statue.
                    Suddenly you hear a voice whispering out of
                    the nowhere that says:
                    "In order to proceed your journey
                    you need to solve a riddle."
                    """);
            MathPuzzle mathPuzzle = new MathPuzzle("12 + 7", "19");
            do {
                mathPuzzle.outputQuestion();
                isSuccess = mathPuzzle.isSolved(scanner.nextLine());
                if (!isSuccess)
                    System.out.println(Color.RED + "Your answer was wrong. The statue doesn't move." + Color.RESET);
            } while (!isSuccess);
            System.out.println(Color.GREEN + "Your answer was correct. The statue moves and reveals a secret path." + Color.RESET);
        }
        return isSuccess;
    }

    /**
     * Makes player fight against a fire dragon.
     * Contains further storytelling.
     *
     * @param player who plays the story.
     * @return if challenge was succeeded.
     */
    public static boolean chapter2(Player player) {
        System.out.printf("%nChapter 02: The mysterious chamber%n");
        System.out.printf("%n" + """    
                You're roaming through the secret passage.
                Finally you end up in a chamber whose walls
                have mysterious runes carved into them.
                Suddenly you hear a terrible rumbling and
                growling. It smells like fire and sulfur.
                Glowing red eyes are shining from the dark.
                The temperature rises rapidly and then you
                realize there is no other chance than a fight.
                """);
        proceed(scanner);
        isSuccess = fight(player, new FireDragon());
        if (isSuccess) {
            System.out.printf("%nWell done, %s. " +
                              "%nBut now you should hurry up to leave, " +
                              "before you suffocate in smoke and ash.%n", player.getName());
        }
        return isSuccess;
    }

    /**
     * Makes player fight against a ghost warrior.
     * Contains further storytelling.
     *
     * @param player who plays the story.
     * @return if challenge was succeeded.
     */
    public static boolean chapter3(Player player) {
        System.out.printf("%nChapter 03: The Ghost Warrior%n");
        System.out.printf("%n" + """    
                You barely survived fighting the dragon.
                Slowly but surely you realize how dangerous
                this journey is, but you trust into your courage.
                
                (If I was you, I'd already shat my pants 💩👖, dude!)
                
                Nevertheless you feel like something is trying to
                drain you from the inside. The upcoming weakness makes
                you feel uncomfortable, until you finally can spot
                the reason where this feeling comes from.
                'Though it's barely materialized you see
                the silhouette of a ghost warrior holding
                a dangerous weapon and creeping for you.
                """);

        proceed(scanner);
        isSuccess = fight(player, new GhostWarrior());
        if (isSuccess) {
            System.out.printf("%nWell done, %s. " +
                              "%nThat ghost won't drag you to hell today.%n", player.getName());
        }
        return isSuccess;
    }

    /**
     * Lets player decide if he wants to
     * take the artefact or leave it behind.
     * Depending on the choice player will
     * be imprisoned or released into freedom.
     * Has no return, because it is the
     * last chapter anyway. End occurs in it.
     *
     * @param player who plays the story.
     */
    public static void chapter4(Player player) {
        System.out.printf("%nChapter 04: The mystery of the artefact%n");
        System.out.printf("%n" + """    
                Alright...
                Seems like you're almost at the end of the dungeon.
                You finally make it through to a treasure chamber.
                In the middle lays a shiny artifact on a pedestal.
                Again you can hear a whispering voice in the wind:
                
                "Only who knows the price for strength and force
                is allowed to possess the artifact. Choose wisely!"
                
                The room is calm and silent, but you can feel a
                certain tension that is floating through the air.
                It is time, to finally decide your fate, %s.
                """, player.getName());

        boolean isPower;
        boolean isWisdom;
        do {
            System.out.printf("%nI will follow the way of POWER." +
                              "%nI will follow the way of WISDOM.");
            System.out.printf("%n%nDecision: ");
            decision = scanner.nextLine();

            isPower = decision.equalsIgnoreCase("power");
            isWisdom = decision.equalsIgnoreCase("wisdom");

            if (!(isPower || isWisdom)) {
                System.out.println("You cannot escape to choose you fate!");
            }
        } while (!(isPower || isWisdom));

        if (isPower) {
            System.out.printf("%n" + """
                    You take the artefact and instantly an enormous
                    strength floods you whole body, but there is
                    something else you can feel;
                    the loss of your freedom...
                    
                    Now you are the guardian of the dungeon,
                    imprisoned by the force you longed for.
                    
                    You will stay in here forever...
                    """);
        } else {
            System.out.printf("%n" + """
                    You decide not to take the artifact.
                    Willingly you renounced on power, but
                    you gained the reward for your wisdom;
                    your freedom to leave the dungeon.
                    
                    Now you can go in living your life.
                    You will ever find peace and a clean
                    conscience in knowing you did right.
                    However, you know there will still be
                    incautious humans the dungeon awaits.
                    """);
        }
        System.out.printf("%nFarewell, %s. It was an honor to accompany thee.%n", player.getName());
    }
}