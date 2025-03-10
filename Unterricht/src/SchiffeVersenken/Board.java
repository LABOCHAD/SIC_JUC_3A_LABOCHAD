// TODO Eine Funktion implementieren, die überprüft, ob Schiffe sich gegenseitig direkt berühren (nach offiziellen Spielregeln).
// TODO Die Möglichkeit einfügen, Schiffe diagonal zu platzieren, falls dies im Spiel gewünscht ist.
// TODO Das Spielfeld erweitern, sodass auch rechteckige Spielfelder möglich sind (z. B. 10x12).
// TODO Standard-Schiffspools definieren und implementieren (z. B. 4 Schiffe je 1 Länge, 3 je 2 Länge usw.).
// TODO Koordinaten (z. B. A1, B2) in der Ausgabe des Spielfelds anzeigen, ohne das interne Array zu verändern.


package SchiffeVersenken;

import myTools.Color;
import myTools.UserInputScanner;

import java.util.ArrayList;
import java.util.Scanner;


//TODO make all failure output messages conditional if it's user's turn (bool isUser), as soon as playable against com.

/**
 * Class defining Game Board.
 * Must at least have side length 3.
 * Floods the board's fields with ~
 * as water initially. Places Ships,
 * shoots and marks misses or hits
 * and adds ships to fields visually
 * and to an ArrayList of type ship.
 */
public class Board {
    char[][] grid; //only predefine / introduce the array but don't build it
    private final int size; //usually board has 10x12 fields (and a discard pile for sunk ships)
    //TODO allow board not only to be squared but e.g. 10x12 like in original game. Beware methods using side length.

    ArrayList<Ship> shipsBeenSet = new ArrayList<>();
    ArrayList<Ship> shipsInPool = new ArrayList<>();
    //TODO predefine pool of ships by default rules (4x2, 3x3, 2x4, 1x5) or (4x1, 3x2, 2x3, 1x4)


    /**
     * Creates a squared board after being given a side length.
     * If side length is below 3 it will be set 3 with a message.
     * Calls board being flooded in the beginning.
     *
     * @param sideLengths defines how long and wide the board will be.
     */
    Board(int sideLengths) {
        if (sideLengths < 3) {
            System.out.println("Side lengths must be at least 3! Set 3.");
            this.size = 3;
        } else {
            this.size = sideLengths;
        }

        this.grid = new char[size][size];
        floodTheField();
    }

    /**
     * Floods board by setting a water-like charakter as '~' all along the fields.
     * Initial state of a game, no ships have been set, yet.
     */
    private void floodTheField() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = '~'; //~ = water wave
            }
        }
    }

    /**
     * Shows up current state of the game.
     * Is being called after every change.
     * Like the flooding method it iterates
     * through the array by a nested loop.
     */
    public void showFields() {
        UserInputScanner.pressReturnToContinue(new Scanner(System.in));
        //Finally, made it -  it would be great to add coordinates to grid output without affecting the field array.
        System.out.println();

        System.out.print("   ");
        for (int col = 0; col < grid[0].length; col++){
            /*
             "[0]" isn't needed here, because the grid is squared,
             but for exercising addressing 2d arrays properly.
             "grid.length" iterates throw all lines at col 0,
             but "grid[0].length" goes through all columns in line 0
             for headlining their indices.
            */
            System.out.print(Color.BLUE +""+ col + (col < 10 ? "  " : " ") + Color.RESET); //one space less, if index > 9
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            //First print row index each
            System.out.print(Color.BLUE +""+ row + (row < 10 ? "  " : " ") + Color.RESET); //one space less, if index > 9

            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Adds a ship with given length to the board's pool.
     *
     * @param length how long the ship is supposed to be.
     */
    public void addShipToPool(int length) {
        int countAllShips = shipsInPool.size() + shipsBeenSet.size();
        if (countAllShips == 10) {
            System.out.println("There cannot be more than 10 ships belonging to a board.");
        } else {
            shipsInPool.add(new Ship(length));
            System.out.println("A ship has been added to the board's pool.");
        }
    }


    /**
     * Iterates through ship pool and
     * returns the first ship found
     * with wanted length to caller.
     *
     * @param length wanted ship length
     * @return ship with wanted length
     * as soon as it has been found.
     * null shouldn't occur, assuming
     * existence has been assured before.
     */
    public Ship getShipFromPool(int length) {
        for (Ship s : shipsInPool) {
            if (s.getLength() == length) {
                return s;
            }
        }
        return null;
    }

    /**
     * Searches through pool of ships
     * if one with wanted length is left.
     * Just written in case I want to enable
     * user to choose from pool manually.
     *
     * @param length wanted ship length
     * @return true or false for evaluation.
     */
    public boolean isShipThisLengthInPool(int length) {
        boolean foundOne = false; //TODO geht das auch mit ships.contains.ship.length == 3) ?
        for (Ship s : shipsInPool) {
            if (s.getLength() == length) {
                foundOne = true;
                break;
            }
        }
        return foundOne;
    }


    /**
     * Tries to add a ship on the board.
     * Prohibits setting more than 10 ships.
     * Evaluates if placement is possible and
     * refuses if not returning boolean as false.
     * Possibility to place depends on board size
     * related to ship length and exceedances of an
     * edge with smaller ships by placing within.
     * Also overlapping / being too close to other ships.
     * Used boolean isHorizontal implies that start
     * coordinate is on the left, if true (runs to the right)
     * or the upper side of ship if false (runs downwards)
     * For now merged with adding ship to ships ArrayList.
     *
     * @param ship         passes a ship only given a length so far.
     * @param row          vertical coordinate for placement.
     * @param col          horizontal coordinate for placement.
     * @param isHorizontal sets orientation as stated above.
     * @return boolean if ship could be placed successfully.
     */
    public boolean placeAndAddAShip(Ship ship, int row, int col, boolean isHorizontal) {
        if (shipsBeenSet.size() == 10) { //can be revoked if game should ever not be single char based anymore.
            System.out.println("Placing more that 10 ships within a game is not allowed");
            return false;
        }
        //ship that's being passed by caller must at least have a defined length (simplified constructor)
        if (isHorizontal) { //check if given row number plus ship length exceeds board edge on the right
            if (row + ship.getLength() > this.size) {
                System.out.println("\nShip doesn't fit on board horizontally.");
                return false; //Ship exceeds board horizontally
            }
        } else { //check if given col number plus ship length exceeds board on the topper edge
            if (col + ship.getLength() > this.size) {
                System.out.println("\nShip doesn't fit on board vertically.");
                return false; //Ship exceeds board vertically
            }
        }

        //When edges aren't exceeded, check if field is free (water/~)
        //remember 2DArray --> Arr[rows][cols]
        if (isHorizontal) { //check fields horizontally by checking cols in specific row
            for (int x = col; x < ship.getLength() + col; x++) { //go through fields sidewards the row
                if (grid[row][x] != '~') {
                    System.out.println("\nFound a field in row, that's not free. Ship can't be placed.");
                    return false; //should this be boolean maybe?
                }
            }
        } else { //check fields vertically
            for (int y = row; y < ship.getLength() + row; y++) { //go through fields sidewards the row
                if (grid[y][col] != '~') {
                    System.out.println("\nFound a field in column, that's not free. Ship can't be placed.");
                    return false; //should this be boolean maybe?
                }
            }
        }

        //TODO Additionally avoid ship being directly next to another
        //if statement asking if field up, down, left or right from intended one is numeric (a ship) (is char a digit?)
        //if not, ship can be set, if is numeric, another ship is direct neighbour, ship cannot be set.

        //Merged addShip in here for now
        ship.setHorizontal(isHorizontal);
        shipsInPool.remove(ship);
        shipsBeenSet.add(ship); //can be done after getting size, because is 0, before first is added, as wanted.

        //If all tests passed, finally place ship on board.
        if (isHorizontal) {
            for (int x = col; x < ship.getLength() + col; x++) { //go through fields sidewards the row
                grid[row][x] = Integer.toString(shipsBeenSet.size() - 1).charAt(0);
            }
        } else {
            for (int y = row; y < ship.getLength() + row; y++) { //go through fields sidewards the row
                grid[y][col] = Integer.toString(shipsBeenSet.size() - 1).charAt(0);
            }
        }
        return true;

    }


    /**
     * Accepts aiming coordinates and tries to shoot.
     * Extracts content of aimed field as single char.
     * Evaluates if a shot can be fired and by checking
     * if field has already been shot before. When water
     * is being found instead shot will be a miss.
     * But if char is a digit, that means that there is
     * a ship that could be shot successfully. When true
     * field will be marked as hit and hitCount if ship
     * will be increased. Tells if ship has been sunk.
     *
     * @param row vertical coordinate for shooting.
     * @param col horizontal coordinate for shooting.
     * @return boolean if shot could be done.
     */
    public boolean shootAndMark(int row, int col) {
        if (row >= grid.length || col >= grid[0].length) {
            System.out.println("You aimed at an invalid coordinate!");
            return false;
        }


        final char c = this.grid[row][col]; //just for reading

        switch (c) {
            case 'm', 'h': {
                System.out.println("You already shot this field. Take another one.");
                return false;
            }

            case '~': {
                System.out.println("Sorry, but this was a miss.");
                this.grid[row][col] = 'm';
                return false;
            }
        }

        if (Character.isDigit(c)) { //cannot be done in Switch-Case
            System.out.println("Nice shot! You made a hit.");
            this.grid[row][col] = 'h';

            int digit = Character.digit(c, 10);
            shipsBeenSet.get(digit).setHitCount(); //works because Index in Arraylist is the same as Index assigned to ship as int.
            if (shipsBeenSet.get(digit).isSunk()) {
                System.out.println("Ship number " + c + " has been sunk.");
            }
            return true;
        }
        return false; //shouldn't even occur.
    }

    public int getSize() {
        return size;
    }
}
