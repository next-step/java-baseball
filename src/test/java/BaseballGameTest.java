import org.junit.Before;

public class BaseballGameTest {
    private BaseballGame baseballGame;

    @Before
    public void setUp(){
        baseballGame = new BaseballGame(3);
    }
}
