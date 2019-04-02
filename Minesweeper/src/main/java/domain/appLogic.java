package domain;


import domain.Tile;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class appLogic {
    private final int Width = 800;
    private final int Height = 600;

    private final int xTiles = 20;
    private final int yTiles = 15;

    final Tile[][] grid = new Tile[xTiles][yTiles];
    
    boolean explosion = false;

    public Pane createField() {
        Pane root = new Pane();
        root.setPrefSize(Width, Height);

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = new Tile(x, y, Math.random() < 0.1, this);

                grid[x][y] = tile;
                root.getChildren().add(tile);
            }
        }

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];

                if (tile.hasBomb) continue;

                long bombs = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();

                if (bombs > 0){
                    tile.getText().setText(String.valueOf(bombs));
                    
                    if(bombs == 1) tile.getText().setFill(Color.BLUE);
                    if(bombs == 2) tile.getText().setFill(Color.GREEN);
                    if(bombs == 3) tile.getText().setFill(Color.MEDIUMTURQUOISE);
                    if(bombs == 4) tile.getText().setFill(Color.BROWN);
                    if(bombs == 5) tile.getText().setFill(Color.DEEPPINK);
                    if(bombs == 6) tile.getText().setFill(Color.INDIGO);
                    if(bombs == 7) tile.getText().setFill(Color.ORANGE);
                    if(bombs == 8) tile.getText().setFill(Color.CRIMSON);
                }
            }
        }
        return root;
    }

    List<Tile> getNeighbors(Tile tile) {
        List<Tile> neighbors = new ArrayList<>();

        int[] coordinates = new int[]{
            -1, -1,
            -1, 0,
            -1, 1,
            0, -1,
            0, 1,
            1, -1,
            1, 0,
            1, 1
        };

        for (int i = 0; i < coordinates.length; i++) {
            int x_axis = coordinates[i];
            int y_axis = coordinates[++i];

            int Xnew = tile.getX() + x_axis;
            int Ynew = tile.getY() + y_axis;

            if (isValidPoint(Xnew, Ynew)) {
                neighbors.add(grid[Xnew][Ynew]);
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
