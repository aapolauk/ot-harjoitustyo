package domain;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SweeperApp extends Application {

    appLogic logic = new appLogic();
    
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(logic.createField());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
