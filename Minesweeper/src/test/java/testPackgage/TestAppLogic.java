package testPackgage;


import domain.appLogic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.*;

public class TestAppLogic {
    
    appLogic logic;
    
    @Before
    public void setUp() {
        logic = new appLogic();
    }
    
    @Test 
    public void numberOfTilesVertically(){
        assertEquals(15, logic.getGrid()[0].length);
    }
    
}
