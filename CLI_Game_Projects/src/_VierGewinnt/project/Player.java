package _VierGewinnt.project;


public class Player {

    private final String NAME;
    private final char COUNTER_STYLE;


    //private int gamesWon = 0;
    private final boolean isCOM;

    /**
     * Creates a new player.
     *
     * @param name         The name of the player.
     * @param counterStyle The player's tile style ('X' or 'O').
     * @param isCOM        it specifies whether the player is a CPU opponent (true) or a human player (false).
     */
    public Player(String name, char counterStyle, boolean isCOM) {
        this.NAME = name;
        this.COUNTER_STYLE = counterStyle;
        this.isCOM = isCOM;
    }

    /**
     * It checks if the player is a computer opponent.
     *
     * @return true if the player is a computer opponent, otherwise false.
     */
    public boolean isCOM() {
        return isCOM;
    }

    public String getNAME() {
        return NAME;
    }

    public char getCOUNTER_STYLE() {
        return COUNTER_STYLE;
    }

}
