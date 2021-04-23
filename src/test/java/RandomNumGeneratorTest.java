import org.junit.Test;
import org.junit.Before;

public class RandomNumGeneratorTest {

    private RandomNumGenerator generator;

    @Before
    public void setUp(){
        generator = new RandomNumGenerator(BaseballGame.DEFAULT_LEN);
    }
}
