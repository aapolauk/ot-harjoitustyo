package domain;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AppLogic {

    private final int width = 800;
    private final int height = 600;

    private final int xTiles = 20;
    private final int yTiles = 15;

    private final Tile[][] grid = new Tile[xTiles][yTiles];

    boolean explosion = false;

    int tilesThatDoNotHaveBombs = xTiles * yTiles;

    public Pane createField() {
        Pane root = new Pane();
        root.setPrefSize(width, height);

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                boolean putBomb = (Math.random() < 0.05);
                Tile tile = new Tile(x, y, putBomb, this);
                if (putBomb) {
                    tilesThatDoNotHaveBombs--;
                }

                grid[x][y] = tile;
                root.getChildren().add(tile);
            }
        }

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];

                if (tile.hasBomb) {
                    continue;
                }

                long neighbouringBombs = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();

                if (neighbouringBombs > 0) {
                    tile.getText().setText(String.valueOf(neighbouringBombs));

                    if (neighbouringBombs == 1) {
                        tile.getText().setFill(Color.BLUE);
                    }
                    if (neighbouringBombs == 2) {
                        tile.getText().setFill(Color.GREEN);
                    }
                    if (neighbouringBombs == 3) {
                        tile.getText().setFill(Color.MEDIUMTURQUOISE);
                    }
                    if (neighbouringBombs == 4) {
                        tile.getText().setFill(Color.BROWN);
                    }
                    if (neighbouringBombs == 5) {
                        tile.getText().setFill(Color.DEEPPINK);
                    }
                    if (neighbouringBombs == 6) {
                        tile.getText().setFill(Color.INDIGO);
                    }
                    if (neighbouringBombs == 7) {
                        tile.getText().setFill(Color.ORANGE);
                    }
                    if (neighbouringBombs == 8) {
                        tile.getText().setFill(Color.CRIMSON);
                    }
                }
            }
        }
        return root;
    }

    List<Tile> getNeighbors(Tile tile) {
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

    boolean isValidPoint(int x, int y) {
        return (x >= 0 && x < xTiles && y >= 0 && y < yTiles);
    }

    public Tile[][] getGrid() {
        return grid;
    }
}
