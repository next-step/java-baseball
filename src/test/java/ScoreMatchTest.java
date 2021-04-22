import domain.Number;
import domain.ScoreMatch;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScoreMatchTest {
    private static ScoreMatch scoreMatch;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    public void setUp() {
        System.setOut(new PrintStream(output));
        scoreMatch = new ScoreMatch(new Number("523"));
    }

    @Test
    @DisplayName("스트라이크 테스트")
    public void strikeTest() {
        Number number = new Number("511");
        Assertions.assertFalse(scoreMatch.compare(number));
        scoreMatch.print();
        Assertions.assertTrue(output.toString().contains("1스트라이크"));
        output.reset();

        number = new Number("523");
        Assertions.assertTrue(scoreMatch.compare(number));
        scoreMatch.print();
        Assertions.assertTrue(output.toString().contains("3스트라이크"));
    }
}
