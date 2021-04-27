package baseball;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

    static BaseBallGame bbg;

    @BeforeAll
    public static void setup() throws Exception{
        bbg = new BaseBallGame();
    }
    
    @Test
    public void testComNumNull(){

        bbg.createComNum();
        
        assertNotNull(bbg.comNum);
    }

    @Test
    public void testComNumLength(){

        bbg.createComNum();
        
        assertTrue(bbg.comNum.length == 3);
    }
}
