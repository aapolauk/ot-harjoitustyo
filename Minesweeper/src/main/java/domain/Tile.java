package domain;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Tile extends StackPane {

    private int x, y;
    private final int size = 40;
    public boolean hasBomb;
    public boolean isOpen = false;

    AppLogic logic;

    public final Rectangle square = new Rectangle(size - 2, size - 2);
    public Text text = new Text();

    public Tile(int x, int y, boolean hasBomb, AppLogic logic) {
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;
        this.logic = logic;

        EventHandler<MouseEvent> eventHandler = (MouseEvent event) -> {

            if (event.getButton() == MouseButton.PRIMARY) {
                open();
            }

            if (event.getButton() == MouseButton.SECONDARY && !logic.explosion) {
                flag();
            }
        };
        square.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        square.setStroke(Color.BLUE);
        square.setFill(Color.AQUAMARINE);

        text.setFont(Font.font(18));
        text.setText(hasBomb ? "X" : "");
        text.setVisible(false);

        this.getChildren().addAll(square, text);

        setTranslateX(x * size);
        setTranslateY(y * size);
    }

    void flag() {
        if (!isOpen) {
            square.setFill(Color.RED);
        } else {
            square.setFill(Color.AQUAMARINE);
        }
        isOpen = !isOpen;
    }

    void open() {
        if (logic.explosion) {
            return;
        }
        if (isOpen) {
            return;
        }

        isOpen = true;
        text.setVisible(true);
        square.setFill(null);

        if (text.getText().isEmpty()) {
            logic.getNeighbors(this).forEach(Tile::open);
        }

        if (hasBomb) {
            System.out.println("BOOOM!");
            System.out.println("You lose :[");
            logic.explosion = true;
        }
        
        if (--logic.tilesThatDoNotHaveBombs == 0) {
            System.out.println("You win :]");
            logic.explosion = true;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Text getText() {
        return text;
    }
}
