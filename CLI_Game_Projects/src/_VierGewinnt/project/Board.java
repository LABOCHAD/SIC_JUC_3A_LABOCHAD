package _VierGewinnt.project;

/**
 * This class provides the play board and some mechanics.
 * It will be filled with placeholders on creation.
 * It can display itself, check if a column is full or if there is any space left at all.
 * Lets a player place a counter in a selected row at its deepest available space each.
 */
public class Board {
    private final char[][] grid = new char[6][7];
    protected static final char EMPTY = '_';

    /**
     * Uses Board constructor to flood the board with initial placeholders.
     */
    public Board() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = EMPTY;
            }
        }
    }

    /**
     * Shows the grid, but wraps it with delimiters between columns.
     * Additionally, the columns' numbers (as naturals) are shown above.
     */
    public void displayBoard() {
        // columns output
        final String DELIMITER = " | "; //Separator for columns, avoid repetitions
        for (int col = 1; col <= grid[0].length; col++) {
            System.out.print(DELIMITER + col);
        }
        System.out.print(DELIMITER);
        System.out.println();

        // board output
        for (int row = 0; row < grid.length; row++) {
            System.out.print(DELIMITER);
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col] + DELIMITER);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This method checks if any space is left to place a counter on the board
     *
     * @return - if at least one place is left on the whole board
     */
    public boolean isAnySpaceLeft() {

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * It lets player place a counter in a column.
     * It checks first if column is not already full.
     * Iterates from bottom to top, till it finds an empty slot.
     * @param col columns the counter should be set in.
     * @param player how puts in a counter.
     * @Autor Arthur Wloch, Dominik Labocha
     * @return <code>row</code> number, when successful, but <code>-1</code> when not.
     */
    public int fillLastFreeRowInCol(int col, Player player) {
        if (isPileFull(col)) {
            if (!player.isCOM())
                System.out.println("This columns is already full. Take another one!");
            return -1;
        }

        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][col] == EMPTY) {
                grid[row][col] = player.getCOUNTER_STYLE();
                return row;
            }
        }
        return -1; //@Arthur, you were right, but that wasn't predictable at the time of discussion.
    }

    /**
     * This method checks if any space is left to place a counter in the column
     *
     * @param col - aimed column for placing counter
     * @return - if at least one place is left in column
     */
    private boolean isPileFull(int col) {
        return this.grid[0][col] != EMPTY;
    }

    public char[][] getGrid() {
        return this.grid;
    }

}
