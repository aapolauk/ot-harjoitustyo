package testPackgage;

import domain.AppLogic;
import domain.Tile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTile {

    public TestTile() {
    }

    Tile tileBomb;
    Tile tileNoBomb;
    AppLogic logic;

    @Before
    public void setUp() {
        logic = new AppLogic();
        tileBomb = new Tile(1, 1, true, logic);
        tileNoBomb = new Tile(0, 0, false, logic);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void markMarks() {
        assertEquals(false, tileBomb.isMarked);
        tileBomb.mark();
        assertEquals(true, tileBomb.isMarked);
        tileBomb.mark();
        assertEquals(false, tileBomb.isMarked);
    }

    @Test
    public void openTileOpensTiles() {
        assertEquals(false, tileNoBomb.isOpen);
        tileNoBomb.open();
        assertEquals(true, tileNoBomb.isOpen);
        tileNoBomb.open();
        assertEquals(true, tileNoBomb.isOpen);
    }

    @Test
    public void openWhileMarked() {
        tileBomb.mark();
        tileBomb.open();
        assertEquals(false, tileBomb.isOpen);
    }

    @Test
    public void explosion() {
        tileNoBomb.open();
        assertEquals(false, logic.isExplosion());
        tileBomb.open();
        assertEquals(true, logic.isExplosion());
    }
}
