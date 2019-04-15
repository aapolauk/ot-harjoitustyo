package domain;

import javafx.application.Application;
import javafx.stage.Stage;
import gui.MinesweeperUi;


public class SweeperApp extends Application {

    MinesweeperUi ui = new MinesweeperUi();
    
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("Minesweeper");
        stage.setScene(ui.getScene());
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
