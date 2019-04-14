package gui;

import domain.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MinesweeperUi {

    AppLogic logic = new AppLogic();

    private final int width = 800;
    private final int height = 600;

    private final int xTiles = logic.getxTiles();
    private final int yTiles = logic.getyTiles();

    private final Tile[][] grid = logic.getGrid();
    private final TileUi[][] uiGrid = new TileUi[xTiles][yTiles];
    Scene scene;

    public MinesweeperUi() {
        scene = new Scene(createField());
    }

    public Scene getScene() {
        return scene;
    }

    public Pane createField() {
        Pane root = new Pane();
        root.setPrefSize(width, height);

        logic.create();

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];
                TileUi tileUi = new TileUi(tile);
                uiGrid[x][y] = tileUi;

                root.getChildren().add(tileUi);

                int bombs = (int) logic.getNeighbouringBombs()[x][y];
                if (bombs > 0) {
                    tileUi.getText().setText(String.valueOf(bombs));

                    if (bombs == 1) {
                        tileUi.getText().setFill(Color.BLUE);
                    }
                    if (bombs == 2) {
                        tileUi.getText().setFill(Color.GREEN);
                    }
                    if (bombs == 3) {
                        tileUi.getText().setFill(Color.MEDIUMTURQUOISE);
                    }
                    if (bombs == 4) {
                        tileUi.getText().setFill(Color.BROWN);
                    }
                    if (bombs == 5) {
                        tileUi.getText().setFill(Color.DEEPPINK);
                    }
                    if (bombs == 6) {
                        tileUi.getText().setFill(Color.INDIGO);
                    }
                    if (bombs == 7) {
                        tileUi.getText().setFill(Color.ORANGE);
                    }
                    if (bombs == 8) {
                        tileUi.getText().setFill(Color.CRIMSON);
                    }
                }
            }
        }

        for (int x = 0; x < xTiles; x++) {
            for (int y = 0; y < yTiles; y++) {
                int[] coordinates = new int[]{
                    -1, -1,   -1, 0,   -1, 1,   0, -1,   0, 1,   1, -1,   1, 0,   1, 1
                };

                for (int i = 0; i < coordinates.length; i++) {
                    int xAxis = coordinates[i];
                    int yAxis = coordinates[++i];
                    int xNew = x + xAxis;
                    int yNew = y + yAxis;
                    if (logic.isValidPoint(xNew, yNew)) {
                        uiGrid[x][y].addNeighbour(uiGrid[xNew][yNew]);
                    }
                }
            }
        }
        
        return root;
    }

}
