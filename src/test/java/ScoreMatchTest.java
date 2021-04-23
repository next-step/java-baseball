import domain.Number;
import domain.ScoreMatch;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScoreMatchTest {
    private static ScoreMatch scoreMatch;

    @BeforeAll
    public void setUp() {
        scoreMatch = new ScoreMatch(new Number("523"));
    }

    @Test
    @DisplayName("스트라이크 테스트")
    public void strikeTest() {
        Number number = new Number("511");
        assertFalse(scoreMatch.compare(number));
        assertEquals(scoreMatch.getStrikeCount(), 1);

        number = new Number("523");
        assertTrue(scoreMatch.compare(number));
        assertEquals(scoreMatch.getStrikeCount(), 3);
    }

    @Test
    @DisplayName("볼 테스트")
    public void ballTest() {
        Number number = new Number("156");
        assertFalse(scoreMatch.compare(number));
        assertEquals(scoreMatch.getBallCount(), 1);

        number = new Number("352");
        assertFalse(scoreMatch.compare(number));
        assertEquals(scoreMatch.getBallCount(), 3);
    }

    @Test
    @DisplayName("나싱 테스트")
    public void nothingTest() {
        Number number = new Number("987");
        assertFalse(scoreMatch.compare(number));
        assertEquals(scoreMatch.getStrikeCount(), 0);
        assertEquals(scoreMatch.getBallCount(), 0);
    }
}
