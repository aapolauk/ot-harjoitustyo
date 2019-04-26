package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aapol
 */
public class AppLogic {

    private final int xTiles = 20;
    private final int yTiles = 15;

    private Tile[][] grid = new Tile[xTiles][yTiles];

    boolean explosion = false;
    boolean fieldClear = false;

    int tilesThatDoNotHaveBombs = xTiles * yTiles;
    
    long[][] neighbouringBombs = new long[xTiles][yTiles];
    
    int[][] bombTiles = new int[xTiles][yTiles];
    
    /**
     * Creates a grid of tiles. Each tile has coordinates and a boolean value which tells if the tile has a bomb.
     * This boolean value is randomly generated. If the boolean value is true, the numbers of tiles that does not have a bomb is decreased.
     * Counts neighbouring bombs for each tile.
     */
    public void create() {
        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                boolean putBomb = (Math.random() < 0.1);
                Tile tile = new Tile(x, y, putBomb, this);
                if (putBomb) {
                    int noBombTiles = getTilesThatDoNotHaveBombs();
                    setTilesThatDoNotHaveBombs(--noBombTiles);
                    bombTiles[x][y] = 1;
                }
                grid[x][y] = tile;
            }
        }
        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];
                if (tile.hasBomb) {
                    continue;
                }
                neighbouringBombs[x][y] = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();
            }
        }
    }

    /**
     *
     * @param tile A tile whose neighbours will be counted.
     * @return A list of neighbouring tiles.
     */
    public List<Tile> getNeighbors(Tile tile) {
        List<Tile> neighbors = new ArrayList<>();

        int[] coordinates = new int[]{
            -1, -1,   -1, 0,   -1, 1,   0, -1,   0, 1,   1, -1,   1, 0,   1, 1
        };

        for (int i = 0; i < coordinates.length; i++) {
            int xAxis = coordinates[i];
            int yAxis = coordinates[++i];

            int xNew = tile.getX() + xAxis;
            int yNew = tile.getY() + yAxis;

            if (isValidPoint(xNew, yNew)) {
                neighbors.add(grid[xNew][yNew]);
            }
        }
        return neighbors;
    }

    /**
     *
     * @param x
     * @param y
     * @return True if x and y are coordinates in the grid. False if x and y are coordinates that are outside of the grid.
     */
    public boolean isValidPoint(int x, int y) {
        return (x >= 0 && x < xTiles && y >= 0 && y < yTiles);
    }

    /**
     *
     * @return
     */
    public Tile[][] getGrid() {
        return grid;
    }

    /**
     *
     * @return
     */
    public int getTilesThatDoNotHaveBombs() {
        return tilesThatDoNotHaveBombs;
    }

    /**
     *
     * @param tilesThatDoNotHaveBombs
     */
    public void setTilesThatDoNotHaveBombs(int tilesThatDoNotHaveBombs) {
        this.tilesThatDoNotHaveBombs = tilesThatDoNotHaveBombs;
    }

    /**
     *
     * @return
     */
    public int getxTiles() {
        return xTiles;
    }

    /**
     *
     * @return
     */
    public int getyTiles() {
        return yTiles;
    }
    
    /**
     *
     * @param grid
     */
    public void setGrid(Tile[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    /**
     *
     * @return
     */
    public long[][] getNeighbouringBombs() {
        return neighbouringBombs;
    }

    /**
     *
     * @return
     */
    public boolean isExplosion() {
        return explosion;
    }

    /**
     *
     * @return
     */
    public boolean isFieldClear() {
        return fieldClear;
    }

    /**
     *
     * @return
     */
    public int[][] getBombTiles() {
        return bombTiles;
    }
}
