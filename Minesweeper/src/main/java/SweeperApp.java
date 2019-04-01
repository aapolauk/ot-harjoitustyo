
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SweeperApp extends Application {

    private final int Width = 800;
    private final int Height = 600;

    private final int xTiles = 20;
    private final int yTiles = 15;

    private final Tile[][] grid = new Tile[xTiles][yTiles];
    private Scene scene;

    private Pane createField() {
        Pane root = new Pane();
        root.setPrefSize(Width, Height);

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = new Tile(x, y, Math.random() < 0.2);

                grid[x][y] = tile;
                root.getChildren().add(tile);
            }
        }

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];

                if (tile.hasBomb) continue;

                long bombs = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();

                if (bombs > 0) tile.getText().setText(String.valueOf(bombs));
            }
        }
        return root;
    }
    
    boolean isValidPoint(int x, int y) {
        return (x >= 0 && x < xTiles && y >= 0 && y < yTiles);
    }

    private List<Tile> getNeighbors(Tile tile) {
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
    
    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(createField());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
