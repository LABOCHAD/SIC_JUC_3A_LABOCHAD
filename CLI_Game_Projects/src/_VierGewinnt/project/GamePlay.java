package _VierGewinnt.project;

import _VierGewinnt.tools.UserInputScanner;

import java.util.Random;
import java.util.Scanner;


public class GamePlay {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private final Verifier verifier = new Verifier();
    private final Scanner scanner;
    private int lastRow;
    private int lastCol;

    GamePlay(Scanner scanner) {
        this.scanner = scanner;
    }

    protected void prepareCustomGame(){
        player1 = createPlayer();

        boolean sameStyles;
        do {
            player2 = createPlayer();
            sameStyles = player1.getCOUNTER_STYLE() == player2.getCOUNTER_STYLE();
            if (sameStyles)
                System.out.println("Players are supposed to have different CounterStyles. Recreate Player2");
        } while (sameStyles);
    }

    protected void prepareDefaultGame(){
        player1 = new Player("Player 1",'●', false);
        player2 = new Player("Player 2",'○', false);
    }

    /**
     * It starts the connect four game.
     *
     * This method initializes the players, the game board and manages the game flow.
     * The game ends when a player has won or there is no room left on the board.
     *
     * @see Board#displayBoard()
     * @see Verifier#isAnyMatchFour
     */
    public void game() {
        setStartingPlayer();
        this.board = new Board();
        board.displayBoard();

        do {
            if (!placeCounter()) continue; //repeat if counter couldn't be set

            String nameAndStyle = currentPlayer.getNAME() + " (" + currentPlayer.getCOUNTER_STYLE() + ")";

            if (currentPlayer.isCOM()){
                System.out.println(nameAndStyle + " sets automatically at column " + (lastCol+1)); //could it be CPU can set invalid?
                UserInputScanner.pressReturnToContinue(scanner);
            }
            board.displayBoard();

            if (verifier.isAnyMatchFour(board, lastRow, lastCol)) {
                System.out.println(nameAndStyle + " has won! 🥳");
                break;
            }

            if (!board.isAnySpaceLeft()) {
                System.out.println("The board is full and no match has been made. It's a draw.");
                break;
            }

            switchPlayer();
        } while (true);
    }

    /**
     * It places a tile of the current player in the selected column.
     *
     * @return `true` if the tile has been placed successfully and no player has won;
     *  <br>`false` if the column is full or a player has won.
     */
    public boolean placeCounter() { //Übergabeparameter waren nicht notwendig :D
        int col;
        String nameAndStyle = currentPlayer.getNAME() + " (" + currentPlayer.getCOUNTER_STYLE() + ")";
        if (!currentPlayer.isCOM()) {
            System.out.println(nameAndStyle + ", it's your turn!");
            System.out.println("Where do you want to set your counter disk at? (1-7)");
            col = UserInputScanner.getIntOnlyPosRanged(scanner, 1, 8);
        } else {
            Random random = new Random();
            col = random.nextInt(1, 8);
        }
        lastCol = --col; //needs to be assigned for calling verifier later

        lastRow = board.fillLastFreeRowInCol(col, currentPlayer);
        if (lastRow == -1) return false;

        return true;
    }

    /**
     * Asks the user his name, which char he wants for his counter (X/O) and if he wants to play or let the CPU play
     * @return a new Player or a new CPU Player
     */
    public Player createPlayer() {

        System.out.println("Enter Player's Name:");
        String name = scanner.nextLine();
        if (name.isEmpty() || name.isBlank()) name = "Player";

        System.out.println("Choose your counter style by one character (e.g. 'X' or 'O'):");
        char counterStyle = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.println("Is this player supposed to be a computer (yes/no) ?:");
        boolean isCom = scanner.nextLine().equalsIgnoreCase("yes");

        return new Player(name, counterStyle, isCom);
    }

    /**
     * Swaps the player each turn.
     */
    public void switchPlayer() {
        if (currentPlayer == player1)
            currentPlayer = player2;
        else currentPlayer = player1;
    }

    /**
     * Decides randomly which player starts.
     */
    public void setStartingPlayer() {
        Random random = new Random();
        if (random.nextBoolean())
            currentPlayer = player1;
        else currentPlayer = player2;
    }

}
