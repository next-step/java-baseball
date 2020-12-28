import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.RepeatedTest;

public class GameTest {
    public static final int NUM_LENGTH = 3;
    private final Game game = new Game(NUM_LENGTH);

    @RepeatedTest(100)
    void testGenerateNum(){
        String generated = game.generateAnswer();
        assertEquals(generated.length(), NUM_LENGTH);
        for(int i = 0; i < NUM_LENGTH; ++i){
            assertEquals(generated.indexOf(generated.charAt(i), i + 1), -1);
        }
    }
}
