package MusterlösungSchiffeVersenken;

import java.util.Scanner;

public class BattleshipGame {
    private final Board enemyBoard;
    private final Scanner scanner;

    public BattleshipGame() {
        scanner = new Scanner(System.in);

        // Abfrage der Spielfeldgröße vom Spieler
        System.out.print("Gib die Größe des Spielfeldes ein (z.B. 10 für 10x10): ");
        int boardSize = scanner.nextInt();

        // Erstelle Boards mit der vom Spieler gewählten Größe
        enemyBoard = new Board(boardSize);   // Spielfeld des Gegners

        // Gegner-Schiffe (nur für die Simulation)
        Ship enemyShip1 = new Ship(2);
        Ship enemyShip2 = new Ship(3);
        enemyBoard.addShip(enemyShip1);
        enemyBoard.addShip(enemyShip2);
        enemyBoard.placeShip(enemyShip1, 1, 1, true);
        enemyBoard.placeShip(enemyShip2, 3, 3, false);
    }

    public void start() {
        boolean gameOver = false;
        while (!gameOver) {

            System.out.println("\nGegnerisches Spielfeld (mit Deinen Schüssen):");
            enemyBoard.printBoard(false);

            System.out.print("Gib eine Koordinate zum Schießen ein (z.B. 3 4): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (enemyBoard.shootAt(x, y)) {
                System.out.println("Treffer!");
            } else {
                System.out.println("Fehlschuss!");
            }

            gameOver = isGameOver();
        }
        System.out.println("Spiel beendet.");
    }

    private boolean isGameOver() {
        for (Ship ship : enemyBoard.getShips()) {
            if (ship != null && !ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.start();
    }
}
