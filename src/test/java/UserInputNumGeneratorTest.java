import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInputNumGeneratorTest {
    private UserInputNumGenerator generator;

    @Before
    public void setUp(){
        generator = new UserInputNumGenerator(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void generatorCanValidate(){
        generator.validate("123");
    }

    @Test
    public void validateNotNull(){
        assertEquals(generator.validate("123"), true);
        assertEquals(generator.validate(null), false);
    }
}
