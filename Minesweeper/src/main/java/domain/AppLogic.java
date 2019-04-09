package domain;

import java.util.ArrayList;
import java.util.List;


public class AppLogic {

    private final int xTiles = 20;
    private final int yTiles = 15;

    private Tile[][] grid = new Tile[xTiles][yTiles];

    boolean explosion = false;

    int tilesThatDoNotHaveBombs = xTiles * yTiles;
    
    long[][] neighbouringBombs = new long[xTiles][yTiles];
    
    public void create() {
        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                boolean putBomb = (Math.random() < 0.1);
                Tile tile = new Tile(x, y, putBomb, this);
                if (putBomb) {
                    int noBombTiles = getTilesThatDoNotHaveBombs();
                    setTilesThatDoNotHaveBombs(--noBombTiles);
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

    public boolean isValidPoint(int x, int y) {
        return (x >= 0 && x < xTiles && y >= 0 && y < yTiles);
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public int getTilesThatDoNotHaveBombs() {
        return tilesThatDoNotHaveBombs;
    }

    public void setTilesThatDoNotHaveBombs(int tilesThatDoNotHaveBombs) {
        this.tilesThatDoNotHaveBombs = tilesThatDoNotHaveBombs;
    }

    public int getxTiles() {
        return xTiles;
    }

    public int getyTiles() {
        return yTiles;
    }
    
    public void setGrid(Tile[][] grid){
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public long[][] getNeighbouringBombs() {
        return neighbouringBombs;
    }
    
    
}
