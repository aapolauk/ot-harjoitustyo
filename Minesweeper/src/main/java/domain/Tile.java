package domain;


public class Tile implements Comparable<Tile> {

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
        if (isMarked) {
            return;
        }

        isOpen = true;
        
        if (hasBomb) {
            System.out.println("BOOOM!");
            System.out.println("You lose :[");
            logic.explosion = true;
            return;
        }
        
        if (--logic.tilesThatDoNotHaveBombs == 0) {
            System.out.println("You win :]");
            logic.fieldClear = true;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Tile o) {
        int compX = Integer.compare(o.getX(), this.x);
        int compY = Integer.compare(o.getY(), this.y);
        if(compY == 1 && compX == 1){
            return 0;
        }
        return 1;
    }
}
