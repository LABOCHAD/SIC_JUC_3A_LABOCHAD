package _VierGewinnt.project;

/**
 * Auxiliary class for finding out if a game has been won already.
 * Is being declared emptily and initialized by calling collecting method.
 * Contains an own reference to the game's board, as well as a copy of
 * the last row und column addressed, the counterStyle in it and a shifting constant.
 * Finally, returns a boolean if the game has been won.
 */
public class Verifier {
    private int row;
    private int col;
    private Board board;
    private char currentCounterStyle; //counterStyle
    private final int SHIFT = 3;

    /**
     * Collecting method for (re-)initialising the verifier that finally evaluates the game's state each turn.
     * Takes the board by gameplay and the last addressed coordinates.
     * Firstly, extracts counter-style out of it, then calls a method by shifting for any winnable direction each.
     * Any method checks if it finds three duplicates (and itself) of the counter whose style has been saved.
     *
     * @param board to iterate over for potential wins.
     * @param row   where the last counter has been set.
     * @param col   where the last counter has been set.
     * @return final verification if the game has been won in any direction.
     */
    public boolean isAnyMatchFour(Board board, int row, int col) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.currentCounterStyle = board.getGrid()[row][col];

        return ( //test each win szenario if at least one occurs

                isDown() || // down, no shift param, 'cause there is only one direction (down 3)
                isLeftRight() || // left
                isLeftRight() || // right

                isDiagonal(-SHIFT) || // down left
                isDiagonal(SHIFT) // down right
        );
    }

    /**
     * Iterates from bottom to top of the last aimed column.
     * <br>Stops if <code>EMPTY</code> codon has been found.
     * @return if there is a match four.
     */
    private boolean isDown() {
        int found = 0;
        //iterating from bottom to top will be more likely to find a match faster
        // (otherwise forwards iteration like leftRight would be enough, but then an EMPTY mustn't break)
        for (int rowI = board.getGrid().length-1; rowI >= 0 ; rowI--) {
            if (board.getGrid()[rowI][col] == Board.EMPTY) break; //there cannot be anything above anymore

            else if (board.getGrid()[rowI][col] == currentCounterStyle) found++;
            else found = 0;
        }
        return (found == 4);
    }

    /**
     * Iterates through the last aimed row.
     * @return if there is a match of four.
     */
    private boolean isLeftRight() {
        int found = 0;

        for (int colI = 0; colI < board.getGrid()[row].length ; colI++) {
            if (board.getGrid()[row][colI] == currentCounterStyle) found++;
            else found = 0;
        }
        return (found == 4);
    }

    //FIXME won't return true if match four is generated from its middle
    /**
     * Iterates from middle each to the left or right, depending on sign of shift.
     * <br>No rowShift is needed because it only goes <code>down with shift = +3</code>.
     *
     * @param colShift makes iteration go <code>left if shift = -3</code> or <code>right if shift = 3</code>
     * @return if there is a match four to the left down or right down from the middle on.
     */
    private boolean isDiagonal(int colShift) {
        int found = 0;
        int rowIterator = this.row;
        int colIterator = this.col;

        try {
            int i = 0;
            while (i <= SHIFT) {
                i++;

                if (board.getGrid()[rowIterator][colIterator] == currentCounterStyle) found++;
                else return false;

                rowIterator++;

                if (colShift < 0) colIterator--; //if shift negative, Iteration must go left
                else colIterator++;
            }
            return (found == 4);

        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
