package gui;

import domain.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MinesweeperUi {

    AppLogic logic = new AppLogic();
    
    Color[] colors = { Color.BLACK, Color.BLUE, Color.GREEN, Color.MEDIUMTURQUOISE, Color.BROWN, Color.DEEPPINK, Color.INDIGO, Color.ORANGE, Color.CRIMSON };


    VBox root = new VBox();
    GridPane field = new GridPane();

    private final int width = 800;
    private final int height = 630;

    private final int xTiles = logic.getxTiles();
    private final int yTiles = logic.getyTiles();

    private Tile[][] grid = logic.getGrid();
    private TileUi[][] uiGrid = new TileUi[xTiles][yTiles];
    
    Scene scene;

    public MinesweeperUi() {
        scene = new Scene(createScene());
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void createField() {
        logic.create();
        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];
                TileUi tileUi = new TileUi(tile);
                uiGrid[x][y] = tileUi;

                field.getChildren().add(tileUi);

                int bombs = (int) logic.getNeighbouringBombs()[x][y];
                if (bombs > 0) {
                    tileUi.getText().setText(String.valueOf(bombs));
                    tileUi.getText().setFill(colors[bombs]);
                }
            }
        }
        
        for (int x = 0; x < xTiles; x++) {
            for (int y = 0; y < yTiles; y++) {
                for (int x1 = 0; x1 < xTiles; x1++) {
                    for (int y1 = 0; y1 < yTiles; y1++) {
                        if (logic.getBombTiles()[x1][y1] == 1){
                            uiGrid[x][y].addBombTiles(uiGrid[x1][y1]);
                        }
                    }
                }
            }
        }

        for (int x = 0; x < xTiles; x++) {
            for (int y = 0; y < yTiles; y++) {
                int[] coordinates = new int[]{
                    -1, -1,  -1, 0,  -1, 1,  0, -1,   0, 1,  1, -1,  1, 0,  1, 1
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
    }

    public Pane createScene() {
        Button button = new Button("New game");
        
        button.setOnAction((event) -> {
            root.getChildren().clear();
            field.getChildren().clear();
            setLogic(new AppLogic());
            setGrid(logic.getGrid());
            createField();
            root.getChildren().add(button);
            root.getChildren().add(field);
        });

        root.setPrefSize(width, height);

        createField();

        root.getChildren().add(button);
        root.getChildren().add(field);
        
       

        return root;
    }

    public void setLogic(AppLogic logic) {
        this.logic = logic;
    }

    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }

    public VBox getRoot() {
        return root;
    }

    public GridPane getField() {
        return field;
    }
    
    
}
