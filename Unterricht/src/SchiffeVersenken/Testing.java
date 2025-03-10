package SchiffeVersenken;

/**
 * Class only for testing methods so far.
 * Not a playable game, yet.
 */
public class Testing {
    public static void main(String[] args) {

        System.out.println("Creating a board...");
        Board board = new Board(10);
        board.showFields();

        System.out.println("Creating first ship...");
        Ship ship0 = new Ship(5);
        board.placeAndAddAShip(ship0, 0, 0, true);
        board.showFields();

        System.out.println("Creating second ship...");
        Ship ship1 = new Ship(2);
        board.placeAndAddAShip(ship1, 1, 1, false);
        board.showFields();

        System.out.println("Make a shot at 1/1...");
        board.shootAndMark(1, 1);
        board.showFields();


        board.addShipToPool(3);
        board.addShipToPool(3);

        System.out.println();
        System.out.println(board.getShipFromPool(3).getLength());

        board.placeAndAddAShip(board.getShipFromPool(3),2,3,true);


        board.showFields();


    }
}


//Things I'd like to add as soon it's a good time for it:
/*

Standard ship pool -> 4x1, 3x2, 2x3, 1x4 --> 10 an der Zahl und somit von 0 bis 9 darstellbar --> int <-> char
Implement pool and compare for usages. //Predefined pool of ships or own ones? (4x1, 3x2, 2x3, 1x4) (Count x Length)

For later (because I wonder what else the hit count is good for):
Add ships with coordinates of the fields they occupy (possibly also a 2D array, mirrors field coordinates)
Add placement to generate and pass these coordinates (based on the first cell and orientation)
(done) For this, later on, outsource input method from Shoot and Mark (int[] enterAndValidateCoordinates() and return valid coordinates
Later split this up into input and general validation of coordinates for accessibility.
Add Shoot and Mark to identify the ship hit based on the coordinates and increase its hit counter.
To do this, search the array of ships, and for each ship its coordinate array is searched. (nested loop, enhanced for + for)

Any other ideas:
Who owns the ship, me or the opponent (boolean)?
Opponent's ships on another (hidden) board, pass shot as coordinates.
This would also make it possible to play against the computer.

Add error handling if non-integer is entered for integer. (if scanner.hasNextInt())

How about letting user decide how many ships he wants to play with?
Also, a predefined or custom pool of ships could be chosen.
(Makes sense as soon it can be played against an enemy because must be handled equally for both.)

Furthermore, I'd like to add titels (123../ABC...) to rows and columns in board grid output.
So for users it's easier to type in coordinates for ship placement or shooting.

Set different chars for ship on the board depending on if its horizontal (-) or vertical (|).
 */
