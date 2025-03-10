// TODO Die Möglichkeit hinzufügen, gegen den Computer zu spielen (z. B. indem die Schiffe automatisch für den Gegner gesetzt werden).
// TODO Eine Möglichkeit hinzufügen, das Spiel zu speichern und später fortzusetzen.

package SchiffeVersenken;

import myTools.UserInputScanner;

import java.util.Scanner;
//go on in here --> C:\Users\DLabo\IdeaProjects\sic-juc-3a\Unterricht\src\MusterlösungSchiffeVersenken\Schiffe versenken Bauplan 3a JuC.pdf

/**
 * Here is where the flow of the game is supposed to happen.
 * Uses a Scanner for user input and another method to validate.
 */
public class BattleShipGame {
    static Board enemyBoard; //seems to be supposed to play against computer
    static Scanner scanner;


    BattleShipGame(int boardSize, int lengthShip1, int lengthShip2) {
        //for now just for testing easy version
        enemyBoard = new Board(boardSize);
        enemyBoard.addShipToPool(lengthShip1);
        enemyBoard.addShipToPool(lengthShip2);
        enemyBoard.placeAndAddAShip(enemyBoard.getShipFromPool(lengthShip1), 0, 0, true);
        enemyBoard.placeAndAddAShip(enemyBoard.getShipFromPool(lengthShip2), 1, 1, true);
    }

    /**
     * Auxiliary method to get and validate user input.
     * Assures user doesn't feed game with invalid numbers.
     * Repeats until input is finally valid.
     *
     * @param scanner is passed for realizing user input.
     * @return returns natural number, as soon as got.
     */
    static int getIntFromUserByScanner(Scanner scanner) {
        int n = -1;
        do {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            }

            if (n < 0) {
                System.out.println("Wert ungültig!");
                System.out.println("Bitte eine natürliche Zahl eingeben!");
                scanner.reset(); //try to avoid stack overflow

            }
            scanner.nextLine(); //get rid of excessive line break from nextInt()
        } while (n < 0);
        return n;
    }

    /**
     * Iterates through whole pool of ships.
     * Asks user where and how to set a ship.
     * If inputs invalid or placement failed,
     * repeats for current ship, until success.
     * Holds user in here till all ships could be set.
     * Important step for starting game correctly.
     * Will be used later when pool is predefines.
     * Not in use as long user can decide length.
     *
     * @param board passes board in case method
     *              can be used later for 2 players.
     */
    static void setAllShipsInPoolByUser(Board board) {
        do {
            Ship s = board.shipsInPool.getFirst(); //or last
            boolean shipSetSuccessfully;
            int x;
            int y;
            String orientation;
            boolean isHorizontal = false;

            do {
                System.out.printf("%nShips in pool left for being placed on the board: %d", board.shipsInPool.size());
                System.out.printf("%nYou are holding a ship of length %d in your hand.", s.getLength());
                System.out.printf("%nWhich row do you want to set it? [0 - %d]: ", board.getSize());
                x = getIntFromUserByScanner(scanner);

                System.out.printf("%nWhich column do you want to set it?[0 - %d]: ", board.getSize());
                y = getIntFromUserByScanner(scanner);

                System.out.printf("%nDo you want to put it horizontally on the board (h) or vertically (v)?: ");

                do {
                    orientation = scanner.next();
                    if (orientation.equalsIgnoreCase("h")) {
                        isHorizontal = true;
                    } else if (orientation.equalsIgnoreCase("v")) {
                        isHorizontal = false;
                    } else {
                        System.out.println("Sorry, but I couldn't understand you. Horizontally (h) or vertically (v)?: ");
                    }
                } while (!(orientation.equalsIgnoreCase("h") || orientation.equalsIgnoreCase("v")));


                shipSetSuccessfully = board.placeAndAddAShip(s, x, y, isHorizontal);
                if (!shipSetSuccessfully) {
                    System.out.println("Ship couldn't be placed successfully. Try again.");
                }
            } while (!shipSetSuccessfully);



            board.showFields();
        } while (!board.shipsInPool.isEmpty());
    }

    /**
     * Provides a basic flow to enable
     * user to play against himself.
     * First checks if ships have been set at all.
     * Aborts start of the game if not.
     * Repeats showing fields of boards and
     * asking user for shooting coordinates
     * before passing them to boards shooting method.
     * Checks if there are ship in game those have not
     * been sunk after every shot fired successfully.
     */
    public void startGame() {
        if (enemyBoard.shipsBeenSet.isEmpty()){
            System.out.println("Something went wrong. No ships could been set. Game cannot be started.");
            return;
        }
        boolean gameOver = false;
        int x;
        int y;
        while (!gameOver) {
            do {
                enemyBoard.showFields();
                System.out.print("Which row do you want to shoot at?: ");
                x = getIntFromUserByScanner(scanner);
                System.out.print("Which column do you want to shoot at?: ");
                y = getIntFromUserByScanner(scanner);
            }
            while (!enemyBoard.shootAndMark(x, y));
            gameOver = endGame();
        }

    }

    /**
     * Iterates through Array of ships being set on board.
     * If at least one is found not sunk yet, game goes on.
     * If no ship being still not sunk, tells user game is over.
     * @return if all ships have been sunk on board.
     */
    public boolean endGame() {
        for (Ship s : enemyBoard.shipsBeenSet) {
            if (!s.isSunk()) { //if one found not sunk game goes on
                return false;
            }
        }
        System.out.printf("%nAll ships have been sunk. The game is over.");
        return true;
    }

    /**
     * Main methods starts the game
     * after constructing an instance.
     * Asks user for board size first.
     * @param args not considered.
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int boardSize;


        System.out.print("How big should the play board be in side length?: ");
        boardSize = UserInputScanner.getIntOnlyPosRanged(scanner,3,100);
        // Limit to 99 per side, to assure the grid alignment won't be broken.
        // Who the hell wants to play with 100x100 fields anyway? That's ridiculous!

        //make sure that board is big enough that all ships in pool can be placed in any case or use default rules (later)
        BattleShipGame thisGame = new BattleShipGame(boardSize, 3, 2); //predefined for now, later from default pool
        thisGame.startGame();
        scanner.close();
    }

}
