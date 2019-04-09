package domain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.MinesweeperUi;


public class SweeperApp extends Application {

    MinesweeperUi ui = new MinesweeperUi();
    Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        scene = new Scene(ui.createField());
        stage.setTitle("Minesweeper");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
