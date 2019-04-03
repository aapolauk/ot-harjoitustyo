package domain;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SweeperApp extends Application {

    appLogic logic = new appLogic();
    Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(logic.createField());
        
        stage.setTitle("Minesweeper");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
