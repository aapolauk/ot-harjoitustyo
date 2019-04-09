package testPackgage;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.*;
import java.util.*;

public class TestAppLogic {

    AppLogic logic;

    Tile[][] testGrid;

    @Before
    public void setUp() {
        logic = new AppLogic();
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
