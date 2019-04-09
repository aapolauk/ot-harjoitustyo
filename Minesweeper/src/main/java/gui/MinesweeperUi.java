
package gui;

import domain.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class MinesweeperUi {
    
    AppLogic logic = new AppLogic();
    
    private final int width = 800;
    private final int height = 600;

    private final int xTiles = logic.getxTiles();
    private final int yTiles = logic.getyTiles();

    private final Tile[][] grid = logic.getGrid();
    
    public Pane createField() {
        Pane root = new Pane();
        root.setPrefSize(width, height);
        
        logic.create();

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];
                root.getChildren().add(tile);
            }
        }

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];
                int bombs = (int) logic.getNeighbouringBombs()[x][y];
                if (bombs > 0) {
                    tile.getText().setText(String.valueOf(bombs));

                    if (bombs == 1) {
                        tile.getText().setFill(Color.BLUE);
                    }
                    if (bombs == 2) {
                        tile.getText().setFill(Color.GREEN);
                    }
                    if (bombs == 3) {
                        tile.getText().setFill(Color.MEDIUMTURQUOISE);
                    }
                    if (bombs == 4) {
                        tile.getText().setFill(Color.BROWN);
                    }
                    if (bombs == 5) {
                        tile.getText().setFill(Color.DEEPPINK);
                    }
                    if (bombs == 6) {
                        tile.getText().setFill(Color.INDIGO);
                    }
                    if (bombs == 7) {
                        tile.getText().setFill(Color.ORANGE);
                    }
                    if (bombs == 8) {
                        tile.getText().setFill(Color.CRIMSON);
                    }
                }
            }
        }
        return root;
    }
}
