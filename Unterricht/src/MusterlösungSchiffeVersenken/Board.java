package MusterlösungSchiffeVersenken;


public class Board {
    private final char[][] grid;
    private final Ship[] ships;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        this.ships = new Ship[2];

        // Spielfeld mit Wasser füllen
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '~';  // ~ repräsentiert Wasser
            }
        }
    }

    //Von der Koordinate aus: true: horizontal nach rechts, false: vertikal nach ob
    public void placeShip(Ship ship, int x, int y, boolean horizontal) {
        // Überprüfe, ob das Schiff vollständig innerhalb des Spielfelds bleibt
        if (horizontal) {
            if (x + ship.getLength() > size) {
                System.out.println("Das Schiff passt nicht horizontal auf das Spielfeld.");
                return;  // Das Schiff überschreitet das Spielfeld, daher abbrechen
            }
        } else {
            if (y + ship.getLength() > size) {
                System.out.println("Das Schiff passt nicht vertikal auf das Spielfeld.");
                return;  // Das Schiff überschreitet das Spielfeld, daher abbrechen
            }
        }

        // Überprüfe, ob das Schiff auf einem freien Feld platziert werden kann
        for (int i = 0; i < ship.getLength(); i++) {
            int xPos = horizontal ? x + i : x;
            int yPos = horizontal ? y : y + i;

            // Wenn das Feld bereits belegt ist (nicht Wasser), abbrechen
            if (grid[yPos][xPos] != '~') {
                System.out.println("Das Feld " + xPos + "," + yPos + " ist bereits belegt.");
                return;
            }
        }

        // Wenn alle Überprüfungen erfolgreich sind, platziere das Schiff
        for (int i = 0; i < ship.getLength(); i++) {
            int xPos = horizontal ? x + i : x;
            int yPos = horizontal ? y : y + i;
            grid[yPos][xPos] = 'S';  // Setze das Schiff auf das Spielfeld
        }

        System.out.println("Schiff wurde erfolgreich platziert.");
    }

    public boolean shootAt(int x, int y) {
        if (grid[y][x] != '~' && grid[y][x] != 'X') {
            for (Ship ship : ships) {
                if (ship != null && 'S' == grid[y][x]) {
                    ship.hit();
                    grid[y][x] = 'X';  // Markiere Treffer
                    return true; // Treffer
                }
            }
        }
        grid[y][x] = 'O';  // Markiere Fehlschuss
        return false;
    }

    public void addShip(Ship ship) {
        // Suche nach einem freien Platz für das Schiff
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = ship;
                break;
            }
        }
    }

    public void printBoard(boolean showShips) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                char cell = grid[y][x];
                if (!showShips && cell != '~' && cell != 'X' && cell != 'O') {
                    System.out.print("~");  // Wasser anzeigen statt Schiff
                } else {
                    System.out.print(cell);
                }
            }
            System.out.println();
        }
    }

    public Ship[] getShips() {
        return ships;
    }

    public int getSize() {
        return size;
    }
}
