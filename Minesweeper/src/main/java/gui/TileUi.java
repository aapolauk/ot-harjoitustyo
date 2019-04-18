package gui;

import domain.*;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TileUi extends StackPane {

    private final int size = 40;
    public Tile tile;
    public final Rectangle square = new Rectangle(size - 2, size - 2);
    public Text text = new Text();
    List<TileUi> neighbours = new ArrayList<>();
    List<TileUi> bombs = new ArrayList<>();
    

    AppLogic logic;

    public TileUi(Tile tile) {
        this.tile = tile;
        this.logic = tile.getLogic();
        

        EventHandler<MouseEvent> eventHandler = (MouseEvent event) -> {
            
            if (event.getButton() == MouseButton.PRIMARY && !logic.isFieldClear()) {
                openUi();
            }

            if (event.getButton() == MouseButton.SECONDARY && !logic.isExplosion() && !logic.isFieldClear()) {
                if (!tile.isMarked) {
                    square.setFill(Color.RED);
                } else {
                    square.setFill(Color.AQUAMARINE);
                }
                tile.mark();
            }
        };
        
        square.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        square.setStroke(Color.BLUE);
        square.setFill(Color.AQUAMARINE);

        text.setFont(Font.font(18));
        text.setText(tile.hasBomb ? "X" : "");
        text.setVisible(false);

        this.getChildren().addAll(square, text);

        setTranslateX(tile.getX() * size);
        setTranslateY(tile.getY() * size);
    }

    public Text getText() {
        return text;
    }

    public void addNeighbour(TileUi tileUi) {
        neighbours.add(tileUi);
    }
    
    public void addBombTiles(TileUi tileUi) {
        bombs.add(tileUi);
    }

    public void openUi() {
        if (this.tile.isMarked || this.logic.isExplosion() || this.tile.isOpen) {
            return;
        }
        
        this.tile.open();
        text.setVisible(true);
        square.setFill(null);
        
        if (text.getText().isEmpty()) {
            for (int i = 0; i < neighbours.size(); i++) {
                neighbours.get(i).openUi();
            }
        }
        
        if (text.getText().equals("X")) {
            
            for (int i = 0; i < bombs.size(); i++) {
                bombs.get(i).openExplosion();       
            }
            showPopupLose();
        }
        
        if (logic.getTilesThatDoNotHaveBombs() == 0) {
            showPopupWin();
        }
        
    }
    
    public void openExplosion() {
        text.setVisible(true);
        square.setFill(null);
    }
    
    public void showPopupWin(){
        Stage pop = new Stage();
        VBox box = new VBox();
        Label label = new Label("You win :]");
        Button button = new Button("Close");
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pop.close();
            }
        };
        button.setOnAction(event);
        
        box.getChildren().add(label);
        box.getChildren().add(button);
        
        box.setPadding(new Insets(10, 10, 10, 10));
        box.setSpacing(10);
        
        Scene newScene = new Scene(box, 100, 100);
        pop.setScene(newScene);
        pop.show();
    }
    
    public void showPopupLose(){
        Stage pop = new Stage();
        VBox box = new VBox();
        Label label = new Label("You lose :[");
        Button button = new Button("Close");
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pop.close();
            }
        };
        button.setOnAction(event);
        
        box.getChildren().add(label);
        box.getChildren().add(button);
        
        box.setPadding(new Insets(10, 10, 10, 10));
        box.setSpacing(10);
        
        Scene newScene = new Scene(box, 100, 100);
        pop.setScene(newScene);
        pop.show();
    }
}
