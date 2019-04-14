package domain;


public class Tile{

    private int x, y;
    
    public boolean hasBomb;
    public boolean isOpen = false;
    public boolean isMarked = false;

    AppLogic logic;

    public Tile(int x, int y, boolean hasBomb, AppLogic logic) {
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;
        this.logic = logic;
    }

    public AppLogic getLogic() {
        return logic;
    }
    
    public void mark() {
        isMarked = !isMarked;
    }

    public void open() {
        
        if (isOpen) {
            return;
        }
        if (isMarked) {
            return;
        }

        isOpen = true;
        
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
}
