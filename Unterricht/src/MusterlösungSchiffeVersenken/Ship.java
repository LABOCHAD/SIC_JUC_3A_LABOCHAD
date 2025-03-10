package MusterlösungSchiffeVersenken;

public class Ship {
    private final int length;
    private int hitCount;
    private boolean isSunk;

    public Ship(int length) {
        this.length = length;
        this.hitCount = 0;
        this.isSunk = false;
    }

    public int getLength() {
        return length;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void hit() {
        if (!isSunk) {
            hitCount++;
            if (hitCount == length) {
                isSunk = true;
                System.out.println("Schiff versenkt!");
            }
        }
    }
}
