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
        testGrid = logic.getGrid();
        logic.create();
    }

    @Test
    public void numberOfTilesVertically() {
        assertEquals(15, testGrid[0].length);
    }

    @Test
    public void givesValidPointTest() {
        assertEquals(false, logic.isValidPoint(-1, 0));
        assertEquals(true, logic.isValidPoint(1, 1));
        assertEquals(false, logic.isValidPoint(0, -1));
        assertEquals(false, logic.isValidPoint(-1, -1));
        assertEquals(false, logic.isValidPoint(100, 100));
        assertEquals(false, logic.isValidPoint(-100, 100));
        assertEquals(false, logic.isValidPoint(1, 100));

    }

    @Test
    public void testGetNeighbours() {
        List<Tile> neighbours = logic.getNeighbors(testGrid[0][0]);
        assertEquals(true, neighbours.contains(testGrid[0][1]));   
    }
}
