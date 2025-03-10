// TODO Getter und Setter für zusätzliche Attribute hinzufügen, falls spätere Features dies erfordern (z. B. Name oder Typ des Schiffs).

package SchiffeVersenken;

public class Ship {
    private int length;
    private int hitCount;
    private boolean isSunk;
    private boolean isHorizontal; //implies that start coordinate is left side, if true or upper side if false

    /**
     * Generic Constructor for a ship, that can be called anytime of a game.
     * For example, if a game has been saved and needs to be rebuilt to continue.
     * Initializes all attributes of a ship at once.
     *
     * @param length       How many fields is the ship long.
     * @param hitCount     How often has a ship been hit.
     * @param isSunk       Has the ship already been sunk.
     * @param isHorizontal states if ship is placed sidewards.
     */
    Ship(int length, int hitCount, boolean isSunk, boolean isHorizontal) {
        this.length = length;
        this.hitCount = hitCount;
        this.isSunk = isSunk;
        this.isHorizontal = isHorizontal;
    }

    /**
     * Simplified constructor, only sets length.
     * So far just an auxiliary for placement on boards.
     * If a game starts, ships are not hit or sunk, yet.
     *
     * @param length How many fields is the ship long.
     */
    Ship(int length) {
        this.length = length;
        this.hitCount = 0;
        this.isSunk = false;
    }


    /**
     * No argument for setter if ship is hit, because
     * hit count will always increase by one only.
     * When been hit as often as ship is long ship is sunk.
     * (Not necessary to store where a ship has been hit,
     * because it will be displayed on board anyway.
     * But might be important later on with saved games.)
     */
    public void setHitCount() {
        this.hitCount++;
        if (this.hitCount == this.length) {
            setSunk(true);
        }
    }

    public int getLength() {
        return length;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public boolean isSunk() {
        return isSunk;
    }

    /**
     * Auxiliary for orientation of the ship.
     * Implies that start coordinate is left
     * side, if true or upper side if false.
     * @param horizontal true or false.
     */
    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

}
