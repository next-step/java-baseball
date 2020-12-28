import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({"123,321,1", "956,956,3", "543,129,0", "829,329,2"})
    void testCountStrikes(String input, String answer, int expected){
        assertEquals(game.countStrikes(input, answer), expected);
    }

    @ParameterizedTest
    @CsvSource({"123,321,2", "956,956,0", "543,129,0", "714,417,2"})
    void testCountBalls(String input, String answer, int expected){
        assertEquals(game.countBalls(input, answer), expected);
    }
}
