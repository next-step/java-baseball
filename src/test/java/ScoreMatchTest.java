import domain.Number;
import domain.ScoreMatch;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScoreMatchTest {
    private static ScoreMatch scoreMatch;

    @BeforeAll
    public void setUp() {
        scoreMatch = new ScoreMatch(new Number("523"));
    }

    @ParameterizedTest(name = "스트라이크 테스트 - {index}: {0}")
    @CsvSource(value = {"511:1", "523:3"}, delimiter = ':')
    public void strikeTest(String inputNumber, int strikeCount) {
        Number number = new Number(inputNumber);
        scoreMatch.compare(number);
        assertEquals(scoreMatch.getStrikeCount(), strikeCount);
    }

    @ParameterizedTest(name = "볼 테스트 - {index}: {0}")
    @CsvSource(value = {"156:1", "352:3"}, delimiter = ':')
    public void ballTest(String inputNumber, int ballCount) {
        Number number = new Number(inputNumber);
        assertFalse(scoreMatch.compare(number));
        assertEquals(scoreMatch.getBallCount(), ballCount);
    }

    @ParameterizedTest(name = "나싱 테스트 - {index}: {0}")
    @ValueSource(strings = {"987"})
    public void nothingTest(String inputNumber) {
        Number number = new Number(inputNumber);
        assertFalse(scoreMatch.compare(number));
        assertEquals(scoreMatch.getStrikeCount(), 0);
        assertEquals(scoreMatch.getBallCount(), 0);
    }
}
