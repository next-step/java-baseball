import org.junit.Before;
import org.junit.Test;

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
}
