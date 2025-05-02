package _VierGewinnt.project;

import _VierGewinnt.tools.UserInputScanner;

import java.util.Scanner;

/**
 * Just for starting the whole program.
 */
public class Main {

    /**
     * Creates a gameplay and starts its game, passing it a scanner that's being closed finally.
     * @param args not considered.
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        GamePlay gamePlay = new GamePlay(scanner);

        System.out.println("Start which custom(1) or default(2) parameters?");
        int start = UserInputScanner.getIntOnlyPosRanged(scanner,1,3);

        if (start==1) gamePlay.prepareCustomGame();
        else if (start==2) gamePlay.prepareDefaultGame();
        else return;

        gamePlay.game();

        scanner.close();
    }
}
