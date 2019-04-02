
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private int x, y;
    private final int size = 40;
    public boolean hasBomb;
    private boolean isOpen = false;

    private final Rectangle border = new Rectangle(size - 2, size - 2);
    private Text text = new Text();

    public Tile(int x, int y, boolean hasBomb) {
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;
        border.setStroke(Color.RED);
        border.setFill(Color.AQUAMARINE);

        text.setFont(Font.font(18));
        text.setText(hasBomb ? "X" : "");
        text.setVisible(false);

        this.getChildren().addAll(border, text);

        setTranslateX(x * size);
        setTranslateY(y * size);

        setOnMouseClicked(event -> open());
    }
    
    public void open() {
        if (isOpen) return;

        isOpen = true;
        text.setVisible(true);
        border.setFill(null);
        
        if (hasBomb) {
            System.out.println("BOOOM!");
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
