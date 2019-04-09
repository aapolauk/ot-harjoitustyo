package testPackgage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.*;
import gui.MinesweeperUi;
import java.util.*;

public class TestAppLogic {

    AppLogic logic;

    Tile[][] testGrid;

    @Before
    public void setUp() {
        logic = new AppLogic();
//        testGrid = new Tile[logic.getxTiles()][logic.getyTiles()];
//        for (int i = 0; i < testGrid[0].length; i++) {
//            for (int j = 0; j < testGrid.length; j++) {
//                testGrid[i][j] = new Tile(i, j, true, logic);
//            }
//        }
//        logic.setGrid(testGrid);
    }

    @Test
    public void numberOfTilesVertically() {
        assertEquals(15, logic.getGrid()[0].length);
    }

    @Test
    public void givesValidPointFalse() {
        assertEquals(false, logic.isValidPoint(-1, 0));
    }

    @Test
    public void givesValidPointTrue() {
        assertEquals(true, logic.isValidPoint(1, 1));
    }

//    @Test
//    public void getNeighborsWorksBadTest() {
//        Tile tile = logic.getGrid()[2][2];
//        assertEquals(new ArrayList<>(), logic.getNeighbors(tile));
//    }

}
