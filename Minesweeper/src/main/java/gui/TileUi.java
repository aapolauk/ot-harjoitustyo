package gui;

import domain.*;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TileUi extends StackPane {

    private final int size = 40;
    public Tile tile;
    public final Rectangle square = new Rectangle(size - 2, size - 2);
    public Text text = new Text();
    List<TileUi> neighbours = new ArrayList<>();

    AppLogic logic;

    public TileUi(Tile tile) {
        this.tile = tile;
        this.logic = tile.getLogic();
        

        EventHandler<MouseEvent> eventHandler = (MouseEvent event) -> {
            
            if (event.getButton() == MouseButton.PRIMARY && !logic.isExplosion() && !logic.isFieldClear()) {
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
    }
}
