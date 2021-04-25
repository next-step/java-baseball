import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserSelectOptionTest {
    private UserSelectOption option;

    @Before
    public void setUp(){
        option = new UserSelectOption();
    }

    @Test
    public void selectOptionRestart(){
        assertEquals(option.selectOption("1"), true);
    }

    @Test
    public void selectOptionStop(){
        assertEquals(option.selectOption("2"), false);
    }

}
